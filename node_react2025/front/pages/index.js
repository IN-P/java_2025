import React from 'react';
import AppLayout from '../components/AppLayout';
import PostForm from '../components/PostForm';
import PostCard from '../components/PostCard';
//import 'antd/dist/antd.css';
import { useSelector } from 'react-redux'; //##

const Home = ()=>{
  const {user} = useSelector(state=>state.user);
  const {mainPosts} = useSelector(state=>state.post);

  return(
    <AppLayout>
      {user&&<PostForm/>}
      {mainPosts.map((post)=>{
        return(<PostCard post={post} key={post.id}/>);
      })}
    </AppLayout>
  );
}
export default Home;