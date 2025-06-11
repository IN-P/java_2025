import React,{useState,useCallback,useEffect} from "react";
import PropTypes from "prop-types";
import { Button,Input } from "antd";
import { useSelector } from "react-redux";
import Link from "next/Link";

const PostCardContent = ({postData,editMode,onChangePost,onCancelUpdate})=>{
  const {updatePostLoading, updatePostDone} = useSelector(state => state.post);
  const [editText, setEditText] = useState(postData);
  const onChangeText = useCallback((e)=>{setEditText(e.target.value);});

  useEffect(()=>{if(updatePostDone) {onCancelUpdate();}},[updatePostDone]);
  const onClickCancel = useCallback(()=>{setEditText(postData); onCancelUpdate();});
  
  return (
    <div>
      {editMode?(
        <>
          <Input.TextArea value={editText} onChange={onChangeText}/>
          <Button.Group style={{margin:'10px 0'}}>
            <Button loading={updatePostLoading} onClick={onChangePost(editText)} style={{margin:'5px'}}>수정</Button>
            <Button type="primary" onClick={onClickCancel} style={{margin:'5px'}}>취소</Button>
          </Button.Group>
        </>
      ):(
        postData.split(/(#[^\s#]+)/g)
        .map((v,i)=>{
          if(v.match(/(#[^\s#]+)/)){return <Link href={`/hashtag/${v.slice(1)}`} prefetch={false} key={i}>{v}</Link>;}
          return v;
        })
      )}
    </div>
  );
};

PostCardContent.PropTypes = {
  postData:PropTypes.string.isRequired,
  editMode:PropTypes.bool,
  onChangePost:PropTypes.func.isRequired,
  onCancelUpdate:PropTypes.func.isRequired,
};
PostCardContent.defaultProps = {
  editMode:false,
};

export default PostCardContent;