import React, {useState,useMemo} from 'react'; //react 불러오기
import PropTypes from 'prop-types'; //props 타입검사하는 역할
import Link from 'next/Link';
import {Menu,Input,Row,Col} from 'antd';
import UserProfile from './UserProfile';
import LoginForm from './LoginForm';
import styled from 'styled-components';
import { useSelector } from 'react-redux'; // redux1

const InputSearch = styled(Input.Search)`
  vertical-align:middle;
`;

const AppLayout = ({children})=>{
  /////////////////////////////////////////////code
  
  const items = [
    {label:<Link href="/" >LOGO</Link>,key:'/'},
    {label:<Link href="/profile" >PROFILE</Link>,key:'/profile'},
    {label:<Link href="/signup" >SIGNUP</Link>,key:'/signup'},
    {label:<InputSearch placeholder="input search text" enterButton/>,key:'/search'},
  ];
  
  /// 1. 변수 vs useState
  //let logo = "My react";
  //const changeLogo = ()=>{console.log('...로고바꾸기'); logo="welcome";}

  let[logo,setLogo] = useState('...TheJoa ...'); // 2번째 - 함수를 통해서 재랜더링
  const changeLogo = ()=>{console.log('... 로고바꾸기'); setLogo('login');};

  // 2. 로그인상태
  //const [isLogin,setIsLogin] = useState(false);
  const {user} = useSelector(state=>state.user); //redux2

  //useMemo
  const stylebg = useMemo(()=>({backgroundColor:'#efefef'}),[]);
  /////////////////////////////////////////////view
  return (
    <div>
      <Menu mode='horizontal' items={items}/>
      <Row gutter={8}>
        <Col xs={24} md={6}>
          {/* <h3 onClick={()=>{console.log('.....');}}>{logo}</h3> */}
          {/* <h3 onClick={changeLogo}>{logo}</h3> */}
          {/* {isLogin? <UserProfile setIsLogin={setIsLogin}/>:<LoginForm setIsLogin={setIsLogin}/>} */}
          {user?<UserProfile/>:<LoginForm/>} {/* redux3 */}
        </Col>
        <Col xs={24} md={12} style={stylebg}>{children} {/* 하위컴포넌트 동적삽입 */}</Col>
        <Col xs={24} md={6}><div><a href="" target="_blank" rel="noreferrer noopener">TheJoa</a>copyrights. all reserved</div></Col>
      </Row>
    </div>  
  );
};

AppLayout.propTypes = {
  children : PropTypes.node.isRequired
};

export default AppLayout;