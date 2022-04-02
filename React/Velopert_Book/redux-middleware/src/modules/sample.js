import { createAction } from "redux-actions";
import { handleActions } from "redux-actions";
import { call, put, take, takeLatest } from "redux-saga/effects";
import { startLoading, finishLoading } from "./loading";
import * as api from "../lib/api";

//액션 타입 설정
const GET_POST = "sample/GET_POST";
const GET_POST_SUCCESS = "sample/GET_POST_SUCCESS";
const GET_POST_FAILURE = "sample/GET_POST/FAILURE";

const GET_USERS = "sample/GET_USERS";
const GET_USERS_SUCCESS = "sample/GET_USERS_SUCCESS";
const GET_USERS_FAILURE = "sample/GET_USERS_FAILURE";

export const getPost = createAction(GET_POST, (id) => id);
export const getUsers = createAction(GET_USERS);

function* getPostSaga(action) {
  yield put(startLoading(GET_POST)); // 로딩 시작
  try {
    const post = yield call(api.getPost, action.payload); // api.getPost(action.payload)를 의미한다.
    console.log("action:", action);
    yield put({
      type: GET_POST_SUCCESS,
      payload: post.data,
    });
  } catch (e) {
    yield put({
      type: GET_POST_FAILURE,
      payload: e,
      error: true,
    });
  }
  yield put(finishLoading(GET_POST));
}

function* getUsersSaga(action) {
  yield put(startLoading(GET_USERS)); // 로딩 시작
  try {
    const users = yield call(api.getUsers); // api.getPost(action.payload)를 의미한다.
    console.log("action:", action);
    yield put({
      type: GET_USERS_SUCCESS,
      payload: users.data,
    });
  } catch (e) {
    yield put({
      type: GET_USERS_FAILURE,
      payload: e,
      error: true,
    });
  }
  yield put(finishLoading(GET_USERS));
}

export function* sampleSaga() {
  yield takeLatest(GET_POST, getPostSaga);
  yield takeLatest(GET_USERS, getUsersSaga);
}

const initialState = {
  post: null,
  users: null,
};

const sample = handleActions(
  {
    [GET_POST_SUCCESS]: (state, action) => ({
      ...state,
      post: action.payload,
    }),

    [GET_USERS_SUCCESS]: (state, action) => ({
      ...state,
      users: action.payload,
    }),
  },
  initialState
);
export default sample;
