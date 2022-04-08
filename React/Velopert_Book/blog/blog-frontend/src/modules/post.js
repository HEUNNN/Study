import { createAction } from 'redux-actions';
import createRequestSaga, {
	createRequestActionTypes,
} from '../lib/createRequestSaga';
import * as postsAPI from '../lib/api/posts';
import { takeLatest } from 'redux-saga/effects';
import { handleActions } from '../../node_modules/redux-actions/lib/index';

const [READ_POST, READ_POST_SUCCESS, READ_POST_FAILURE] =
	createRequestActionTypes('post/READ_POST');
const UNLOAD_POST = 'post/UNLOAD_POST'; // 포스트 페이지에서 벗어날 때 데이터 비우기

export const readPost = createAction(READ_POST, (id) => id); // 위 액션이 dispatch 되면 readPostSaga가 실행되고, createRequestSaga에서 call할 때 action.payload로 id를 사용한다.
export const unloadPost = createAction(UNLOAD_POST); // 아마 unmount 시 사용할 액션으로, post 컨테이너에서 설정할 듯

const readPostSaga = createRequestSaga(READ_POST, postsAPI.readPost);
export function* postSaga() {
	yield takeLatest(READ_POST, readPostSaga);
}

const initialState = {
	post: null, // 서버에 read 요청을 하고, 서버가 DB에도 저장한 post 내용을 응답으로 보내준다. modules/write는 title, body, tags 내용을 프론트엔드에서 state 에 넣어 write API 요청으로 서버에 보내주고 응답으로 post를 받게 된다. 여기서 받는 post랑 같은 데이터
	error: null,
};
const post = handleActions(
	{
		[READ_POST_SUCCESS]: (state, { payload: post }) => ({
			// createRequestsaga에서 액션 생성 함수를 사용하지 않고 직접 생성한 액션{type: READ_POST_SUCCESS, payload: response.data }으로 디스패치한다.
			...state,
			post,
		}),
		[READ_POST_FAILURE]: (state, { payload: error }) => ({
			...state,
			error,
		}),
		[UNLOAD_POST]: () => ({
			initialState,
		}),
	},
	initialState,
);
export default post;
