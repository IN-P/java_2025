import React, { useCallback } from 'react';
import {Form,Input} from 'antd';
import {useSelector,useDispatch} from 'react-redux';
import userInput from '../hooks/userInput';
import { CHANGE_NICKNAME_REQUEST } from '../reducers/user';

const NickNameForm = ()=>{
  const {user,changeNicknameLoading} = useSelector((state)=>state.user);
  const [nickname,onChangeNickname] = userInput(user?.nickname||'');
  const dispatch = useDispatch();

  const onSubmit = useCallback(()=>{
    dispatch({
      type:CHANGE_NICKNAME_REQUEST,
      data:nickname,
    });
  },[nickname]);

  return (
    <Form style={{margin:'5%', padding:'20px', border:'1px solid #333'}}>
      <Input.Search value={nickname} onChange={onChangeNickname} onSearch={onSubmit} addonBefore="닉네임" enterButton="수정" loading={changeNicknameLoading}/>
    </Form>

  );
};

export default NickNameForm;