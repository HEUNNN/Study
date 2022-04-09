import PostList from '../../components/posts/PostList';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect } from 'react';
import { useSearchParams } from '../../../node_modules/react-router-dom/index';
import { listPosts } from '../../modules/posts';

const PostListContainer = () => {
	const { username } = useParams(); // postlist 에서 username 부분을 클릭하면 해당 username 의 post 들만 나오도록 하기 위해 username은 querystring 이 아닌 parameter -> @testid 를 받아오기 위해 useParams를 사용, App.js를 보면 특정 user가 작성한 post만 보려면 /@username이여야 한다.
	const [searchParams] = useSearchParams(); // useSearchParams()는 query string  '?name=XX'와 같은것, useParams()는 posts/:id 에서 id 와 같은 파라미터
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
		const tag = searchParams.get('tag');
		const page = parseInt(searchParams.get('page'), 10) || 1;
		console.log(page);
		dispatch(listPosts({ tag, username, page }));
	}, [dispatch, searchParams, username]);

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
