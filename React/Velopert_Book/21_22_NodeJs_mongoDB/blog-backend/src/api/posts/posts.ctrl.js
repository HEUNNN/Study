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

export const read = (ctx) => {};

export const remove = (ctx) => {};

export const updata = (ctx) => {};
