import styled from 'styled-components';
import palette from '../../lib/styles/palette';
import Responsive from '../common/Responsive';
import { useRef } from 'react';
import { useEffect } from 'react';
import * as Quill from 'quill';
import 'quill/dist/quill.bubble.css';

const EditorBlock = styled(Responsive)`
	/* 페이지 위 아래 여백 지정 */
	padding-top: 5rem;
	padding-bottom: 5rem;
`;

const TitleInput = styled.input`
	font-size: 3rem;
	outline: none;
	padding-bottom: 0.5rem;
	border: none;
	border-bottom: 1px solid ${palette.gray[4]};
	margin-bottom: 2rem;
	width: 100%;
`;

const QuilWrapper = styled.div`
	/* 최소 크기 지정 및 padding 제거 */
	.ql-editor {
		padding: 0;
		min-height: 320px;
		font-size: 1.125rem;
		line-height: 1.5;
	}
	.ql-editor.ql-blank::before {
		left: 0px;
	}
`;

const Editor = ({ onChangeField, title, body }) => {
	const quillElement = useRef(null); // Quill을 적용할 DivElement를 설정
	const quillInstance = useRef(null); // Quill 인스턴스를 설정

	// 외부 라이브러리 Quill 연동
	useEffect(() => {
		quillInstance.current = new Quill(quillElement.current, {
			theme: 'bubble',
			placeholder: '내용을 작성하세요....',
			modules: {
				// 더 많은 옵션
				toolbar: [
					[{ header: '1' }, { header: '2' }],
					['bold', 'italic', 'underline', 'strike'],
					[{ list: 'ordered' }, { list: 'bullet' }],
					['blockquote', 'code-block', 'link', 'image'],
				],
			},
		});
		// quill에 text-change 이벤트 핸들러 등록
		const quill = quillInstance.current;
		quill.on('text-change', (delta, oldDelta, source) => {
			if (source === 'user') {
				onChangeField({ key: 'body', value: quill.root.innerHTML });
			}
		});
	}, [onChangeField]);

	useEffect(() => {
		quillInstance.current.root.innerHTML = body;
	}, []);

	const onChangeTitle = (e) => {
		onChangeField({ key: 'title', value: e.target.value });
	};

	return (
		<EditorBlock>
			<TitleInput
				placeholder="제목을 입력하세요."
				onChange={onChangeTitle}
				value={title}
			/>
			<QuilWrapper>
				<div ref={quillElement} />
			</QuilWrapper>
		</EditorBlock>
	);
};
export default Editor;
