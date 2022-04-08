import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import PostViewer from '../../components/post/PostViewer';
import { readPost, unloadPost } from '../../modules/post';
import { useParams } from '../../../node_modules/react-router-dom/index';

const PostViewerContainer = () => {
	// 처음 마운트될 때 포스트 읽기 API 요청
	const { postId } = useParams();
	const dispatch = useDispatch();
	const { post, error, loading } = useSelector(({ post, loading }) => ({
		// post = state.post, loading = state.loading
		post: post.post,
		error: post.error,

		loading: loading['post/READ_POST'], // createRequestSaga에서 'post/READ_POST'를 파라미터로 전달하는 startloading 작업을 해준다.
	}));
	// const data = useSelector((state) => ({
	// 	post: state.post.post,
	// 	error: state.post.error,
	// 	loading: state.loading['post/READ_POST'],
	// }));
	// const { post, error, loading } = data;
	useEffect(() => {
		dispatch(readPost(postId)); // action: {type: POST_READ, paylod: postId}를 리덕스 사가에서 조회할 수 있어서 postId 값을 readPost API에 전달이 가능하다.
		// 언마운트 될 때 리덕스에서 post 데이터 없애기
		return () => {
			dispatch(unloadPost());
		};
	}, [dispatch, postId]);
	return <PostViewer post={post} error={error} loading={loading} />;
};

export default PostViewerContainer;
