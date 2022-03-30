require('dotenv').config();
import Koa from 'koa';
import Router from 'koa-router';
import bodyParser from 'koa-bodyparser';
import mongoose from 'mongoose';
import createFakeData from './createFakeData';

import api from './api';
import jwtMiddleware from './lib/jwtMiddleware';

const app = new Koa();
const router = new Router();

const { PORT, MONGO_URI } = process.env;

mongoose
  .connect(MONGO_URI)
  .then(() => {
    console.log('Connected to MongoDB');
  })
  .catch((e) => {
    console.error(e);
  });

//라우터 설정
router.use('/api', api.routes()); //api 라우트 적용

// 라우터 적용 전에 bodyparser 적용
app.use(bodyParser());
app.use((ctx, next) => {
  console.log(ctx);
  next();
});
//app.use(jwtMiddleware); // token 검증 미들웨어

app.use(router.routes()).use(router.allowedMethods());

const port = PORT || 4000;
app.listen(port, () => {
  console.log('Listening to port %d', port);
});
