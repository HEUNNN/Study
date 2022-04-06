import { useSelector } from 'react-redux';
import Header from '../../components/common/Header';

const HeaderContainer = () => {
	const { user } = useSelector((state) => state.user);
	return <Header user={user}></Header>;
};
export default HeaderContainer;
