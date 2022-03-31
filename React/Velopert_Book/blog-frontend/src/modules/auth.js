import { createAction, handleActions } from 'redux-actions';

//액션 타입 정의
const SAMPLE_ACTION = 'auth/SAMPLE_ACTION';

//액션 생성 함수 정의
export const sampleAction = createAction(SAMPLE_ACTION);

//리듀서 정의
// 초기값 미리 설정해줘야 한다.
const initialState = {};
const auth = handleActions(
	{
		[SAMPLE_ACTION]: (state, action) => state,
	},
	initialState,
);

export default auth;
