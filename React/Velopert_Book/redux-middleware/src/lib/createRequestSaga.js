import { call, put } from "redux-saga/effects";
import { finishLoading, startLoading } from "../modules/loading";

const createRequestSaga = (type, requestApi) => {
  const SUCCESS = `${type}_SUCCESS`;
  const FAILURE = `${type}_FAILURE`;
  return function* (action) {
    //action: {type:액션 생성함수에서 생성하는 액션 타입 , payload:액션 생성함수에서 전달해주는 파라미터 값}
    yield put(startLoading(type));
    try {
      const response = yield call(requestApi, action.payload); // requestApi(action.payload)를 의미
      yield put({
        type: SUCCESS,
        payload: response.data,
      });
    } catch (e) {
      yield put({
        type: FAILURE,
        payload: e,
        error: true,
      });
    }
    yield put(finishLoading(type));
  };
};
export default createRequestSaga;
