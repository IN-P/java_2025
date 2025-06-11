import shortId from 'shortid';
import produce from 'immer';
import {faker} from '@faker-js/faker';
faker.seed(123);

export const initialState = {
  mainPosts:[],
  imagePaths:[],
  hasMorePosts: true,

  loadPostsLoading: false, //더미데이터 무한스크롤링
  loadPostsDone: false,
  loadPostsError: null,

  addPostLoading: false, //글쓰기
  addPostDone: false,
  addPostError: null,

  updatePostLoading: false,
  updatePostDone: false,
  updatePostError: false,
  
  removePostLoading: false,
  removePostDone: false,
  removePostError: null,
  
  addCommentLoading: false,
  addCommentDone: false,
  addCommentError: null,
  /////////////////////////// 추가 END   
  
  uploadImagesLoading: false,
  uploadImagesDone: false,
  uploadImagesError: false,
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

//10개씩 무한스크롤 부르는 메서드
export const generateDummyPost = (number)=>Array(number).fill().map(()=>({
  id:shortId.generate(),
  User:{id:shortId.generate(),nickname:faker.internet.username(),},
  content:faker.lorem.paragraph(),
  Images:[{src:faker.image.avatar()},],
  Comments:[{id:shortId.generate(),User:{id:shortId.generate(),nickname:faker.internet.username(),},content:faker.lorem.sentence()},],
}));

export const LOAD_POSTS_REQUEST = 'LOAD_POSTS_REQUEST';
export const LOAD_POSTS_SUCCESS = 'LOAD_POSTS_SUCCESS';
export const LOAD_POSTS_FAILURE = 'LOAD_POSTS_FAILURE';

export const ADD_POST_REQUEST = 'ADD_POST_REQUEST';
export const ADD_POST_SUCCESS = 'ADD_POST_SUCCESS';
export const ADD_POST_FAILURE = 'ADD_POST_FAILURE';

export const UPDATE_POST_REQUEST = 'UPDATE_POST_REQUEST';
export const UPDATE_POST_SUCCESS = 'UPDATE_POST_SUCCESS';
export const UPDATE_POST_FAILURE = 'UPDATE_POST_FAILURE';

export const REMOVE_POST_REQUEST = 'REMOVE_POST_REQUEST';
export const REMOVE_POST_SUCCESS = 'REMOVE_POST_SUCCESS';
export const REMOVE_POST_FAILURE = 'REMOVE_POST_FAILURE';

export const ADD_COMMENT_REQUEST = 'ADD_COMMENT_REQUEST';
export const ADD_COMMENT_SUCCESS = 'ADD_COMMENT_SUCCESS';
export const ADD_COMMENT_FAILURE = 'ADD_COMMENT_FAILURE';

export const UPLOAD_IMAGES_REQUEST = 'UPLOAD_IMAGES_REQUEST';
export const UPLOAD_IMAGES_SUCCESS = 'UPLOAD_IMAGES_SUCCESS';
export const UPLOAD_IMAGES_FAILURE = 'UPLOAD_IMAGES_FAILURE';

export const REMOVE_IMAGE = 'REMOVE_IMAGE';

/////////////////////////////////////////////// next
const reducer = (state=initialState,action)=>produce(state,(draft)=>{
  switch (action.type) {
    case ADD_POST_REQUEST:
      draft.addPostLoading = true;
      draft.addPostDone = false;
      draft.addPostError = null;
      break;
    case ADD_POST_SUCCESS:
      draft.mainPosts.unshift(action.data);
      draft.imagePaths=[];
      draft.addPostLoading = false;
      draft.addPostDone = true;
      break;
    case ADD_POST_FAILURE:
      draft.addPostLoading = false;
      draft.addPostError = action.error;
      break;
    ///////////////////////////////////////////////////
    case UPDATE_POST_REQUEST:
      draft.updatePostLoading = true;
      draft.updatePostDone = false;
      draft.updatePostError = null;
      break;
    case UPDATE_POST_SUCCESS:
      draft.mainPosts.find((v)=>v.id===action.data.PostId).content = action.data.content
      draft.imagePaths=[];
      draft.updatePostLoading = false;
      draft.updatePostDone = true;
      break;
    case UPDATE_POST_FAILURE:
      draft.updatePostLoading = false;
      draft.updatePostError = action.error;
      break;
    ///////////////////////////////////////////////////
    case UPLOAD_IMAGES_REQUEST:
      draft.uploadImagesLoading = true;
      draft.uploadImagesDone = false;
      draft.uploadImagesError = null;
      break;
    case UPLOAD_IMAGES_SUCCESS:
      draft.imagePaths = action.data;
      draft.uploadImagesLoading = false;
      draft.uploadImagesDone = true;
      break;
    case UPLOAD_IMAGES_FAILURE:
      draft.uploadImagesLoading = false;
      draft.uploadImagesError = action.error;
      break;
    ///////////////////////////////////////////////////
    case REMOVE_POST_REQUEST:
      draft.removePostLoading = true;
      draft.removePostDone = false;
      draft.removePostError = null;   
      break;
    case REMOVE_POST_SUCCESS:
      draft.mainPosts = draft.mainPosts.filter(v=>v.id!==action.data);
      draft.removePostLoading = false;
      draft.removePostDone = true;
      break;   
    case REMOVE_POST_FAILURE:
      draft.removePostLoading = false;
      draft.removePostError = action.error;   
      break;
    ///////////////////////////////////////////////////
    case ADD_COMMENT_REQUEST:
      draft.addCommentLoading = true;
      draft.addCommentDone = false;
      draft.addCommentError = null;    
      break;    
    case ADD_COMMENT_SUCCESS:
      const post = draft.mainPosts.find(v => v.id === action.data.PostId);
      post.Comments.unshift(action.data);
      draft.addCommentLoading = false;
      draft.addCommentDone = true; 
      break;
    case ADD_COMMENT_FAILURE:
      draft.addCommentLoading = false;
      draft.addCommentError = action.error;    
      break; 
    ///////////////////////////////////////////////////
    case LOAD_POSTS_REQUEST:
      draft.loadPostsLoading = true;
      draft.loadPostsDone = false;
      draft.loadPostsError = null;
      break;
    case LOAD_POSTS_SUCCESS:
      draft.loadPostsLoading = false;
      draft.loadPostsDone = true;
      draft.mainPosts = action.data.concat(draft.mainPosts); //새로운 데이터10 + 기존데이터
      draft.hasMorePosts = draft.mainPosts.length<50; //게시물 50개 부근 보이게 체크
      break;
    case LOAD_POSTS_FAILURE:
      draft.loadPostsLoading = false;
      draft.loadPostsError = action.error;
      break;
    ///////////////////////////////////////////////////
    default:{ break;}
  }
});

export default reducer;
