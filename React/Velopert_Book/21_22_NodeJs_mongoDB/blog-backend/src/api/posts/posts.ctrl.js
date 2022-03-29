import Post from '../../models/post'; //model
import mongoose from 'mongoose';
import Joi from 'joi';

//id 검증을 위한 미들웨어
const { ObjectId } = mongoose.Types;
export const checkObjectId = (ctx, next) => {
  const { id } = ctx.params;
  if (!ObjectId.isValid(id)) {
    ctx.status = 400; //bad request
    return;
  }
  return next(); //미들웨어에서 next()를 안해주면 다음으로 안넘어가진다.
};

/* POST /api/posts */
export const write = async (ctx) => {
  const schema = Joi.object().keys({
    // 객체가 다음 필드를 가지고 있음을 검증
    title: Joi.string().required(), //required()가 있으면 필수 항목
    body: Joi.string().required(),
    tags: Joi.array().items(Joi.string()).required(), //문자로 이루어진 배열
  });

  //검증하고 나서 검증 실패인 경우 에러 처리
  const result = schema.validate(ctx.request.body);
  if (result.error) {
    ctx.status = 400;
    ctx.body = result.error;
    return;
  }

  //REST API의 Request Body는 ctx.request.body에서 조회할 수 있다.
  const { title, body, tags } = ctx.request.body;
  const post = new Post({
    title,
    body,
    tags,
  });
  try {
    await post.save(); //데이터베이스에 저장 -> save()
    ctx.body = post;
  } catch (e) {
    ctx.throw(500, e);
  }
};

/* GET /api/posts */
export const list = async (ctx) => {
  // query는 문자열이기 때문에 숫자로 변환해주어야 한다.
  // 값이 주어지지 않았다면 1을 기본으로 사용한다.
  const page = parseInt(ctx.query.page || '1', 10);

  if (page < 1) {
    ctx.status = 400;
    return;
  }

  try {
    const posts = await Post.find()
      .sort({ _id: -1 })
      .limit(10)
      .skip((page - 1) * 10)
      .lean()
      .exec();

    const postCount = await Post.countDocuments().exec();
    ctx.set('Last-page', Math.ceil(postCount / 10));
    ctx.body = posts.map((post) => ({
      ...post,
      body:
        post.body.length < 200 ? post.body : `${post.body.slice(0, 200)}...`,
    }));
  } catch (e) {
    ctx.throw(500, e);
  }
};

/* GET /api/posts/:id */
export const read = async (ctx) => {
  const { id } = ctx.params;
  try {
    const post = await Post.findById(id).exec();
    if (!post) {
      ctx.status = 404;
      return;
    }
    ctx.body = post;
  } catch (e) {
    ctx.throw(e);
  }
};

/* DELETE /api/posts/:id */
export const remove = async (ctx) => {
  const { id } = ctx.params;
  try {
    await Post.findByIdAndRemove(id).exec();
    ctx.status = 204; //No content (remove 작업 성공은 하였지만 응답할 데이터는 없음)
  } catch (e) {
    ctx.throw(e);
  }
};

export const update = async (ctx) => {
  const schema = Joi.object().keys({
    // 객체의 필드 type이 지켜지는지 검증
    title: Joi.string(),
    body: Joi.string(),
    tags: Joi.array().items(Joi.string()), //문자로 이루어진 배열
  });

  //검증하고 나서 검증 실패인 경우 에러 처리
  const result = schema.validate(ctx.request.body);
  if (result.error) {
    ctx.status = 400;
    ctx.body = result.error;
    return;
  }

  const { id } = ctx.params;
  try {
    const post = await Post.findByIdAndUpdate(id, ctx.request.body, {
      new: true, // 이 값을 설정하면 업데이트된 데이터를 반환한다.
    }).exec();
    if (!post) {
      ctx.status = 404;
      return;
    }
    ctx.body = post;
  } catch (e) {
    ctx.throw(500, e);
  }
};
