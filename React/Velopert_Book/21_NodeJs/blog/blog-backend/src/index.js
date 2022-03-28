const Koa = require('koa');
const Router = require('koa-router'); //Router 인스턴스

const bodyParser = require('koa-bodyparser');

const api = require('./api');

const app = new Koa(); //위에서 koa를 Koa로 require 하였고, 그 상수 Koa 를 가져다 쓴 것이다.
const router = new Router(); //위에서 koa-router를 require 해 온 Router를 의미한다.

//라우터 설정
router.use('/api', api.routes()); //api 라우트 적용

// 라우터 적용 전에 bodyparser 적용
app.use(bodyParser());

app.use(router.routes()).use(router.allowedMethods());

app.listen(4000, () => {
  console.log('Listening to port 4000');
});
