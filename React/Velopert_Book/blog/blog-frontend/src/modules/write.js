import {
	createAction,
	handleActions,
} from '../../node_modules/redux-actions/lib/index';

const INITIALIZE = 'write/INITIALIZE'; // 모든 내용 초기화
const CHANGE_FIELD = 'write/CHANGE_FIELD'; // 특정 key 값 바꾸기
// key: title, body, tag ..

export const initialize = createAction(INITIALIZE);
export const changeField = createAction(CHANGE_FIELD, ({ key, value }) => ({
	key,
	value,
}));

const initialState = {
	title: '',
	body: '',
	tags: [],
};

const write = handleActions(
	{
		[INITIALIZE]: (state) => initialState,
		[CHANGE_FIELD]: (state, { payload: { key, value } }) => ({
			...state,
			[key]: value, // 특정 key 값을 업데이트
		}),
	},
	initialState,
);

export default write;
