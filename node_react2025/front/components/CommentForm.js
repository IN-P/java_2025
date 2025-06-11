import React, { useCallback,useEffect } from "react";
import {Button,Form,Input} from 'antd';
import PropTypes from "prop-types";
import userInput from '../hooks/userInput';
import {useSelector,useDispatch} from 'react-redux';
import { ADD_COMMENT_REQUEST } from "../reducers/post2";

const CommentForm = ({post})=>{
  ////////////////////////////////////////code
  const {addCommentLoading,addCommentDone} = useSelector(state=>state.post);
  const id = useSelector(state=>state.user.user?.id);

  const dispatch = useDispatch();


  const [comment,onChangeComment,setComment] = userInput('');

  useEffect(()=>{
    if (addCommentDone) {setComment('');}
  },[addCommentDone]);

  const onSubmitForm = useCallback(()=>{
    console.log(post.id,comment);
    dispatch({
      type:ADD_COMMENT_REQUEST,
      data:{content:comment,userId:id,postId:post.id}
    });
  },[comment]);

  ////////////////////////////////////////view
  return(
    <Form layout="vertical" style={{margin:'2%'}} onFinish={onSubmitForm}>
      <Form.Item>
        <Input.TextArea rows={5} value={comment} onChange={onChangeComment}/>
      </Form.Item>
      <Form.Item>
        <Button type="primary" style={{float:'right'}} htmlType="submit" loading={addCommentLoading}>댓글</Button>
      </Form.Item>
    </Form>
  );
  CommentForm.propTypes={
    post:PropTypes.object.isRequired
  };
};

export default CommentForm;