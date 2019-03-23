/**
 *    @time    2019年03月18日    10:46
 *    @author  panqt
 *
 *    @comment
 */
//var contextPath = "http://localhost:80/";
var contextPath = "http://localhost:80/springboot/";
//var contextPath = "http://192.168.200.200/springboot/";


// var form = new FormData();
// var file = form.append("file", $("#file").prop('files')[0]);
$.extend({
    send: function (url, jsonObject, method, callback) {
        var data = method.toUpperCase()=="GET"?jsonObject:JSON.stringify(jsonObject);//GET方法不带参数，是自动转化为URL，所以不能转为JSON字符串
        request(url,data, method, callback, "application/json;charset=UTF-8",true);
    },
    upload: function (url, file ,callback) {
        request(url, file,"post", callback, false,false);
    }
});

function request(url,data,method,callback,contentType,processData) {
    $.ajax({
        type: method,
        url: contextPath+url,
        data: data,
        dataType: "json",
        processData: processData, //用于对data参数进行序列化处理
        contentType: contentType,
        async: true,
        withCredentials: true,
        success: function(data){
            console.log(data);
            if(data.code == 200){
                callback(data.data);
            }else {
                alert(data.message);
            }
        },
        error: function (err) {
            alert("系统错误");
        }
    });
}


