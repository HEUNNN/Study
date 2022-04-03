import {
	createAction,
	handleActions,
} from '../../node_modules/redux-actions/lib/index';

const START_LOADING = 'loading/START_LOADING';
const FINISH_LOADING = 'loading/FINISH_LOADING';

export const startLoading = createAction(
	START_LOADING,
	(requestType) => requestType,
); // 요청을 위한 액션 타입을 payload로 설정
export const finshLoading = createAction(
	FINISH_LOADING,
	(requestType) => requestType,
);

const initialState = {};

const loading = handleActions(
	{
		[START_LOADING]: (state, action) => ({
			...state,
			[action.payload]: true,
		}),
		[FINISH_LOADING]: (state, action) => ({
			...state,
			[action.payload]: false,
		}),
	},
	initialState,
);
export default loading;
