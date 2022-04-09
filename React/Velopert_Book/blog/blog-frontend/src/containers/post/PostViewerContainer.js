import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import PostViewer from '../../components/post/PostViewer';
import { readPost, unloadPost } from '../../modules/post';
import {
	useNavigate,
	useParams,
} from '../../../node_modules/react-router-dom/index';
import PostActionButtons from '../../components/post/PostActionButtons';
import { setOriginalPost } from '../../modules/write';
import { removePost } from '../../lib/api/posts';

const PostViewerContainer = () => {
	// 처음 마운트될 때 포스트 읽기 API 요청
	const navigate = useNavigate();
	const { postId } = useParams();
	const dispatch = useDispatch();
	const { post, error, loading, user } = useSelector(
		({ post, loading, user }) => ({
			// post = state.post, loading = state.loading
			post: post.post,
			error: post.error,
			loading: loading['post/READ_POST'], // createRequestSaga에서 'post/READ_POST'를 파라미터로 전달하는 startloading 작업을 해준다.
			user: user.user, // post를 수정할 때 post 작성자와 현재 로그인한 user 가 같은 사람인지 확인하기 위해 얻어온 user 리덕스 스토어 state
		}),
	);

	useEffect(() => {
		dispatch(readPost(postId)); // action: {type: POST_READ, paylod: postId}를 리덕스 사가에서 조회할 수 있어서 postId 값을 readPost API에 전달이 가능하다.
		// 언마운트 될 때 리덕스에서 post 데이터 없애기
		return () => {
			dispatch(unloadPost());
		};
	}, [dispatch, postId]);

	const onEdit = () => {
		dispatch(setOriginalPost(post));
		navigate('/write');
	};
	const ownPost = (user && user._id) === (post && post.user._id);

	const onRemove = async () => {
		try {
			await removePost(postId);
			navigate('/');
		} catch (e) {
			console.log(e);
		}
	};
	return (
		<PostViewer
			post={post}
			error={error}
			loading={loading}
			actionButtons={
				ownPost && <PostActionButtons onEdit={onEdit} onRemove={onRemove} />
			}
		/>
	);
};

export default PostViewerContainer;
