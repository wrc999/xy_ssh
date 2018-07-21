<%@ page language="java" pageEncoding="UTF-8"%>
 <!DOCTYPE HTML>
 <html>
   <head>
     <title>图片上传</title>
     <style type="text/css">
     form{
     text-align:center;
     font-size:20px;
     font-family: "PingFang SC","Hiragino Sans GB","Microsoft Yahei";
    
     }
     input{
     font-size:20px;
     font-family: "PingFang SC","Hiragino Sans GB","Microsoft Yahei";
     
     }
     .top{
     width:100%;
     height:100px;
     font-size: 35px;
     text-align: center;
     line-height:100px;
     font-family: "PingFang SC","Hiragino Sans GB","Microsoft Yahei";
     color:rgb(93,169,249);
     }
     .main{
     width:570px;
     height:400px;
     border:1px solid rgb(93,169,249);
     margin:auto;
     }
    .mainhead{
    background:rgb(216,228,241);
    width:570px;
    height:35px;
    margin:auto;
    text-align: left;
    line-height:35px;
    font-size:20px;
    }
    .mainbotton{
    width:470px;
    height:250px;
    border:1px solid rgb(93,169,249);
    margin:auto;
    }
     </style>
   </head>
    
    <body>
    <div class="top">记录美好校园</div>
     <div class="main" >
     <div class="mainhead">上传图片</div><br/>
     <form action="/xy_ssh/upload_cx" enctype="multipart/form-data" method="post">
    <div style="padding-left:420px"><input type="submit"  style="background:rgb(221,232,254)" value="开始上传"></div>    
    <br>
    <div class="mainbotton">    
        <h4 style="padding-right:350px">图片1:</h4>
        <input type="file" name="file" ><br/>
     </div> 
     <div align="left" style="font-size:16px;padding-left:25px;line-height:200%">享悦工作室</div>  
    </form>
    </div>
   </body>
 </html>