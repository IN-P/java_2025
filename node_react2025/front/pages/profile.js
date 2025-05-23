import React from 'react';
import AppLayout from '../components/AppLayout';
import Head from 'next/head';
import NicknameForm from '../components/NickNameForm';
import FollowList from '../components/FollowList';


const Profile = ()=>{
  const data = [{nickname:'1'},{nickname:'2'},{nickname:'3'},{nickname:'4'}];
  

  return (
    <>
      <Head>
        <meta charset='utf-8'/>
        <title>Profile | TheJoa</title>
      </Head>
      <AppLayout>
        <NicknameForm/>
        <FollowList header="팔로잉" data={data}/>
        <FollowList header="팔로우" data={data}/>




      </AppLayout>
    </>
  );
}

export default Profile;