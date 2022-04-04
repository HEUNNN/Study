import { createAction, handleActions } from 'redux-actions';
import createRequestSaga, {
	createRequestActionTypes,
} from '../lib/createRequestSaga';
import * as authAPI from '../lib/api/auth';
import { takeLatest } from 'redux-saga/effects';
import produce from 'immer';

//액션 타입 정의
// 로그인, 회원가입 폼에 text를 입력할 때 상태를 관리하기 위한 액션 타입
const CHANGE_FIELD = 'auth/CHANGE_FIELD';
const INITIALIZE_FORM = 'auth/INITIALIZE_FORM';

//API 요청을 보내고 응답을 받아 온 상태를 관리하기 위한 액션 타입
const [REGISTER, REGISTER_SUCCESS, REGISTER_FAILURE] =
	createRequestActionTypes('auth/REGISTER');
const [LOGIN, LOGIN_SUCCESS, LOGIN_FAILURE] =
	createRequestActionTypes('auth/LOGIN');

//액션 생성 함수 정의
// 로그인, 회원가입 폼에 text를 입력할 때 상태를 관리하기 위한 액션 생성 함수
export const changeField = createAction(
	CHANGE_FIELD,
	({ form, key, value }) => ({
		// action.payload로 사용할 수 있다.
		// action의 payload 부분은 컨테이너 컴포넌트에서 넘겨준다.
		form,
		key,
		value,
	}),
);
export const initializeForm = createAction(INITIALIZE_FORM, (form) => form);

//API 요청을 보내고 응답을 받아 온 상태를 관리하기 위한 액션 생성 함수
export const register = createAction(REGISTER, ({ username, password }) => ({
	username,
	password,
}));
export const login = createAction(LOGIN, ({ username, password }) => ({
	username,
	password,
}));

//사가 생성
const registerSaga = createRequestSaga(REGISTER, authAPI.register);
const loginSaga = createRequestSaga(LOGIN, authAPI.login);
export function* authSaga() {
	yield takeLatest(REGISTER, registerSaga);
	yield takeLatest(LOGIN, loginSaga);
}
//리듀서 정의
// 초기값 미리 설정해줘야 한다.
const initialState = {
	register: {
		username: '',
		password: '',
		passwordConfirm: '',
	},
	login: {
		username: '',
		password: '',
	},
	auth: null,
	authError: null,
};

const auth = handleActions(
	{
		[CHANGE_FIELD]: (state, { payload: { form, key, value } }) =>
			produce(state, (draft) => {
				draft[form][key] = value; // 예: state.register.usernmae을 바꾼다.
			}),
		[INITIALIZE_FORM]: (state, { payload: form }) => ({
			...state,
			[form]: initialState[form],
			authError: null, // 폼 전환 시 회원 인증 에러 초기화
		}),
		[REGISTER_SUCCESS]: (state, { payload: auth }) => ({
			...state,
			authError: null,
			auth,
		}),
		[REGISTER_FAILURE]: (state, { payload: error }) => ({
			...state,
			authError: error,
		}),
		[LOGIN_SUCCESS]: (state, { payload: auth }) => ({
			...state,
			authError: null,
			auth,
		}),
		[LOGIN_FAILURE]: (state, { payload: error }) => ({
			...state,
			authError: error,
		}),
	},
	initialState,
);

export default auth;
