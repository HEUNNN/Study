import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import Sample from "../components/Sample";
import { getPost, getUsers } from "../modules/sample";

const SampleContainer = () => {
  const dispatch = useDispatch();
  const { loading, post, users } = useSelector((state) => state.sample);
  useEffect(() => {
    dispatch(getPost(1));
    dispatch(getUsers(1));
  }, [getPost, getUsers]);
  console.log(getPost(1));

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
