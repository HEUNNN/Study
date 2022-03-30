import Router from 'koa-router';
import posts from './posts';
import auth from './auth';
import tests from './tests';

const api = new Router();
const authRouters = auth.routes();
console.log(authRouters);
api.use('/posts', posts.routes());
api.use('/auth', authRouters);
api.use('/tests', tests.routes());

//router 내보내기
export default api;
