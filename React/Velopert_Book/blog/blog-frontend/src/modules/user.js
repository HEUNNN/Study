import createRequestSaga, {
	createRequestActionTypes,
} from '../lib/createRequestSaga';
import { createAction } from 'redux-actions';
import * as authAPI from '../lib/api/auth';
import { takeLatest, call } from 'redux-saga/effects';
import { handleActions } from 'redux-actions';

//액션 타입 정의
const TEMP_SET_USER = 'user/TEMP_SET_USER'; // 새로고침 이후 임시 로그인 처리
const [CHECK, CHECK_SUCCESS, CHECK_FAILURE] =
	createRequestActionTypes('user/CHECK');
const LOGOUT = 'user/LOGOUT';

//액션 생성 함수
export const tempSetUser = createAction(TEMP_SET_USER, (user) => user);
export const check = createAction(CHECK);

export const logout = createAction(LOGOUT);

const checkSaga = createRequestSaga(CHECK, authAPI.check);

function checkFailureSaga() {
	try {
		localStorage.remove('user');
	} catch (e) {
		console.log('loacalStorage is not working');
	}
}

function* logoutSaga() {
	// register, login, check API 요청과 다르다.
	try {
		yield call(authAPI.logout); // logout API 호출
		localStorage.removeItem('user'); // localStorage 에서 user 제거
	} catch (e) {
		console.log(e);
	}
}

export function* userSaga() {
	yield takeLatest(CHECK, checkSaga);
	yield takeLatest(CHECK_FAILURE, checkFailureSaga);
	yield takeLatest(LOGOUT, logoutSaga);
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
		[LOGOUT]: (state) => ({
			...state,
			user: null,
		}),
	},
	initialState,
);
