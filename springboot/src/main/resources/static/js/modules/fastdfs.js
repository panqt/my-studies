/**
 *    @time    2019年03月18日    9:04
 *    @author  panqt
 *
 *    @comment
 */
$(function () {

    //清楚图片显示
    $("#clear_display").click(function () {
        $("#img").attr("src","");
    });

    //Multipart 文件上传
    $("#upload-mu").click(function () {
        var form = new FormData();
        //console.log(document.getElementById("file").files[0]);
        //console.log($("#file").prop('files')[0]);
        form.append("file", $("#file").prop('files')[0]);
        $.upload("fastdfs/upload-mu",form,function (url) {
            $("#img").attr("src",url);
            $("#url_text").text("因为是直接上传的图片，可以直接访问的路径：\n"+url);
        });
    });



    //文件转成base64 并上传
    $("#encode").click(function () {
        var file = $("#file")[0].files[0];
        var exName = file.name.substr(file.name.lastIndexOf('.')+1);
        getBase64ByImg(file,function (dataURL) {
            $("#base64_text").text(dataURL);
            $("#img").attr("src",dataURL);
            var data = {
                "base64Text":dataURL,
                "exName":exName
            }
            $.send("fastdfs/upload-base64",data,"post",function (result) {
                $("#url_text").text("因为是上传的base64字符串，不可以直接访问，需要解码：\n"+result);
                $("#download_base64_text").text("因为是上传的base64字符串，不可以直接访问，可以从web服务器间接访问获得base64字符串：\n"+result);
            });
        });
    });

    //Url直接访问FastDFS，转Base64
    $("#decode_url").click(function () {
        var url = $("#url_text").text();
        url = url.substr(url.indexOf("http://"))
        getBase64ByURL(url,function (base64) {
            $("#url_text").text(base64);
            $("#img").attr("src",base64);
        });
    });



    //从服务器下载Base64
    $("#download_base64").click(function () {
        var url = $("#download_base64_text").text();
        url = url.substr(url.indexOf("http://"))
        var data = {
            "visitUrl":url
        };
        $.send("fastdfs/download-base64",data,"post",function (data) {
            $("#download_base64_text").text(data);
            $("#img").attr("src",data);
        });
    });


    //清空服务器
    $("#clear_server").click(function () {
        $.send("fastdfs/deleteAll",{},"post",function (result) {
            alert(result);
        });
    });

});
