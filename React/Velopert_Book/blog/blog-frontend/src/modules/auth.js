import { createAction, handleActions } from 'redux-actions';
import produce from 'immer';

//액션 타입 정의
const CHANGE_FIELD = 'auth/CHANGE_FIELD';
const INITIALIZE_FORM = 'auth/INITIALIZE_FORM';

const REGISTER = 'auth/REGISTER';
const REGISTER_SUCCESS = 'auth/REGISTER_SUCCESS';
const REGISTER_FAILURE = 'auth/REGISTER_FILURE';

const LOGIN = 'auth/LOGIN';
const LOGIN_SUCCESS = 'auth/LOGIN_SUCCESS';
const LOGIN_FAILURE = 'auth/LOGIN_FILURE';

//액션 생성 함수 정의
export const changeField = createAction(
	CHANGE_FIELD,
	({ form, key, value }) => ({
		form,
		key,
		value,
	}),
);
export const initializeForm = createAction(INITIALIZE_FORM, (form) => form);

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
};

const auth = handleActions(
	{
		[CHANGE_FIELD]: (state, action) => ({
			...state,
			[action.payload.form]: {
				...state[action.payload.form],
				[action.payload.key]: action.payload.value,
			},
		}),
		[INITIALIZE_FORM]: (state, { payload: form }) => ({
			...state,
			[form]: initialState[form],
		}),
	},
	initialState,
);

export default auth;
