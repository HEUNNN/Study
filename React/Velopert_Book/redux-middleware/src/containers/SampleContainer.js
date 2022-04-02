import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import Sample from "../components/Sample";
import { getPost, getUsers } from "../modules/sample";

const SampleContainer = () => {
  const dispatch = useDispatch();
  const { post, users } = useSelector((state) => state.sample);
  const { loading } = useSelector((state) => state);
  useEffect(() => {
    dispatch(getPost(1));
    dispatch(getUsers(1));
  }, [getPost, getUsers]);

  return (
    <Sample
      loadingPost={loading.GET_POST}
      loadingUsers={loading.GET_USERS}
      post={post}
      users={users}
    />
  );
};
export default SampleContainer;
