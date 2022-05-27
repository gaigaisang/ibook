<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>跳转....</title>
  <link rel="stylesheet" href="static/css/bootstrap.css">
  <script src="static/js/jquery-3.6.0.js"></script>
  <script src="static/js/bootstrap.bundle.js"></script>
</head>
<body>

</body>
<script type="text/javascript">
    var state="";
    if (${requestScope.msg}){
        $("body").append('<div class="alert alert-success ml-lg-5 mr-lg-5 mt-lg-4" role="alert"> <h4 class="alert-heading">Success!</h4> <p>恭喜你！已成功激活！</p> <hr> <p class="mb-0" id="p1"></p> </div>')
        state="已完成激活 ";
    }else{
        $("body").append('<div class="alert alert-danger ml-lg-5 mr-lg-5 mt-lg-4" role="alert"> <h4 class="alert-heading">Error!</h4> <p>激活失败！</p> <hr> <p class="mb-0" id="p1"></p> </div>')
        state="此电子邮箱认证链接错误或已无效，请重新发送验证邀请 ";
    }
  setInterval(jump,1000);
  var sec = 5;
  function jump(){
    sec--;
    if(sec > 0){
      document.getElementById('p1').innerHTML =state+sec+'s 后跳转到首页';
    }else{
      window.location.href = 'index.html';
    }
  }
</script>


</html>