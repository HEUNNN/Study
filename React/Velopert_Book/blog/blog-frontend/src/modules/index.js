import { combineReducers } from 'redux';
import auth, { authSaga } from './auth';
import loading from './loading';
import { all } from 'redux-saga/effects';
import user, { userSaga } from './user';
import write from './write';
import { writeSaga } from './write';
import post from './post';
import { postSaga } from './post';
import posts, { postsSaga } from './posts';

//root reducer
const rootReducer = combineReducers({
	auth,
	loading,
	user,
	write,
	post,
	posts,
});

export function* rootSaga() {
	yield all([authSaga(), userSaga(), writeSaga(), postSaga(), postsSaga()]);
}

export default rootReducer;
