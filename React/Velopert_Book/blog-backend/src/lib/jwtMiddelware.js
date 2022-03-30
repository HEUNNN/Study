import jwt from 'jsonwebtoken';

const jwtMiddleware = (ctx, next) => {
  const token = ctx.cookies.get('access_token');
  if (!token) return next(); // 토큰이 없음
  try {
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    ctx.state.user = {
      _id: decoded._id,
      username: decoded.username,
    };
    console.log(decoded);
    return next();
  } catch (e) {
    //토큰 검증 실패
    return next();
  }
};
export default jwtMiddleware;
//미들웨어를 만들고, main.js에서 app에 미들웨어를 적용한다.
//app에 router 미들웨어를 적용하기 전에 이루어져야한다.
