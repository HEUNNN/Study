import PostList from '../../components/post/PostList';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect } from 'react';
import { useSearchParams } from '../../../node_modules/react-router-dom/index';
import { listPosts } from '../../modules/posts';

const PostListContainer = () => {
	const [searchParams] = useSearchParams();
	const dispatch = useDispatch();
	const { posts, error, loading, user } = useSelector(
		({ posts, loading, user }) => ({
			// rootreducer 스토어에서 꺼내오는 리덕스 상태
			posts: posts.posts,
			error: posts.error,
			loading: loading['posts/LIST_POSTS'],
			user: user.user,
		}),
	);
	useEffect(() => {
		const username = searchParams.get('username');
		const tag = searchParams.get('tag');
		const page = parseInt(searchParams.get('page'), 10) || 1;
		console.log(page);
		dispatch(listPosts({ tag, username, page }));
	}, [dispatch, searchParams]);
	return (
		<PostList
			loading={loading}
			posts={posts}
			error={error}
			showWriteButton={user}
		/>
	);
};
export default PostListContainer;
