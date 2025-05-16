module.exports = (sequelize,DataTypes)=>{

  const Post = sequelize.define('Post',{
    //id 기본값으로 자동설정
    content:{
      type : DataTypes.TEXT,
      allowNull:false
    }
  },{
    charset:'utf8mb4',
    collate:'utf8mb4_general_ci' // 한글저장
  }); 
  ///관계설정
  Post.associate = (db)=>{
    db.Post.hasMany(db.Image); //post.addImages, post.getImages
    db.Post.hasMany(db.Comment); //post.addComments, post.getComments
    db.Post.belongsTo(db.User); //post.addUser, post.getUser, post.setUser
    db.Post.belongsTo(db.Post,{as:'Retweet'}); //post.addRetweet
    db.Post.belongsToMany(db.Hashtag,{through:'PostHashtag'}); //post.addHashtags
    db.Post.belongsToMany(db.User,{through:'Like',as:'Likers'}); //post.addLIkers, post.removeLikers
  };
  return Post;
};