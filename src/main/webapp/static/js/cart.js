$(function (){
  $.get("GetCartServlet",function (data){
     console.log(data);
     for (num in data.cartitems){
        $("#bookmain").append('<tr>'+
            '      <td class="text-center"><input class="" type="checkbox" id="'+data.cartitems[num].book.id+'"></td>'+
            '      <th scope="row">'+
            '         <div class="float-left">'+
            '            <a href="#"><img src="'+data.cartitems[num].book.image+'" class="" alt="..."></a>'+
            '         </div>'+
            '         <div class="float-left ml-4">'+
            '            <h3><i style="color: darkred" class="bi bi-book"></i>  '+data.cartitems[num].book.name+'</h3>'+
            '            <small>'+data.cartitems[num].book.description+'</small>'+
            '            <h6 class=""><small class="mr-4">作者:  '+data.cartitems[num].book.author+'</small><small>类别:  '+data.cartitems[num].book.category_name+'</small></h6>'+
            '         </div>'+
            '      </th>'+
            '      <td>'+data.cartitems[num].book.category_name+'</td>'+
            '      <td><i style="font-size: 0.2rem;" class="bi bi-currency-yen ml-2"></i>'+data.cartitems[num].book.price+'</td>'+
            '      <td>' +
            '<div class="input-group input-group-sm">\n' +
            '                    <button class="btn btn-outline-secondary" asd="dash" onclick="numchange(this)" type="button"><i class="bi bi-dash"></i></button>\n' +
            '                    <div class="col-sm-2 p-0">\n' +
            '                        <input id="booknum" class="form-control text-center"value="'+data.cartitems[num].num+'">\n' +
            '                    </div>\n' +
            '                    <button class="btn btn-outline-secondary" asd="plus" onclick="numchange(this)" type="button"><i class="bi bi-plus"></i></button>\n' +
            '                </div>' +
            '</td>'+
            '      <td  style="color: red;"><i style="font-size: 0.2rem;" class="bi bi-currency-yen ml-2"></i>'+data.cartitems[num].price+'</td>'+
            '   </tr>')
     }
     $("#allbooknum").text(data.cartitems.length);

  });
});
// function numchange(e){
//     console.log(e)
//     console.log(e.attr("asd"))
//     if (e.attr("asd")==="dash"){
//         if ( $("#booknum").val()>1){
//             $("#booknum").val(parseInt(e.next().val())-1);
//         }
//     }else if (e.attr("asd")==="plus"){
//         $("#booknum").val(parseInt(e.prev().val())+1);
//     }
//     console.log($("#booknum").val())
// }

