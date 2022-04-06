import palette from '../../lib/styles/palette';
import styled, { css } from 'styled-components';
import { Link } from 'react-router-dom';

const buttonStyle = css`
	border: none;
	border-radius: 4px;
	font-size: 1rem;
	font-weight: bold;
	padding: 0.25rem 1rem; /* Link를 버튼처럼 보이게 해준다. */
	color: white;
	outline: none;
	cursor: pointer;
	background: ${palette.gray[8]};
	&:hover {
		background: ${palette.gray[6]};
	}
	${(props) =>
		props.fullwidth &&
		css`
			padding-top: 0.75rem;
			padding-bottom: 0.75rem;
			width: 100%;
			font-size: 1.125rem;
		`}
	${(props) =>
		props.cyan &&
		css`
			background: ${palette.cyan[5]};
			&:hover {
				background: ${palette.cyan[4]};
			}
		`}
`;
const StyledLink = styled(Link)`
	${buttonStyle}
`;
const StyledButton = styled.button`
	${buttonStyle}
`;

const Button = (props) => {
	console.log(props.to);
	return props.to ? (
		<StyledLink {...props} cyan={props.cyan ? 1 : 0} />
	) : (
		<StyledButton {...props} />
	);
};
export default Button;
