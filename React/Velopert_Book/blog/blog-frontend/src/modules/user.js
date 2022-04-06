import createRequestSaga, {
	createRequestActionTypes,
} from '../lib/createRequestSaga';
import { createAction } from 'redux-actions';
import * as authAPI from '../lib/api/auth';
import { takeLatest } from 'redux-saga/effects';
import { handleActions } from 'redux-actions';

//액션 타입 정의
const TEMP_SET_USER = 'user/TEMP_SET_USER'; // 새로고침 이후 임시 로그인 처리
const [CHECK, CHECK_SUCCESS, CHECK_FAILURE] =
	createRequestActionTypes('user/CHECK');

//액션 생성 함수
export const tempSetUser = createAction(TEMP_SET_USER, (user) => user);
export const check = createAction(CHECK);

const checkSaga = createRequestSaga(CHECK, authAPI.check);

function checkFailureSaga() {
	try {
		localStorage.remove('user');
	} catch (e) {
		console.log('loacalStorage is not working');
	}
}

export function* userSaga() {
	yield takeLatest(CHECK, checkSaga);
	yield takeLatest(CHECK_FAILURE, checkFailureSaga);
}

const initialState = {
	user: null,
	checkError: null,
};

export default handleActions(
	{
		[TEMP_SET_USER]: (state, { payload: user }) => ({
			...state,
			user,
		}),
		[CHECK_SUCCESS]: (state, { payload: user }) => ({
			...state,
			user, // createRequestSaga의 put 부분에서 response.data를 payload로 넘겨준다.
			checkError: null,
		}),
		[CHECK_FAILURE]: (state, { payload: error }) => ({
			...state,
			user: null,
			checkError: error,
		}),
	},
	initialState,
);
