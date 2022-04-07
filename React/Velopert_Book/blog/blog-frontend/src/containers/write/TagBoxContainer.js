import { useDispatch, useSelector } from 'react-redux';
import TagBox from '../../components/write/TagBox';
import { changeField } from '../../modules/write';

const TagBoxContainer = () => {
	const dispatch = useDispatch();
	const tags = useSelector((state) => state.write.tags);

	// tag가 추가되면(TagBox의 insertTag) TagBox의 localTags state에도 넣어주어 화면에 태그 내용이 렌더링 되도록 해야하며,
	// write 리덕스 스토어의 state.tags 에도 넣어줘야 한다.
	const onChangeTags = (nextTags) => {
		dispatch(changeField({ key: 'tags', value: nextTags }));
	};
	return <TagBox onChangeTags={onChangeTags} tags={tags} />;
};
export default TagBoxContainer;
