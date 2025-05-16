module.exports = (sequelize,DataTypes)=>{

  const Image = sequelize.define('Image',{
    //id 기본값으로 자동설정
    src:{
      type : DataTypes.STRING(200),
      allowNull:false
    }
  },{
    charset:'utf8',
    collate:'utf8_general_ci' // 한글저장
  }); 
  ///관계설정
  Image.associate = (db)=>{
    db.Image.belongsTo(db.Post);
  };
  return Image;
};