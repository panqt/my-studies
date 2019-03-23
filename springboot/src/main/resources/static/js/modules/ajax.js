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
    $.send("ajax/post",data,"POST",function (data) {

    });
    $.send("ajax/get/55",data,"GET",function (data) {

    });
    $.send("ajax/put",data,"PUT",function (data) {

    });
    $.send("ajax/delete/1",data,"DELETE",function (data) {

    });
    $.send("ajax/delete-list",list,"DELETE",function (data) {

    });
});