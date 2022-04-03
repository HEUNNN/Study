import { put, call } from 'redux-saga/effects';
import { startLoading, finshLoading } from '../modules/loading';

const createRequestSaga = (type, requestApi) => {
	const SUCCESS = `${type}_SUCCESS`;
	const FAILURE = `${type}_FAILURE`;

	return function* (action) {
		yield put(startLoading(type)); // 로딩 시작
		try {
			const response = yield call(requestApi, action.payload);
			yield put({ type: SUCCESS, payload: response.data });
		} catch (e) {
			yield put({ type: FAILURE, payload: e, error: true });
		}
		yield put(finshLoading(type)); // 로딩 끝
	};
};
export default createRequestSaga;
