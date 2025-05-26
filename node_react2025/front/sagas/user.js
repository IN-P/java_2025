import {all,call,fork,takeLatest,delay,put} from 'redux-saga/effects'
import {
  LOG_IN_REQUEST,LOG_IN_SUCCESS,LOG_IN_FAILURE,
  LOG_OUT_REQUEST,LOG_OUT_SUCCESS,LOG_OUT_FAILURE,
  SIGN_UP_REQUEST,SIGN_UP_SUCCESS,SIGN_UP_FAILURE,
  CHANGE_NICKNAME_REQUEST,CHANGE_NICKNAME_SUCCESS,CHANGE_NICKNAME_FAILURE,
} from '../reducers/user';
import axios from 'axios';

/////step3)
function loginApi(data){
  return axios.post('/user/login',data);
}
function* login(action){
  try {
    const result = yield call(loginApi,action.data); //처리함수, 처리파라미터
    yield delay(1000);
    yield put({
      type:LOG_IN_SUCCESS,
      data:result.data, 
    })
    console.log('.......login success');
  } catch (error) {
    yield put({
      type:LOG_IN_FAILURE,
      data:error.response.data
    })
  }
}

function logoutApi(){
  return axios.post('/user/logout');
}
function* logout(){
  try {
    const result = yield call(logoutApi); //처리함수, 처리파라미터
    yield delay(1000);
    yield put({
      type:LOG_OUT_SUCCESS,
    })
  } catch (error) {
    yield put({
      type:LOG_OUT_FAILURE,
      data:error.response.data
    })
  }
}

function signupApi(data){
  return axios.post('/user',data);
}
function* signup(action){
  try {
    const result = yield call(signupApi,action.data); //처리함수, 처리파라미터
    console.log(result);
    yield put({
      type:SIGN_UP_SUCCESS,
    })
  } catch (error) {
    yield put({
      type:SIGN_UP_FAILURE,
      data:error.response.data
    })
  }
}

function changenicknameApi(data){
  return axios.post('/user/nickname',{nickname:data});
}
function* changenickname(action){
  //const result = yield call(changenicknameApi); //처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type:CHANGE_NICKNAME_SUCCESS,
      data:action.data //result.data
    })
  } catch (error) {
    yield put({
      type:CHANGE_NICKNAME_FAILURE,
      data:error.response.data
    })
  }
}

/////step2) ACTION 기능추가
function*watchLogin(){
  yield takeLatest(LOG_IN_REQUEST,login); //LOG_IN 액션이 실행될때까지 기다리기
}
function*watchLogout(){
  yield takeLatest(LOG_OUT_REQUEST,logout);
}
function*watchSignup(){
  yield takeLatest(SIGN_UP_REQUEST,signup);
}
function*watchChangeNickname(){
  yield takeLatest(CHANGE_NICKNAME_REQUEST,changenickname);
}

/////step1) all()
export default function*userSaga() {
  yield all([ //all - 동시에 배열로 받은 fork들을 동시에 실행
    fork(watchLogin), // fork - generator 함수들을 실행해줌
    fork(watchLogout),
    fork(watchSignup),
    fork(watchChangeNickname)
  ]);
}

// fork - generator 함수들을 실행해줌.
//  all - 동시에 배열로 받은 fork들을 동시에 실행
// yield