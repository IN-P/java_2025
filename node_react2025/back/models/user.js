module.exports = (sequelize,DataTypes)=>{
  ///const User
  const User = sequelize.define('User',{
    //id 기본값으로 자동설정
    email:{
      type : DataTypes.STRING(30), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETME
      allowNull:false, //필수
      unique:true //고유값
    },
    nickname:{
      type : DataTypes.STRING(30), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETME
      allowNull:false, //필수      
    },
    password:{
      type : DataTypes.STRING(100), // STRING, TEXT, BOOLEAN, INTEGER, FLOAT, DATETME
      allowNull:false, //필수      
    },
  },{
    charset:'utf8',
    collate:'utf8_general_ci' // 한글저장
  }); //users테이블 - 자동으로 s 붙어서 생성
  ///관계설정
  User.associate = (db)=>{
    db.User.hasMany(db.Post);
    db.User.hasMany(db.Comment);
    db.User.belongsToMany(db.Post,{through:'Like',as:'Liked'});
    db.User.belongsToMany(db.User,{through:'Follow',as:'Followers',foreignKey:'FollowingId'});
    // user.getFollowers() followingId 를 기준으로 관계 설정
    db.User.belongsToMany(db.User,{through:'Follow',as:'Followings',foreignKey:'FollowerId'});
    // user.getFollowings() followerId 를 기준으로 관계 설정
  };
  return User;
};