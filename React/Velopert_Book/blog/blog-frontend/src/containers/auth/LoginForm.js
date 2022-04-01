import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import AuthForm from '../../components/auth/AuthForm';
import { changeField, initializeForm } from '../../modules/auth';

const LoginForm = () => {
	const dispatch = useDispatch();
	const form = useSelector((state) => state.auth.login);
	/* 위 코드와 아래 코드는 같은 의미이다.
    const { form } = useSelector(({ auth }) => ({
		form: auth.login,
	}));
    */

	// 인풋 변경 이벤트 핸들러
	const onChange = (e) => {
		const name = e.target.name;
		const value = e.target.value;

		dispatch(
			changeField({
				form: 'login',
				key: name,
				value,
			}),
		);
	};

	// 폼 등록 이벤트 핸들러
	const onSubmit = (e) => {
		e.preventDefault();
		// 구현 예정
	};

	// 컴포넌트가 처음 렌더링될 때 form을 초기화 한다.
	useEffect(() => {
		dispatch(initializeForm('login'));
	}, [dispatch]);
	return (
		<AuthForm
			type="login"
			form={form}
			onChange={onChange}
			onSubmit={onSubmit}
		/>
	);
};
export default LoginForm;
