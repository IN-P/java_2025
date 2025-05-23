import React,{useMemo} from 'react';
import {Button,List,Card} from 'antd';
import {UserDeleteOutlined} from '@ant-design/icons';

const FollowList = ({header,data})=>{
  ////////////////////////////////code
  const style = useMemo(()=>({margin:'3%', backgroundColor:'white', padding:'3%'}),[]);
  ////////////////////////////////view
  return (
    <List grid={{gutter:4, xs:2, md:4}} style={style}
      size='small' 
      header={<div>{header}</div>} 
      loadMore={<div style={{textAlign:'center'}}><Button>더보기</Button></div>}
      dataSource={data}
      renderItem={(item)=>(
        <List.Item>
          <Card actions={[<UserDeleteOutlined key="user"/>]}>
            <Card.Meta description={item.nickname}/>
          </Card>
        </List.Item>
      )}
    /> 
  );
};

export default FollowList;