import Joi from 'joi';
import User from '../../models/user';

/* 
    POST /api/auth/register
    {
        username: 'hyeeun',
        password: 'mypass123'
    }
*/
export const register = async (ctx) => {
  // 회원가입
  //Request Body 검증하기
  const schema = Joi.object().keys({
    //POST로 넘겨받은 user Schema -> hashedPassword가 아닌 사용자가 입력한 pure한 PW
    username: Joi.string().alphanum().min(3).max(20).required(),
    password: Joi.string().required(),
  });
  const result = schema.validate(ctx.request.body);
  if (result.error) {
    ctx.status = 400;
    ctx.body = result.error;
    return;
  }
  // Requst Body 검증 끝

  // User 모델을 사용하여 Request Body 값을 반영한 user 문서 인스턴스 만들기
  // request body는 Postman이나 frontend 단에서 API 요청시 보내주는 data
  const { username, password } = ctx.request.body;
  try {
    //username이 이미 존재하는지 확인
    const exists = await User.findByUsername(username);
    if (exists) {
      ctx.status = 409; // Conflict
      return;
    }

    const user = new User({
      // User에는 username, hashedPassword 필드가 있다.
      username,
    });
    await user.setPassword(password); // 비밀번호 설정
    await user.save(); // 데이터베이스에 저장

    // 응답할 데이터에서 hashedPassword 필드 제거
    ctx.body = user.serialize();

    //Token
    const token = user.generateToken();
    //생성한 토큰을 쿠키에 담아서 사용
    ctx.cookies.set('access_token', token, {
      maxAge: 1000 * 60 * 60 * 24 * 7, //7일
      httpOnly: true,
    });
  } catch (e) {
    ctx.throw(500, e);
  }
};
/*
    POST /api/auth/login
    {
        username: 'hyeeun',
        password: 'mypass'
    }
*/
export const login = async (ctx) => {
  // 로그인
  const { username, password } = ctx.request.body;
  // username, password 가 없으면 에러 처리
  if (!username || !password) {
    ctx.status = 401; //Unauthorized
    return;
  }
  try {
    const user = await User.findByUsername(username); // 스태틱 메서드
    if (!user) {
      ctx.status = 401;
      return;
    }
    const valid = await user.checkPassword(password); // 인스턴스 메서드
    if (!valid) {
      ctx.status = 401;
      return;
    }

    // 응답할 데이터에서 hashedPassword 필드 제거
    ctx.body = user.serialize();

    //Token
    const token = user.generateToken();
    //생성한 토큰을 쿠키에 담아서 사용
    ctx.cookies.set('access_token', token, {
      maxAge: 1000 * 60 * 60 * 24 * 7, //7일
      httpOnly: true,
    });
  } catch (e) {
    ctx.throw(500, e);
  }
};
/*
    GET /api/auth/check
*/
export const check = async (ctx) => {
  // 로그인 상태 확인
  const { user } = ctx.state;
  if (!user) {
    //로그인 중이 아님
    ctx.status = 401; // Unauthorized
    return;
  }
  ctx.body = user;
};

/*
  POST /api/auth/logout
*/
export const logout = async (ctx) => {
  // 로그아웃
  ctx.cookies.set('access_token');
  ctx.status = 204; // No Content
};
