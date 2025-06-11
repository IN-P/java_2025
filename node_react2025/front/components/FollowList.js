import React,{useEffect, useMemo, useState} from 'react';
import {Button,List,Card} from 'antd';
import {UserDeleteOutlined} from '@ant-design/icons';
import {useDispatch} from 'react-redux';
import {UNFOLLOW_REQUEST, REMOVE_FOLLOWER_REQUEST} from'../reducers/user'

const FollowList = ({header,data,onClickMore,loading})=>{
  const dispatch = useDispatch();
  const [localData,setLocalData] = useState(data);

  useEffect(()=>{setLocalData(data);},[data])

  const onClickCancel = (id)=>()=>{
    setLocalData((prev)=>prev.filter((user)=>user.id!==id));
    if (header === '팔로잉') {
      dispatch({
        type:UNFOLLOW_REQUEST,
        data:id,
      });
    } else {
      dispatch({
        type:REMOVE_FOLLOWER_REQUEST,
        data:id,
      });
    }
  };
  ////////////////////////////////code

  const style = useMemo(()=>({margin:'3%', backgroundColor:'white', padding:'3%'}),[]);
  ////////////////////////////////view
  return (
    <List grid={{gutter:4, xs:2, md:4}} style={style}
      size='small' 
      header={<div>{header}</div>} 
      loadMore={<div style={{textAlign:'center'}}><Button onClick={onClickMore} loading={loading}>더보기</Button></div>}
      dataSource={localData}
      renderItem={(item)=>(
        <List.Item>
          <Card actions={[<UserDeleteOutlined key="user" onClick={onClickCancel(item.id)}/>]}>
            <Card.Meta description={item.nickname}/>
          </Card>
        </List.Item>
      )}
    /> 
  );
};

export default FollowList;