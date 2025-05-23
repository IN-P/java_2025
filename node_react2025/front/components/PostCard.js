import React,{useState,useCallback,useEffect} from "react";
import {Card,Avatar,Button,List,Comment,Popover,Form,Input} from 'antd';
import { EllipsisOutlined, HeartOutlined, MessageOutlined, RetweetOutlined,HeartTwoTone } from "@ant-design/icons";
import PostImages from "./PostImages";
import CommentForm from "./CommentForm";
import { useSelector,useDispatch } from "react-redux";
import { REMOVE_POST_REQUEST } from "../reducers/post";

const PostCard = ({post})=>{
  //////////////////////////////////////////code
  const id = useSelector((state)=>state.user.user?.id);
  const {removePostLoading,removePostDone} = useSelector(state=>state.post);
  const dispatch = useDispatch();

  // useEffect(()=>{
  //   if (removePostDone) {alert
  //     ('삭제완료')}
  // },[]);

  const onRemovePost = useCallback(()=>{
    dispatch({
      type:REMOVE_POST_REQUEST,
      data:post.id,
    });
  },[id,post.id]);

  console.log(".."+id);
  console.log(".."+post.User.id);
  //1. 좋아요 - false
  const [like,setLike] = useState(false); 
  const onClickLike = useCallback(()=>{setLike((prev)=>!prev);},[]);

  //2. 댓글
  const [commentOpen,setCommentOpen] = useState(false);
  const onClickComment = useCallback(()=>{setCommentOpen((prev)=>!prev);},[]);

  //////////////////////////////////////////view
  return(
    <div style={{margin:'3%'}}>
      <Card 
        cover={post.Images && post.Images.length>0 && <PostImages images={post.Images}/>} 
        actions={[
          <RetweetOutlined key="retweet"/>,

          like?
          <HeartTwoTone twoToneColor="#f00" key="heart" onClick={onClickLike}/>:
          <HeartOutlined key="heart" onClick={onClickLike}/>,

          <MessageOutlined onClick={onClickComment}/>,

          <Popover content={(
            <Button.Group>
              { id&&id===post.User.id?
              (<><Button>수정</Button>
                <Button type="danger" onClick={onRemovePost} loading={removePostLoading}>삭제</Button></>):
                <Button type="danger">신고</Button>
              }
            </Button.Group>
          )}><EllipsisOutlined/></Popover>
        ]}
      >
        <Card.Meta 
          avatar={<Avatar>{post.User.nickname[0]}</Avatar>} 
          title={post.User.nickname} 
          description={post.content}/>
      </Card>

        
        {commentOpen&&(
          <>
            {/* 댓글폼 */}
            <CommentForm post={post}/>
            {/* 댓글리스트 */}
            <List
              header={`댓글[${post.Comments.length}]`}
              itemLayout='horizontal'
              dataSource={post.Comments}
              renderItem={(item)=>(
                <li>
                  <Comment
                    avatar={<Avatar>{item.User.nickname[0]}</Avatar>}
                    content={item.content}
                    author={item.User.nickname}
                  />
                </li>
              )}
            />
          </>
        )}

    </div>
  );
};

export default PostCard