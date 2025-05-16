module.exports = (sequelize,DataTypes)=>{

  const Comment = sequelize.define('Comment',{
    //id 기본값으로 자동설정
    content:{
      type : DataTypes.TEXT,
      allowNull:false
    }
  },{
    charset:'utf8',
    collate:'utf8_general_ci' // 한글저장
  }); 
  ///관계설정
  Comment.associate = (db)=>{
    db.Comment.belongsTo(db.Post);
    db.Comment.belongsTo(db.User);
  };
  return Comment;
};