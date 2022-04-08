import { put, call } from 'redux-saga/effects';
import { startLoading, finishLoading } from '../modules/loading';

export const createRequestActionTypes = (type) => {
	const SUCCESS = `${type}_SUCCESS`;
	const FAILURE = `${type}_FAILURE`;
	return [type, SUCCESS, FAILURE];
};

export default function createRequestSaga(type, requestApi) {
	const SUCCESS = `${type}_SUCCESS`;
	const FAILURE = `${type}_FAILURE`;

	return function* (action) {
		yield put(startLoading(type)); // 로딩 시작
		try {
			const response = yield call(requestApi, action.payload);
			yield put({ type: SUCCESS, payload: response.data }); // dispatch와 같은 역할 put
			//console.log(response.data); //{username: 'myid', _id: '624b010317c18bd6b6dd38be', __v: 0}
		} catch (e) {
			yield put({ type: FAILURE, payload: e, error: true });
		}
		yield put(finishLoading(type)); // 로딩 끝
	};
}
