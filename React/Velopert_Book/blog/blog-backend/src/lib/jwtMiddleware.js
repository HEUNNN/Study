import jwt from 'jsonwebtoken';
import User from '../models/user';

const jwtMiddleware = async (ctx, next) => {
  const token = ctx.cookies.get('access_token');
  if (!token) return next(); // 토큰이 없음
  try {
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    ctx.state.user = {
      _id: decoded._id,
      username: decoded.username,
    };
    // 토큰의 남은 유효기간이 3.5일 미만이면 재발급
    const now = Math.floor(Date.now() / 1000);
    if (decoded.exp - now < 60 * 60 * 24 * 3.5) {
      const user = await User.findById(decoded._id); // User 모델에서 id에 해당하는 user 인스턴스 찾아서
      const token = user.generateToken(); // 토큰 (재)발급시 사용한다.
      // 재발급한 토큰을 쿠키에 담아서 사용
      ctx.cookies.set('access_token', token, {
        maxAge: 1000 * 60 * 60 * 24 * 7, // 7일
        httpOnly: true,
      });
    }
    return next();
  } catch (e) {
    //토큰 검증 실패
    return next();
  }
};
export default jwtMiddleware;
//미들웨어를 만들고, main.js에서 app에 미들웨어를 적용한다.
//app에 router 미들웨어를 적용하기 전에 이루어져야한다.
