import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from '../../../node_modules/react-router-dom/index';
import WriteActionButtons from '../../components/write/WriteActionButtons';
import { updatePost, writePost } from '../../modules/write';

const WriteActionButtonsContainer = () => {
	const navigate = useNavigate();
	const dispatch = useDispatch();
	const { title, body, tags, post, postError, originalPostId } = useSelector(
		({ write }) => ({
			title: write.title,
			body: write.body,
			tags: write.tags,
			post: write.post,
			postError: write.postError,
			originalPostId: write.originalPostId,
		}),
	);

	// 포스트 등록
	const onPublish = () => {
		if (originalPostId) {
			dispatch(updatePost({ title, body, tags, id: originalPostId }));
			return;
		}
		dispatch(writePost({ title, body, tags }));
	};

	//취소
	const onCancel = () => {
		//dispatch(initialize()); // 책에는 없는데, 있을때랑 없을 때 차이점 알아보기
		navigate(-1);
	};

	// 성공 혹은 실패시 할 작업
	useEffect(() => {
		if (post) {
			// POST /api/posts (write 작업)에 요청을 보내고 받은 응답 post
			const { _id, user } = post;
			navigate(`/@${user.username}/${_id}`);
		}
		if (postError) {
			console.log(postError);
		}
	}, [navigate, post, postError]);

	return (
		<WriteActionButtons
			onCancel={onCancel}
			onPublish={onPublish}
			isEdit={originalPostId}
		/>
	);
};
export default WriteActionButtonsContainer;
