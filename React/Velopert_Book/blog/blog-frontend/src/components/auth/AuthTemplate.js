import styled from 'styled-components';
import palette from '../../lib/styles/palette';
import { Link } from 'react-router-dom';
/**
 * 회원가입/로그인 페이지의 레이아웃을 담당하는 컴포넌트이다.
 * AuthTemplate 레이아웃 내부에 AuthForm인 로그인폼 or 회원가입폼이 들어간다.
 */

/* 화면 전체를 채움 */
const AuthTemplateBlock = styled.div`
	position: absolute;
	left: 0;
	top: 0;
	bottom: 0;
	right: 0;
	background: ${palette.gray[2]};

	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
`;

/* 흰색 박스 */
const WhiteBox = styled.div`
	.logo-area {
		display: block;
		padding-bottom: 2rem;
		text-align: center;
		font-weight: bold;
		letter-spacing: 2px;
	}
	box-shadow: 0 0 8px rgba(0, 0, 0, 0.025);
	padding: 2rem;
	width: 360px;
	background: white;
	border-radius: 2px;
`;
const AuthTemplate = ({ children }) => {
	//AuthTemplate 컴포넌트 태그 사이에 전달되는 문자열이나 컴포넌트 등을 AuthTemplate 내부에서 보여주기 위해
	//props.children 혹은 { children } 선언 후 children 을 사용한다.
	return (
		<AuthTemplateBlock>
			<WhiteBox>
				<div className="logo-area">
					<Link to="/">BLOG</Link>
				</div>
				{children}
				{/* props.children 대신에 <AuthForm /> 컴포넌트가 직접들어가도 똑같다. LoginPage 에서 <AuthTemplate> 태그 사이에 <authForm/> 을 넘겨주기 때문*/}
			</WhiteBox>
		</AuthTemplateBlock>
	);
};
export default AuthTemplate;
