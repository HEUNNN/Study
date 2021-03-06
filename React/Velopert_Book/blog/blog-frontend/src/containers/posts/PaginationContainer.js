import { useSelector } from 'react-redux';
import { useParams, useSearchParams } from 'react-router-dom';
import Pagination from '../../components/posts/Paigination';
import loading from '../../modules/loading';
import posts from '../../modules/posts';

const PaginationContainer = () => {
	const [searchParams] = useSearchParams();
	const { username } = useParams();
	const page = parseInt(searchParams.get('page')) || 1;

	const { lastPage, posts, loading } = useSelector(({ posts, loading }) => ({
		lastPage: posts.lastPage, // posts는 state(rootReducer state).posts
		posts: posts.posts,
		loading: loading['posts/LIST_POSTS'], // loading은 state.loading
	}));
	if (!posts || loading) {
		return null;
	}
	return (
		<Pagination
			username={username}
			page={parseInt(page, 10)}
			lastPage={lastPage}
		/>
	);
};
export default PaginationContainer;
