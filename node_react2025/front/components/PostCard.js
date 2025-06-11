import React,{useState,useCallback,useEffect} from "react";
import {Card,Avatar,Button,List,Comment,Popover,Form,Input} from 'antd';
import { EllipsisOutlined, HeartOutlined, MessageOutlined, RetweetOutlined,HeartTwoTone } from "@ant-design/icons";
import PostImages from "./PostImages";
import CommentForm from "./CommentForm";
import { useSelector,useDispatch } from "react-redux";
import { REMOVE_POST_REQUEST,LIKE_POST_REQUEST,UNLIKE_POST_REQUEST,UPDATE_POST_REQUEST, RETWEET_REQUEST } from "../reducers/post";
import FollowButton from "./FollowButton";
import PostCardContent from "./PostCardContent";
import Link from "next/Link";

const PostCard = ({post})=>{
  //////////////////////////////////////////code
  const id = useSelector((state)=>state.user.user?.id);
  const {removePostLoading,removePostDone} = useSelector(state=>state.post);
  const dispatch = useDispatch();

  const liked = post.Likers?.find((v) => v.id === id);

  const onLike = useCallback(() => {
  if (!id) return alert('로그인이 필요합니다.');
  dispatch({ type: LIKE_POST_REQUEST, data: post.id });
  }, [id, post.id]);

  const onUnlike = useCallback(() => {
  if (!id) return alert('로그인이 필요합니다.');
  dispatch({ type: UNLIKE_POST_REQUEST, data: post.id });
  }, [id, post.id]);


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


  //2. 댓글
  const [commentOpen,setCommentOpen] = useState(false);
  const onClickComment = useCallback(()=>{setCommentOpen((prev)=>!prev);},[]);

  //4. 수정
  const [editMode, setEditMode] = useState(false);
  const onClickUpdate = useCallback(()=>{setEditMode(true);},[]);
  const onCancelUpdate = useCallback(()=>{setEditMode(false);},[]);
  const onEditPost = useCallback((editText) =>() => {
    dispatch({
      type: UPDATE_POST_REQUEST ,
      data: {PostId:post.id, content:editText}
    });
  } , [post]);

  //5. 리트윗
  const onRetweet = useCallback(()=>{
    if(!id) {return alert('로그인해')}
    return dispatch({
      type:RETWEET_REQUEST,
      data:post.id,
    });
  });


  //////////////////////////////////////////view
  return(
    <div style={{margin:'3%'}}>
      <Card 
        cover={post.Images && post.Images.length>0 && <PostImages images={post.Images}/>} 
        actions={[
          <RetweetOutlined key="retweet" onClick={onRetweet}/>,

          liked?
          <HeartTwoTone twoToneColor="#f00" key="heart" onClick={onUnlike}/>:
          <HeartOutlined key="heart" onClick={onLike}/>,

          <MessageOutlined onClick={onClickComment}/>,

          <Popover content={(
            <Button.Group>
              { id&&id===post.User.id?
              (<><Button onClick={onClickUpdate}>수정</Button>
                <Button type="danger" onClick={onRemovePost} loading={removePostLoading}>삭제</Button></>):
                <Button type="danger">신고</Button>
              }
            </Button.Group>
          )}><EllipsisOutlined/></Popover>
        ]}
        title={post.RetweetId?`${post.User.nickname}님이 리트윗하셨습니다.`:null}
        extra={id&&id!==post.User.id&&<FollowButton post={post}/>}
      >
      {post.RetweetId&&post.Retweet?(
        <Card cover={post.Retweet.Images[0]&&<PostImages images={post.Retweet.Images}/>}>
          <Card.Meta 
            avatar={<Link href={`/user/${post.Retweet.User.id}`} prefetch={false}><Avatar>{post.Retweet.User.nickname[0]}</Avatar></Link>} 
            title={post.Retweet.User.nickname} 
            description={<PostCardContent 
              editMode={editMode}
              onChangePost={onEditPost}
              onCancelUpdate={onCancelUpdate}
              postData={post.Retweet.content}/>}
            />
        </Card>
      ):(        
        <Card.Meta 
          avatar={<Link href={`/user/${post.User.id}`} prefetch={false}><Avatar>{post.User.nickname[0]}</Avatar></Link>} 
          title={post.User.nickname} 
          description={<PostCardContent 
            editMode={editMode}
            onChangePost={onEditPost}
            onCancelUpdate={onCancelUpdate}
            postData={post.content}/>}
          />
      )}
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