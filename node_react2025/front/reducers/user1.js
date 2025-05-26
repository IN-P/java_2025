// step1) 초기값
export const initialState = {
  logInLoading:false, // 로그인 시도중 - 로딩창
  logInDone:false,
  logInError:null, 

  logOutLoading:false, // 로그아웃 시도중 - 로딩창
  logOutDone:false,
  logOutError:null, 

  //////////////////////////////////////// 추가1
  signUpLoading: false, // 회원가입 시도중
  signUpDone: false,
  signUpError: null,

  changeNicknameLoading: false, // 닉네임 변경 시도중
  changeNicknameDone: false,
  changeNicknameError: null,

  followLoading: false, // 팔로우 시도중
  followDone: false,
  followError: null,

  unfollowLoading: false, // 언팔로우 시도중
  unfollowDone: false,
  unfollowError: null,
  //////////////////////////////////////// 추가1- END

  user:null,
  signupDate:{},
  loginData:{}
};

// step2) 로그인할때마다 설정 함수
export const loginAction = (data)=>{
  return {type:'LOG_IN_REQUEST',data,}
};

export const logoutAction = {
  type:'LOG_OUT_REQUEST'
};

export const LOG_IN_REQUEST = 'LOG_IN_REQUEST';
export const LOG_IN_SUCCESS = 'LOG_IN_SUCCESS';
export const LOG_IN_FAILURE = 'LOG_IN_FAILURE';

export const LOG_OUT_REQUEST = 'LOG_OUT_REQUEST';
export const LOG_OUT_SUCCESS = 'LOG_OUT_SUCCESS';
export const LOG_OUT_FAILURE = 'LOG_OUT_FAILURE';

export const SIGN_UP_REQUEST = 'SIGN_UP_REQUEST';
export const SIGN_UP_SUCCESS = 'SIGN_UP_SUCCESS';
export const SIGN_UP_FAILURE = 'SIGN_UP_FAILURE';

export const CHANGE_NICKNAME_REQUEST = 'CHANGE_NICKNAME_REQUEST';
export const CHANGE_NICKNAME_SUCCESS = 'CHANGE_NICKNAME_SUCCESS';
export const CHANGE_NICKNAME_FAILURE = 'CHANGE_NICKNAME_FAILURE';

export const FOLLOW_REQUEST = 'FOLLOW_REQUEST';
export const FOLLOW_SUCCESS = 'FOLLOW_SUCCESS';
export const FOLLOW_FAILURE = 'FOLLOW_FAILURE';

export const UNFOLLOW_REQUEST = 'UNFOLLOW_REQUEST';
export const UNFOLLOW_SUCCESS = 'UNFOLLOW_SUCCESS';
export const UNFOLLOW_FAILURE = 'UNFOLLOW_FAILURE';

//--
const dummyUser = (data)=>({
  ...data,
  nickname:'PIN',
  id:1,
  Posts:[{id:1}],
  Followings:[{nickname:'침착맨'},{nickname:'페이커'},{nickname:'케인'},],
  Followers:[{nickname:'초얼비'},{nickname:'윤기짱'},{nickname:'재원재원'},]
});

// step3) 이전+상태=다음상태
export default (state=initialState,action)=>{
  switch (action.type) { 
    case LOG_IN_REQUEST:   // 액션
      return {
        ...state,    //이전상태
        logInLoading:true, // 로그인 시도중 - 로딩창
        logInDone:false,
        logInError:null, 
      }
    case LOG_IN_SUCCESS:   // 액션
      return {
        ...state,    //이전상태
        logInLoading:false, // 로그인 시도중 - 로딩창
        logInDone:true,
        user:dummyUser(action.data)
      }
    case LOG_IN_FAILURE:   // 액션
      return {
        ...state,    //이전상태
        logInLoading:false, // 로그인 시도중 - 로딩창
        logInError:action.error, // 로그아웃 시도중 - 로딩창
      }
    ///////////////////////////////////////////////////////
      case LOG_OUT_REQUEST:
      return {
        ...state, 
        logOutLoading:true, // 로그아웃 시도중 - 로딩창
        logOutDone:false,
        logOutError:null, 
      }
    case LOG_OUT_SUCCESS:   // 액션
      return {
        ...state,    //이전상태
        logOutLoading:false, // 로그아웃 시도중 - 로딩창
        logOutDone:true, 
        user:null
      }
    case LOG_OUT_FAILURE:   // 액션
      return {
        ...state,    //이전상태
        logOutLoading:false, // 로그아웃 시도중 - 로딩창
        logOutError:action.error, 
      }
    ///////////////////////////////////////////////////////
    case SIGN_UP_REQUEST:
      return {
        ...state, 
        signUpLoading: true, // 회원가입 시도중
        signUpDone: false,
        signUpError: null,
      }
    case SIGN_UP_SUCCESS:   // 액션
      return {
        ...state,    //이전상태
        signUpLoading: false, // 회원가입 시도중
        signUpDone: true,
      
      }
    case SIGN_UP_FAILURE:   // 액션
      return {
        ...state,    //이전상태
        signUpLoading: false, // 회원가입 시도중
        signUpError: action.error, 
      }
    ///////////////////////////////////////////////////////
    case CHANGE_NICKNAME_REQUEST:
      return {
        ...state, 
        changeNicknameLoading: true, // 닉네임 변경 시도중
        changeNicknameDone: false,
        changeNicknameError: null,
      }
    case CHANGE_NICKNAME_SUCCESS:
      return {
        ...state, 
        user:{...state.user,nickname:action.data.nickname},
        changeNicknameLoading: false, // 닉네임 변경 시도중
        changeNicknameDone: true,

      }
    case CHANGE_NICKNAME_FAILURE:
      return {
        ...state, 
        changeNicknameLoading: false, // 닉네임 변경 시도중
        changeNicknameError: action.error,
      }
    ///////////////////////////////////////////////////////
    case FOLLOW_REQUEST:
      return {
        ...state, 
        followLoading: false, // 팔로우 시도중
        followDone: false,
        followError: null,
      }               
    ///////////////////////////////////////////////////////
    case UNFOLLOW_REQUEST:
      return {
        ...state, 
        unfollowLoading: false, // 언팔로우 시도중
        unfollowDone: false,
        unfollowError: null,
      }               
    default:
      return { ...state }
  } 
};