import { combineReducers } from 'redux';
import auth from './auth';
import loading from './loading';

//root reducer
const rootReducer = combineReducers({ auth, loading });
export default rootReducer;
