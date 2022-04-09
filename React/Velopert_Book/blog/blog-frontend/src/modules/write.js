import {
	createAction,
	handleActions,
} from '../../node_modules/redux-actions/lib/index';
import createRequestSaga, {
	createRequestActionTypes,
} from '../lib/createRequestSaga';
import * as postsAPI from '../lib/api/posts';
import { takeLatest } from 'redux-saga/effects';

const INITIALIZE = 'write/INITIALIZE'; // 모든 내용 초기화
const CHANGE_FIELD = 'write/CHANGE_FIELD'; // 특정 key 값 바꾸기
// key: title, body, tag ..

// 수정 기능을 위한 액션 선언
const SET_ORIGINAL_POST = 'write/SET_ORIGINAL_POST';
const [UPDATE_POST, UPDATE_POST_SUCCESS, UPDATE_POST_FAILURE] =
	createRequestActionTypes('write/UPDATE_POST');

//API 연동을 위한 액션 정의
const [WRITE_POST, WRITE_POST_SUCCESS, WRITE_POST_FAILURE] =
	createRequestActionTypes('write/WRITE_POST');

export const initialize = createAction(INITIALIZE);
export const changeField = createAction(CHANGE_FIELD, ({ key, value }) => ({
	key,
	value,
}));
export const writePost = createAction(WRITE_POST, ({ title, body, tags }) => ({
	title,
	body,
	tags,
}));

// 수정 기능을 위한 액션 선언
export const setOriginalPost = createAction(SET_ORIGINAL_POST, (post) => post);
export const updatePost = createAction(
	UPDATE_POST,
	({ id, title, body, tags }) => ({
		id,
		title,
		body,
		tags,
	}),
);

/* 
backend의 posts.ctrl의 write 부분을 보면 post를 DB에 저장완료 후 ctx.body에 post를 대입해준다.
즉 POST /api/posts에 요청을 보내고 받은 응답에는 post가 들어있다.
*/

//비동기 작업 관리를 위한 Redux saga
const writePostSaga = createRequestSaga(WRITE_POST, postsAPI.writePost);

// 수정 기능을 위한 Redux saga
const updatePostSaga = createRequestSaga(UPDATE_POST, postsAPI.updatePost);

export function* writeSaga() {
	yield takeLatest(WRITE_POST, writePostSaga);
	yield takeLatest(UPDATE_POST, updatePostSaga);
}

const initialState = {
	title: '', // 프론트의 title, body, tags 의 state 관리 부분 -> API 연동 시 보내 줄 프론트단의 state 데이터
	body: '',
	tags: [],
	post: null, // 백엔드를 거쳐 DB에 {title, body, tags}를 저장하고 얻은 응답 데이터를 보관
	postError: null,
	originalPostId: null,
};

const write = handleActions(
	{
		[INITIALIZE]: (state) => initialState,
		[CHANGE_FIELD]: (state, { payload: { key, value } }) => ({
			...state,
			[key]: value, // 특정 key 값을 업데이트
		}),
		[WRITE_POST]: (state) => ({
			...state,
			post: null,
			postError: null, // post와 postError 값을 초기화
			// RegisterForm, LoginForm 컨테이너에서는 렌더링될 때 초기화 한다.
		}),
		[WRITE_POST_SUCCESS]: (state, { payload: post }) => ({
			// 리덕스 사가를 사용하여 API 요청 후 받은 응답이 payload에 담겨서 전달된다.
			// POST /api/posts에 요청에 대한 응답은 post가 돌아온다
			...state,
			post,
		}),
		[WRITE_POST_FAILURE]: (state, { payload: postError }) => ({
			...state,
			postError,
		}),
		[SET_ORIGINAL_POST]: (state, { payload: post }) => ({
			...state,
			title: post.title,
			body: post.body,
			tags: post.tags,
			originalPostId: post._id,
		}),
		[UPDATE_POST_SUCCESS]: (state, { payload: post }) => ({
			...state,
			post,
		}),
		[UPDATE_POST_FAILURE]: (state, { payload: postError }) => ({
			...state,
			postError,
		}),
	},
	initialState,
);

export default write;
