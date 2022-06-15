$.get("GetUserServlet",function (data) {
    console.log(data);
    if(data){
        $("body").prepend('<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">' +
            ' <a class="navbar-brand" href="index.html">' +
            ' <img src="static/img/logo1.png" width="30" height="30" class="d-inline-block align-top rounded" alt="">' +
            '    iBook' +
            ' </a>' +
            ' <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"' +
            '    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">' +
            ' <span class="navbar-toggler-icon"></span>' +
            ' </button>' +
            '   <div class="collapse navbar-collapse" id="navbarSupportedContent">' +
            '     <ul class="navbar-nav mr-auto">' +
            '     <li class="nav-item dropdown">' +
            '     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"' +
            '       data-toggle="dropdown" aria-expanded="false">' +
            '        <i style="color: tomato;" class="bi bi-geo-alt"></i>地址' +
            '   </a>' +
            '               <div class="dropdown-menu" aria-labelledby="navbarDropdown">' +
            '                   <a class="dropdown-item" href="#">中国大陆</a>' +
            '                   <div class="dropdown-divider"></div>' +
            '                   <a class="dropdown-item" href="#">河北</a>' +
            '                   <a class="dropdown-item" href="#">北京</a>' +
            '               </div>' +
            '           </li>' +
            '       </ul>' +
            '       <form class="form-inline my-2 my-lg-0">' +
            '           <ul class="navbar-nav mr-auto">' +
            '               <li class="nav-item active">' +
            '                   <span class="nav-link" href="login.html">欢迎 '+data+'<span class="sr-only">(current)</span></>' +
            '' +
            '               </li>' +
            '               <li class="nav-item active">' +
            '                   <a class="nav-link" href="#" onclick="quit()">退出<span class="sr-only">(current)</span></a>' +
            '               </li>' +
            '               <li class="nav-item">' +
            '                   <a class="nav-link" href="register.html">注册 <span class="sr-only">(current)</span></a>' +
            '               </li>' +
            '               <li class="nav-item">' +
            '                  <button class="btn btn-light my-2 my-sm-0" type="submit"><a style="text-decoration: none;"' +
            '                                                                                   href="cart.html">购物车<small></small></a>' +
            '                   </button>' +
            '               </li>' +
            '               <li class="nav-item">' +
            '                   <a class="nav-link" href="home.html">我的 <span class="sr-only">(current)</span></a>' +
            '               </li>' +
            '           </ul>' +
            '       </form>' +
            '   </div>' +
            '</nav>');
    }else {
        $("body").prepend('<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">' +
            ' <a class="navbar-brand" href="index.html">' +
            ' <img src="static/img/logo1.png" width="30" height="30" class="d-inline-block align-top rounded" alt="">' +
            '    iBook' +
            ' </a>' +
            ' <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"' +
            '    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">' +
            ' <span class="navbar-toggler-icon"></span>' +
            ' </button>' +
            '   <div class="collapse navbar-collapse" id="navbarSupportedContent">' +
            '     <ul class="navbar-nav mr-auto">' +
            '     <li class="nav-item dropdown">' +
            '     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"' +
            '       data-toggle="dropdown" aria-expanded="false">' +
            '        <i style="color: tomato;" class="bi bi-geo-alt"></i>地址' +
            '   </a>' +
            '               <div class="dropdown-menu" aria-labelledby="navbarDropdown">' +
            '                   <a class="dropdown-item" href="#">中国大陆</a>' +
            '                   <div class="dropdown-divider"></div>' +
            '                   <a class="dropdown-item" href="#">河北</a>' +
            '                   <a class="dropdown-item" href="#">北京</a>' +
            '               </div>' +
            '           </li>' +
            '       </ul>' +
            '       <form class="form-inline my-2 my-lg-0">' +
            '           <ul class="navbar-nav mr-auto">' +
            '               <li class="nav-item active">' +
            '                   <a class="nav-link" href="login.html">你好，请登录<span class="sr-only">(current)</span></a>' +
            '' +
            '               </li>' +
            '               <li class="nav-item">' +
            '                   <a class="nav-link" href="register.html">注册 <span class="sr-only">(current)</span></a>' +
            '               </li>' +
            '               <li class="nav-item">' +
            '                  <button class="btn btn-light my-2 my-sm-0" type="submit"><a style="text-decoration: none;"' +
            '                                                                                   href="cart.html">购物车<small></small></a>' +
            '                   </button>' +
            '               </li>' +
            '               <li class="nav-item">' +
            '                   <a class="nav-link" href="#">后台 <span class="sr-only">(current)</span></a>' +
            '               </li>' +
            '           </ul>' +
            '       </form>' +
            '   </div>' +
            '</nav>');
    }
});
function quit(){
    $.get("QuitServlet",function (data) {
        console.log(data);
        if(data){
            location.href="index.html";
        }
    });
}
