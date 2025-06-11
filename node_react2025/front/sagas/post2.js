import {all,call,fork,delay,takeLatest,put,throttle} from 'redux-saga/effects'
//import { generateDummyPost } from '../reducers/post';
import axios from 'axios';



function addpostApi(data){ return axios.post('/post',data); } // 서버에 넘겨주는값
function* addpost(action){
  try {    
    const result = yield call(addpostApi, action.data); //action.data - 화면에서 사용자가 넘겨준값
    yield put({
      type:'ADD_POST_SUCCESS',
      data:result.data 
    })
  } catch (error) {
    yield put({
      type:'ADD_POST_FAILURE',
      data:error.response.data
    })
  }
}

function updatepostApi(data){ return axios.patch(`/post/${data.postId}`,data); }
function* updatepost(action){
  try {
    const result = yield call(updatepostApi,action.data); //처리함수, 처리파라미터
    yield put({
      type:'UPDATE_POST_SUCCESS',
      data:result.data, 
    })
  } catch (error) {
    yield put({
      type:'UPDATE_POST_FAILURE',
      data:error.response.data
    })
  }
}

function removepostApi(data){ return axios.delete(`/post/${data}`,); }
function* removepost(action){
  try {
    const result = yield call(removepostApi,action.data);
    yield put({
      type:'REMOVE_POST_SUCCESS',
      data:result.data
    })
  } catch (error) {
    yield put({
      type:'REMOVE_POST_FAILURE',
      data:error.response.data
    })
  }
}

function addcommentApi(data){ return axios.post(`/post/${data.postId}/comment`,data); }
function* addcomment(action){
  try {
    const result = yield call(addcommentApi, action.data); 
    yield put({
      type:'ADD_COMMENT_SUCCESS',
      data:result.data
    })
  } catch (error) {
    yield put({
      type:'ADD_COMMENT_FAILURE',
      data:error.response.data
    })
  }
}

function uploadimagesApi(data){ return axios.post('/post/images',data); }
function* uploadimages(action){
  try {
    const result = yield call(uploadimagesApi, action.data);
    yield put({
      type:'UPLOAD_IMAGES_SUCCESS',
      data:result.data,
    })
  } catch (error) {
    yield put({
      type:'UPLOAD_IMAGES_FAILURE',
      data:error.response.data
    })
  }
}

function loadpostsApi(lastId){ return axios.get(`/posts?lastId=${lastId||0}`); }
function* loadposts(action){
  try {
    const result = yield call(loadpostsApi,action.lastId); //처리함수, 처리파라미터
    yield put({
      type:'LOAD_POSTS_SUCCESS',
      data:result.data,
    })
  } catch (error) {
    yield put({
      type:'LOAD_POSTS_FAILURE',
      data:error.response.data
    })
  }
}







/////step2) ACTION 기능추가
function*watchAddPost(){
  //yield take('ADD_POST',addpost); //ver-1. take는 일회용 - 로그인1번, 게시글도 1번만
  yield takeLatest('ADD_POST_REQUEST',addpost); //ver-2. 3번요청 → 응답 1번 
  //yield throttle('ADD_POST',addpost,10000); //ver-3. 몇초뒤에 실행, 시간설정가능-10초뒤에   
}
function*watchAddComment(){
  yield takeLatest('ADD_COMMENT_REQUEST',addcomment);
}
function*watchRemovePost(){
  yield takeLatest('REMOVE_POST_REQUEST',removepost);
}
function*watchLoadPosts(){
  yield throttle(5000,'LOAD_POSTS_REQUEST',loadposts);
}
function*watchUpdatePost(){
  yield takeLatest('UPDATE_POST_REQUEST',updatepost);
}
function*watchUploadImages(){
  yield takeLatest('UPLOAD_IMAGES_REQUEST',uploadimages);
}
/////step1) all()
export default function*postSaga() {
  yield all([ //all - 동시에 배열로 받은 fork들을 동시에 실행
    fork(watchAddPost),
    fork(watchUpdatePost),
    fork(watchAddComment),
    fork(watchRemovePost),
    fork(watchLoadPosts),
    fork(watchUploadImages),
  ]);
}

// fork - generator 함수들을 실행해줌.
//  all - 동시에 배열로 받은 fork들을 동시에 실행
// yield