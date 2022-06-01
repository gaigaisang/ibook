$(function () {
    var category = "all"
    var pageIndex = 1
    $.get("ShowBookServlet", {category: category, index: pageIndex}, function (data) {
        if (data) {
            for (num in data.list) {
                $("#bookmain").append('<div class="col-sm-6 col-md-4 col-lg-3 ">' +
                    ' <div class="card" style="width: 18rem;"> ' +
                    '<a href="http://localhost:8080/ibook/">' +
                    '<img src="'+data.list[num].image+'" class="card-img-top" alt="..."></a>' +
                    ' <div class="card-body">' +
                    ' <p><small>书名：<strong>'+data.list[num].name+'</strong></small></p> ' +
                    '<p><small>作者：<strong>'+data.list[num].author+'</strong></small></p> ' +
                    '<p><small>价格：<strong>'+data.list[num].price+'</strong></small></p> ' +
                    '<button type="button" class="btn btn-primary" onclick="addToCart('+data.list[num].id+')">添加到购物车 </button> ' +
                    '</div> </div> </div>')
            }
            console.log(data)
        }
    });
});
function addToCart(bookid){
    $.post("AddToCartServlet",{bookid:bookid},function (data) {
        if (data===1) {
            $("#toasttext").innerText="添加成功"
        }else if(data===2) {
            $("#toasttext").innerText="添加失败，请检查是否登录。"
        }else if(data===3) {
            alert("添加失败")
        }
        $('#liveToast').toast({delay: 3000});
        $('#liveToast').toast('show');
    });
}