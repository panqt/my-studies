/**  @author panqt 2019/03/22 9:18
 *
 *   @see  https://www.cnblogs.com/tylerdonet/p/3520862.html
 * */

$(function () {
    //这是一个js对象，不是JSON对象 ！！！！
    var jsdata = {userId:55,userName:"哈哈哈",departmentId:12,roleId:13};

    //标准JSON对象是有双 "" 的..
    var data = {"userId":55,"userName":"哈哈哈","departmentId":12,"roleId":13};
    var list = [1,2,3];
    send("ajax/post","POST",data);
    send("ajax/get/55","GET",data);
    send("ajax/put","PUT",data);
    send("ajax/delete/1","DELETE",data);
    send("ajax/delete-list","DELETE",list);
});

function send(url,method,data) {
    $.ajax({
        type: method,
        url: "http://localhost/"+url,
        data: method.toUpperCase()=="GET"?data:JSON.stringify(data), //GET方法不带参数，是自动转化为URL，所以不能转为JSON字符串
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function(data){
            console.log(data);
        }
    });
}