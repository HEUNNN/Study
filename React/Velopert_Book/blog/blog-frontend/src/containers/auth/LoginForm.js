import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import AuthForm from '../../components/auth/AuthForm';
import { changeField, initializeForm, login } from '../../modules/auth';

const LoginForm = () => {
	const dispatch = useDispatch();
	const form = useSelector((state) => state.auth.login);
	const { auth, authError } = useSelector((state) => state.auth);

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
		const { username, password } = form;
		dispatch(login({ username, password }));
	};

	// 컴포넌트가 처음 렌더링될 때 form을 초기화 한다.
	useEffect(() => {
		dispatch(initializeForm('login'));
	}, [dispatch]);

	useEffect(() => {
		if (authError) {
			console.log('오류 발생');
			console.log(authError);
			return;
		}
		if (auth) {
			console.log('로그인 성공');
			console.log(auth);
		}
	}, [auth, authError]);
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
