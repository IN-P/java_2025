import shortId from 'shortid';

export const initialState = {
  mainPosts:[{
    id:1,
    User:{id:1,nickname:'pin890707'},
    content:'첫번째 게시글 #node #react',
    Images:[
      {id:shortId.generate(), src:'https://i.namu.wiki/i/b9WxUGAQqeQwZpwqGM3OZQj6cNt2__LYsJpyh2rZ8esEmBmWxJmHRcY6sav43xkRhncEfueT2OhQ9PhgNRlJ7Q.webp'},
      {id:shortId.generate(), src:'https://i.namu.wiki/i/lJMFyyKuJtVBT3NWHmBt2MxsNnvOxihovkIq5kZcPkfdUlor1Dw0CVgfi4iJaqDM0YuT97fCOrvTzEG7S-e7bD5kPWtLfgQEZo5og1pkYXHnBJ2Rh5okR2Fme5h9MjdTqcITjR0rlI2hDtxguaeKeA.webp'},
      {id:shortId.generate(), src:'https://i.namu.wiki/i/PfU9ex4pq6iorVAFB6mANUQpIBpgL9uBDDmo5jlB07ul2eXDEheIYQ_-MPuZInBKLz79pJKbNeramn7qDaY3MVxzXrilGjqCQN6DGmrlUzxuDIxt3EDYCXvwOeJcr-W1amMCJTf3mu11kS_4z0u4gw.webp'},
    ],
    Comments:[{
        id:shortId.generate(),
        User:{id:shortId.generate(), nickname:'one'},content:'hello'
      },{
        User:{id:shortId.generate(), nickname:'two'},content:'bye'
      },],
  }], 
  //////////////////////////////추가
  //postAdd:false,
  imagePaths:[],
  hasMorePosts: true,

  loadPostsLoading: false,
  loadPostsDone: false,
  loadPostsError: null,

  addPostLoading: false,
  addPostDone: false,
  addPostError: null,

  removePostLoading: false,
  removePostDone: false,
  removePostError: null,

  addCommentLoading: false,
  addCommentDone: false,
  addCommentError: null,
  /////////////////////////// 추가 END   
}


/////////////////////////// action
export const loadPosts = ()=>{
  return {}
};
export const addPost = {type:'ADD_POST',}

//////// dummyPost
const dummyPost = (data)=>({
  //id:2,
  id:shortId.generate(),
  content: data,
  User:{id:1,nickname:'devil'},
  Images:[],
  Comments:[],
});

const dummyComment = (data)=>({
  //id:2,
  id:shortId.generate(),
  User: {id:666,nickname: 'devil'},
  content: data,
});

export const LOAD_POSTS_REQUEST = 'LOAD_POSTS_REQUEST';
export const LOAD_POSTS_SUCCESS = 'LOAD_POSTS_SUCCESS';
export const LOAD_POSTS_FAILURE = 'LOAD_POSTS_FAILURE';

export const ADD_POST_REQUEST = 'ADD_POST_REQUEST';
export const ADD_POST_SUCCESS = 'ADD_POST_SUCCESS';
export const ADD_POST_FAILURE = 'ADD_POST_FAILURE';

export const REMOVE_POST_REQUEST = 'REMOVE_POST_REQUEST';
export const REMOVE_POST_SUCCESS = 'REMOVE_POST_SUCCESS';
export const REMOVE_POST_FAILURE = 'REMOVE_POST_FAILURE';

export const ADD_COMMENT_REQUEST = 'ADD_COMMENT_REQUEST';
export const ADD_COMMENT_SUCCESS = 'ADD_COMMENT_SUCCESS';
export const ADD_COMMENT_FAILURE = 'ADD_COMMENT_FAILURE';

/////////////////////////////////////////////// next
export default (state=initialState,action)=>{
  switch (action.type) {
    case ADD_POST_REQUEST:
      return{
        ...state,
        addPostLoading: true,
        addPostDone: false,
        addPostError: null,
      }
    case ADD_POST_SUCCESS:
      return{
        ...state,
        addPostLoading: false,
        addPostDone: true,
        mainPosts:[dummyPost(action.data), ...state.mainPosts], // 맨앞으로
        //mainPosts:[...state.mainPosts, dummyPost], // 맨뒤로
      }
    case ADD_POST_FAILURE:
      return{
        ...state,
        addPostLoading: false,
        addPostError: action.error,
      }
    ///////////////////////////////////////////////////
    case ADD_COMMENT_REQUEST:
      return{
        ...state,
        addCommentLoading: true,
        addCommentDone: false,
        addCommentError: null,        
      }    
    case ADD_COMMENT_SUCCESS:
      //1. postIndex 해당글 가져오기
      const postIndex = state.mainPosts.findIndex(v=>v.id===action.data.postId);
      const post = {...state.mainPosts[postIndex]};
      //2. post.Comments
      post.Comments = [dummyComment(action.data.content), ...post.Comments];
      //3. mainPosts 추가
      const mainPosts = [...state.mainPosts];
      mainPosts[postIndex] = post;
      return{
        ...state,
        addCommentLoading: false,
        addCommentDone: true,
        mainPosts,
      }    
    case ADD_COMMENT_FAILURE:
      return{
        ...state,
        addCommentLoading: false,
        addCommentError: action.error,
      }   
    ///////////////////////////////////////////////////
    case REMOVE_POST_REQUEST:
      return{
        ...state,
        removePostLoading: true,
        removePostDone: false,
        removePostError: null,
      }    
    case REMOVE_POST_SUCCESS:
      return{
        ...state,
        mainPosts:state.mainPosts.filter(v=>v.id!==action.data),
        removePostLoading: false,
        removePostDone: true,
      }    
    case REMOVE_POST_FAILURE:
      return{
        ...state,
        removePostLoading: false,
        removePostError: action.error,
      }     
    ///////////////////////////////////////////////////
    case LOAD_POSTS_REQUEST:
      return{
        ...state,

      }    
    case LOAD_POSTS_SUCCESS:
      return{
        ...state,

      }    
    case LOAD_POSTS_FAILURE:
      return{
        ...state,

      }    
    ///////////////////////////////////////////////////
    default:{
      return {...state,}
    }
  }
}