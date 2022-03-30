import Router from 'koa-router';
const tests = new Router();

tests.get('/', (ctx) => {
  console.log('hello');
  return 'hello';
});

export default tests;
