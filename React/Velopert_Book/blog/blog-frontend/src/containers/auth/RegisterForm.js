import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import AuthForm from '../../components/auth/AuthForm';
import { changeField, initializeForm, register } from '../../modules/auth';
import { check } from '../../modules/user';

const RegisterForm = () => {
	const dispatch = useDispatch();
	const { form, auth, authError, user } = useSelector(({ auth, user }) => ({
		form: auth.register,
		auth: auth.auth,
		authError: auth.authError,
		user: user.user,
	}));

	const navigate = useNavigate();
	const [error, setError] = useState(null); // 에러 관리 state

	// 인풋 변경 이벤트 핸들러
	const onChange = (e) => {
		const name = e.target.name;
		const value = e.target.value;

		dispatch(
			changeField({
				form: 'register',
				key: name,
				value,
			}),
		);
	};

	// 폼 등록 이벤트 핸들러
	const onSubmit = (e) => {
		e.preventDefault();
		const { username, password, passwordConfirm } = form;
		if ([username, password, passwordConfirm].includes('')) {
			//하나라도 입력이 안되었다면
			setError('빈 칸을 모두 채우세요!');
			return;
		}
		if (password !== passwordConfirm) {
			//오류 처리
			setError('비밀번호가 일치하지 않습니다.');
			return;
		}
		dispatch(register({ username, password }));
	};

	// 컴포넌트가 처음 렌더링될 때 form을 초기화 한다.
	useEffect(() => {
		dispatch(initializeForm('register'));
	}, [dispatch]);
	// 회원가입 성공/실패 처리
	useEffect(() => {
		if (authError) {
			console.log('오류 발생');
			console.log(authError);
			if (authError.response.status === 409) {
				//계정명이 이미 존재할 때
				setError('이미 존재하는 계정명입니다.');
				return;
			} else {
				// 기타 이유
				setError('회원가입 실패');
				return;
			}
		}
		if (auth) {
			console.log('회원가입 성공');
			console.log(auth);
			dispatch(check());
		}
	}, [auth, authError, dispatch]); // 리덕스 state의 authError, auth 값이 변할 때 마다 console 메시지 출력

	//user 값이 잘 설정되었는지 확인
	useEffect(() => {
		if (user) {
			console.log('checkAPI 성공, 로그인 상태가 되었음');
			console.log(user);
		}
	}, [user]);

	useEffect(() => {
		if (user) {
			navigate('/'); //홈 화면으로 이동
		}
	}, [navigate, user]);

	return (
		<AuthForm
			type="register"
			form={form}
			onChange={onChange}
			onSubmit={onSubmit}
			error={error}
		/>
	);
};
export default RegisterForm;
