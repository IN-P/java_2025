module.exports = (sequelize,DataTypes)=>{

  const Hashtag = sequelize.define('Hashtag',{
    //id 기본값으로 자동설정
    name:{
      type : DataTypes.STRING(200),
      allowNull:false
    }
  },{
    charset:'utf8mb4',
    collate:'utf8mb4_general_ci' // 한글저장
  }); 
  ///관계설정
  Hashtag.associate = (db)=>{
    db.Hashtag.belongsToMany(db.Post,{through:'PostHashtag'});
  };
  return Hashtag;
};