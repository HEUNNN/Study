import Post from '../../models/post'; //model

/* POST /api/posts */
export const write = async (ctx) => {
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
  try {
    const posts = await Post.find().exec();
    ctx.body = posts;
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

export const updata = (ctx) => {};
