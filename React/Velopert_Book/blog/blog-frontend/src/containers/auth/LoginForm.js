import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import AuthForm from '../../components/auth/AuthForm';
import { changeField, initializeForm, login } from '../../modules/auth';
import { check } from '../../modules/user';

const LoginForm = () => {
	const dispatch = useDispatch();
	const form = useSelector((state) => state.auth.login);
	const { auth, authError } = useSelector((state) => state.auth);
	const { user } = useSelector((state) => state.user);
	const navigate = useNavigate();
	//에러를 관리하는 state는 LoginForm 컨테이너에서 관리하여 프레젠테이셔널 컴포넌트에 넘겨준다.
	const [error, setError] = useState(null);

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
			setError('로그인 실패!');
			return;
		}
		if (auth) {
			console.log('로그인 성공');
			console.log('auth', auth);
			dispatch(check());
		}
	}, [auth, authError, dispatch]);

	useEffect(() => {
		if (user) {
			navigate('/');
			try {
				localStorage.setItem('user', JSON.stringify(user));
			} catch (e) {
				console.log('loacalStorage is no working');
			}
		}
	}, [navigate, user]);
	return (
		<AuthForm
			type="login"
			form={form}
			onChange={onChange}
			onSubmit={onSubmit}
			error={error}
		/>
	);
};
export default LoginForm;
