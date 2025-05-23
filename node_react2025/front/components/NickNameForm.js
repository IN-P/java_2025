import React from 'react';
import {Form,Input} from 'antd';

const NickNameForm = ()=>{
  return (
    <Form style={{margin:'5%', padding:'20px', border:'1px solid #333'}}>
      <Input.Search addonBefore="닉네임" enterButton="수정"/>
    </Form>

  );
};

export default NickNameForm;