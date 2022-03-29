let postId = 1; //id의 초깃값

//posts 배열 초기 데이터
const posts = [
  {
    id: 1,
    title: '제목',
    body: '내용',
  },
];

/* 포스트 작성
POST /api/posts
{ title, body }
*/
export const write = (ctx) => {
  //REST API의 Request Body는 ctx.request.body에서 조회할 수 있다.
  const { title, body } = ctx.request.body;
  postId += 1;
  const post = { id: postId, title, body };
  posts.push(post);
  ctx.body = post;
};
/* 포스트 목록 조회
GET /api/posts
*/
export const list = (ctx) => {
  ctx.body = posts;
};
/* 특정 포스트 조회
GET /api/posts/:id
*/
export const read = (ctx) => {
  const id = ctx.params.id;
  // 주어진 id 값으로 post를 찾는다.
  // params로 받아온 값은 문자열 형식이므로 형변환이 필요하다.
  const post = posts.find((post) => post.id === parseInt(id));
  if (!post) {
    ctx.status = 404;
    ctx.body = {
      message: '포스트가 존재하지 않습니다.',
    };
    return;
  }
  ctx.body = post;
};
/* 특정 포스트 제거
DELETE /api/posts/:id
*/
export const remove = (ctx) => {
  const { id } = ctx.params;
  const targetIdx = posts.findIndex((post) => post.id === parseInt(id));
  if (targetIdx === -1) {
    ctx.status = 404;
    ctx.body = {
      message: '포스트가 존재하지 않습니다.',
    };
    return;
  }
  //targetIdx 번째 아이템을 제거한다.
  posts.splice(targetIdx, 1);
  ctx.status = 204; //No content
};
/* 특정 포스트 수정(교체)
PUT /api/posts/:id
{ title, body }
*/
export const replace = (ctx) => {
  // PUT 메서드는 전체 포스트 정보를 입력하여 데이터를 통째로 교체할 때 사용한다.
  const { id } = ctx.params;
  //해당 id를 가진 post의 index를 확인한다.
  const targetIdx = posts.findIndex((post) => post.id === parseInt(id));
  if (targetIdx === -1) {
    ctx.status = 404;
    ctx.body = {
      message: '포스트가 존재하지 않습니다.',
    };
    return;
  }
  //id를 제외한 기본 정보를 날리고, 객체를 새로 만든다.
  posts[targetIdx] = {
    id,
    ...ctx.request.body,
  };
  ctx.body = posts[targetIdx];
};
/* 특정 포스트 수정(특정 필드 변경)
PATCH /api/posts/:id
{ title, body }
*/
export const updata = (ctx) => {
  //PATCH 메서드는 주어진 필드만 교체한다.
  const { id } = ctx.params;
  const targetIdx = posts.findIndex((post) => post.id === parseInt(id));
  if (targetIdx === -1) {
    ctx.status = 404;
    ctx.body = {
      message: '포스트가 존재하지 않습니다.',
    };
    return;
  }
  //기존 값에 정보를 덮어 씌운다.
  posts[targetIdx] = {
    ...posts[targetIdx],
    ...ctx.request.body,
  };
  ctx.body = posts[targetIdx];
};
