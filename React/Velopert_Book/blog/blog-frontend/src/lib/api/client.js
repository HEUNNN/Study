import axios from 'axios';

const client = axios.create();

//API 주소를 다른 곳으로 사용함
client.defaults.baseURL = 'https://external-api-sever.com/';
//헤더 설정
client.defaults.headers.common['Authorization'] = 'Bearer a1b2c3d4';
//인터셉터 설정
//인터셉터: then 이나 catch로 처리되기 전에 요청이나 응답을 가로챌 수 있다.
axios.intercepter.response.use(
	(response) => {
		// 요청 성공 시 특정 작업 수행
		return response;
	},
	(error) => {
		// 요청 실패 시 특정 작업 수행
		return Promise.reject(error);
	},
);

export default client;
