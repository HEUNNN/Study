import styled from 'styled-components';
import palette from '../../lib/styles/palette.js';
import Button from '../common/Button.js';
import Responsive from '../common/Responsive.js';
import SubInfo from '../common/SubInfo.js';
import Tags from '../common/Tags.js';

const PostListBlock = styled(Responsive)`
	margin-top: 3rem;
`;

const WritePostButtonWrapper = styled.div`
	display: flex;
	justify-content: flex-end;
	margin-bottom: 3rem;
`;

const PostItemBlock = styled.div`
	padding-top: 3rem;
	padding-bottom: 3rem;

	/* 맨 위 포스트는 padding-top 없음 */
	&:first-child {
		padding-top: 0;
	}
	& + & {
		border-top: 1px solid ${palette.gray[2]};
	}
	h2 {
		font-size: 2rem;
		margin-bottom: 0;
		margin-top: 0;
		&:hover {
			color: ${palette.gray[6]};
		}
	}
	p {
		margin-top: 2rem;
	}
`;

const PostItem = () => {
	return (
		<PostItemBlock>
			<h2>제목</h2>
			<SubInfo username="username" publishedDate={new Date()} />
			<Tags tags={['tag1', 'tag2', 'tag3']}></Tags>
			<p>포스트 내용의 일부분 ...</p>
		</PostItemBlock>
	);
};

const PostList = () => {
	return (
		<PostListBlock>
			<WritePostButtonWrapper>
				<Button cyan to="/write">
					새 글 작성하기
				</Button>
			</WritePostButtonWrapper>
			<div>
				<PostItem />
				<PostItem />
				<PostItem />
			</div>
		</PostListBlock>
	);
};
export default PostList;
