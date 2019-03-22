/**
 *    @time    2019年03月18日    10:46
 *    @author  panqt
 *
 *    @comment
 */

$.extend({
    request: function (url, json, method, callback) {
        send(url, JSON.stringify(json), method, callback, 'application/json');
    },
    upload: function (url, file ,callback) {
        send(url, file,"post", callback, false);
    }
});

function send(url, data, method, callback, contentType) {
    $.ajax({
        url: "http://localhost/" + url,
        type: method,
        cache: false,
        data: data,
        processData: false,
        contentType: contentType,
        dataType: 'text',
        async: true,
        success: function (result) {
            var result = JSON.parse(result);
            console.log(result)

            if(result.code == 200){
                callback(result.data);
            }else {
                alert(result.message);
            }
        },
        error: function (err) {
            alert("系统错误");
        }
    });
}




