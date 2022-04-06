import client from './client';

// API 함수 작성
//로그인
export const login = ({ username, password }) =>
	client.post('/api/auth/login', { username, password });
// Postman으로 login post 요청 보낼 때 body부분에 username, password 값을 직접 넣어주었다.
// axios를 사용하여 백엔드와 API 연동을 할 때, 백엔드 post/login에서 필요한 username, password를 넘겨준다.

//회원가입
export const register = ({ username, password }) =>
	client.post('/api/auth/register', { username, password });

// 로그인 상태 확인
export const check = () => client.get('/api/auth/check');

//로그아웃
export const logout = () => client.post('/api/auth/logout');
