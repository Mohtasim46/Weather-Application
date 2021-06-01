import styled from 'styled-components'
import ResultFadeIn from './resultfadein'

const NotFoundWrapper = styled.div`
max-width: 600px;
display: flex;
justify-content: center;
align-items: center;
margin: 100px auto 0;
padding: 20px;
opacity: 0;
visibility: hidden;
position: relative;
border-radius: 10px;
top: 20px;
background-color: rgba(0, 0, 0, 0.3);
border-radius: 10px;
animation: ${ResultFadeIn} 0.5s 1.4s forwards;
`;

export default NotFoundWrapper;