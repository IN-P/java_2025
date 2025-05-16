const express=require('express');
const app=express();
const test = require('./router/test'); //##

app.get('/',(req,res)=>{res.send('hello');});

app.use('/test',test); //##

app.listen(3065,()=>{console.log('서버실행중');})
