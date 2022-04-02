import { finishLoading, startLoading } from "../modules/loading";

const createRequestThunk = (type, requestApi) => {
  const SUCESS = `${type}_SUCCESS`;
  const FAILURE = `${type}_FAILURE`;
  return (params) => async (dispatch) => {
    dispatch({ type: type });
    dispatch(startLoading(type));
    try {
      const response = await requestApi(params);
      dispatch({ type: SUCESS, payload: response.data });
    } catch (e) {
      dispatch({ type: FAILURE, payload: e, error: true });
      dispatch(finishLoading(type));
      throw e;
    }
  };
};
export default createRequestThunk;
