import React, {useCallback,useState,useRef,useEffect} from "react";
import {Form,Input,Button} from "antd";
import { useDispatch,useSelector } from "react-redux"; //1. useDispatch, useSelector 
import {ADD_POST_REQUEST} from "../reducers/post"; 
import userInput from "../hooks/userInput";

const PostForm = ()=>{
  //3. useSelect이용해서 post (이미지)
  const {imagePaths,addPostLoading,addPostDone} = useSelector(state=>state.post);
  const imageInput = useRef();
  const onClickImageUpload = useCallback(()=>{
    imageInput.current.click();
  },[imageInput.current]);
  //4. dispatch - submit (글)
  const dispatch = useDispatch();
  const [text,onChangeText,setText] = userInput('');
 
  useEffect(()=>{
    if (addPostDone) {setText('');}
  },[addPostDone]);

  const onFormSubmit = useCallback(()=>{
    dispatch({
      type:ADD_POST_REQUEST,
      data:text,
    });
    setText('');
  },[text]);
  //5. 이벤트

  return(
    <Form layout="vertical" style={{margin:'3%',backgroundColor:'white',padding:'3%'}} encType="multipart/form-data" onFinish={onFormSubmit}>
      <Form.Item label="글쓰기">
        <Input.TextArea placeholder="게시글을 적어주세요" maxLength={200} value={text} onChange={onChangeText}/>
      </Form.Item>
      <Form.Item>
        <input type="file" name="image" multiple hidden ref={imageInput} style={{display:'none'}}/>
        <Button onClick={onClickImageUpload}>이미지업로드</Button>
        <Button type="primary" style={{float:'right'}} htmlType="submit" loading={addPostLoading}>POST</Button>
      </Form.Item>
      <div>
        {imagePaths.map((v,i)=>(
          <div key={v}>
            <img src={v} style={{width:'200px'}}/>
            <div><Button>제거</Button></div>
          </div>
        ))}
      </div>
    </Form>
  );
};

export default PostForm