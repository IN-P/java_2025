import React,{useState,useCallback, useEffect} from 'react';
import {Input,Row,Col,Button,Form} from 'antd';
import Link from 'next/Link';
import userInput from '../hooks/userInput';
import { LOG_IN_REQUEST } from '../reducers/user'; //#1. redux
import { useDispatch,useSelector } from 'react-redux'; //#2. redux - useDispatch


//const LoginForm = ({setIsLogin})=>{
const LoginForm = ()=>{ //#3. redux
  /////////////////////////////////////////////code
  // const [id,setId] = useState(''); //상태관리 - 컴포넌트에서 값이 변결
  // const onChangeId = useCallback((e)=>{console.log(e.target.value);setId(e.target.value);},[]); //function - 함수의 재생성

  // const [password,setPassword] = useState('');
  // const onChangePassword = useCallback((e)=>{console.log(e.target.value);setPassword(e.target.value);},[]); //function - 함수의 재생성

  // const [count,setCount] = useState(1);
  // const onCount = ()=>{
  //   setCount(count+1);
  //   console.log(count);
  // };

  const {logInLoading,logInError} = useSelector(state=>state.user);

  const [email,onChangeEmail] = userInput('');
  const [password,onChangePassword] = userInput('');

  const dispatch = useDispatch(); //#4. redux

  useEffect(()=>{if(logInError){alert(logInError);}},[logInError]);

  const onSubmitForm = useCallback(()=>{ //컴포넌트가 처음 랜더링 될때 한번만 생성
    console.log("........",email,password);
    //setIsLogin(true);
    dispatch({
      type:LOG_IN_REQUEST,
      data:{email,password}
    }); //#5. redux
  },[email,password]); // id,password 값이 변경될때

  /////////////////////////////////////////////view
  return (
  <>
    <Form layout="vertical" style={{padding:'3%'}} onFinish={onSubmitForm}>
       <Form.Item label="email">
        <Input placeholder="user@gmail.com 형식으로 입력"  name="email" value={email} onChange={onChangeEmail} required/>
      </Form.Item>

      <Form.Item label="비밀번호">
        <Input.Password placeholder="비밀번호 입력" name="password" value={password} onChange={onChangePassword} required/>
      </Form.Item>

      <Form.Item style={{textAlign:'center'}}>
        <Button type="primary" style={{marginRight:'2%'}} htmlType='submit' loading={logInLoading}>로그인</Button>
        <Link href="/signup" legacyBehavior><a><Button>회원가입</Button></a></Link>
      </Form.Item>
    </Form>
  </>
  );
};

export default LoginForm;