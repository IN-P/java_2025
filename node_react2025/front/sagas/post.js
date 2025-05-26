import {all,call,fork,delay,takeLatest,put,throttle} from 'redux-saga/effects'
import { generateDummyPost } from '../reducers/post';
import axios from 'axios';

function addpostApi(data){
  return axios.POST('/post',data);
}
function* addpost(action){
  //const result = yield call(addpostApi, action.data); //처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type:'ADD_POST_SUCCESS',
      data:action.data //result.data
    })
  } catch (error) {
    yield put({
      type:'ADD_POST_FAILURE',
      data:error.response.data
    })
  }
}

function addcommentApi(data){
  return axios.POST('/post/comment',data);
}
function* addcomment(action){
  //const result = yield call(addpostApi, action.data); //처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type:'ADD_COMMENT_SUCCESS',
      data:action.data //result.data
    })
  } catch (error) {
    yield put({
      type:'ADD_COMMENT_FAILURE',
      data:error.response.data
    })
  }
}

function removepostApi(data){
  return axios.DELETE('/post/',data);
}
function* removepost(action){
  //const result = yield call(removepostApi); //처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type:'REMOVE_POST_SUCCESS',
      data:action.data //result.data
    })
  } catch (error) {
    yield put({
      type:'REMOVE_POST_FAILURE',
      data:error.response.data
    })
  }
}

function loadpostsApi(data){
  return axios.get('/posts',data);
}
function* loadposts(action){
  //const result = yield call(loadpostsApi); //처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type:'LOAD_POSTS_SUCCESS',
      data:generateDummyPost(10),
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
/////step1) all()
export default function*postSaga() {
  yield all([ //all - 동시에 배열로 받은 fork들을 동시에 실행
    fork(watchAddPost),
    fork(watchAddComment),
    fork(watchRemovePost),
    fork(watchLoadPosts),
  ]);
}

// fork - generator 함수들을 실행해줌.
//  all - 동시에 배열로 받은 fork들을 동시에 실행
// yield