import client from './client';

export const writePost = ({ title, body, tags }) =>
	client.post('/api/posts', { title, body, tags }); // write

// backend의 api/posts/index.js를 보면
// posts 목록 조회(list),특정 게시물 조회(read), 작성(write), 수정(update), 제거(remove)는
// 리소스와 id 를 조합하여 URI를 만든다. 즉, api/posts와 method 종류 id 유무에 따라 5가지 api 요청이 구분된다.
// api/auth/index.js 는 리소스와 행위까지 URI에 추가된다.
// api/auth/register 와 같이 행위 register가 추가되어 있음
