首先，base64字符串，浏览器是可以直接解析的，格式是:

```
<img src="data:image/jpeg;base64,xxxxxx" width="320px" height="220px" alt="">
```



##### 1、ajax封装

```js
var contextPath = "http://localhost:80/";

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
```



HTML:

```
<script src="https://code.jquery.com/jquery-1.8.3.js"></script>

<input id="file" type="file" value="选择图片">
<img id="img" src="" width="320px" height="220px" alt="">
<textarea id="url_text" rows="15" cols="47" alt="">url_text</textarea>
```





##### 1、图片直接上传



JS:

```
var form = new FormData();
form.append("file", $("#file").prop('files')[0]);
$.upload("fastdfs/upload-mu",form,function (url) {
    $("#img").attr("src",url);
    $("#url_text").text("因为是直接上传的图片，可以直接访问的路径：\n"+url);
});
```

JAVA:

```
@PostMapping("fastdfs/upload-mu")
public ResultVo<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
    String visitUrl = fdfsClient.uploadFile(file);
    return new ResultVo(visitUrl);
    //返回一个http://localhost/group1/M00/xxxx/xxx.jpg
}
```

将图片直接上传到服务器，返回的URL可以直接访问到图片



##### 2、图片转base64字符串上传



JS

```
var file = $("#file")[0].files[0];
var exName = file.name.substr(file.name.lastIndexOf('.')+1);
getBase64ByImg(file,function (dataURL) {
	$("#url_text").text(dataURL);
	$("#img").attr("src",dataURL);
	var data = {
		"base64Text":dataURL,
		"exName":exName
	}
	$.send("fastdfs/upload-base64",data,"post",function (result) {
		$("#url_text").text("因为是上传的base64字符串，不可以直接访问，需要解码：\n"+result);
	});
});
        
        
function getBase64ByImg(img, callback) {
    var reader = new FileReader();
    var AllowImgFileSize = 2100000; //上传图片最大值(单位字节)（ 2 M = 2097152 B ）超过2M上传失败
    if (img) {
        //将文件以Data URL形式读入页面
        reader.readAsDataURL(img);
        reader.onload = function (e) {
            if (AllowImgFileSize != 0 && AllowImgFileSize < reader.result.length) {
                alert( '上传失败，请上传不大于2M的图片！');
                return;
            }else{
                //执行上传操作
                console.log("图片转base64完成:");
                console.log(reader.result);
                callback(reader.result);
            }
        }
    }
}
```

JAVA:

```
@PostMapping("fastdfs/upload-base64")
public ResultVo<String> uploadBase64(@RequestBody FastdfsFile image) {
	String visitUrl = fdfsClient.uploadFile(image.getBase64Text(),image.getExName());
	return new ResultVo(visitUrl);
	//返回一个http://localhost/group1/M00/xxxx/xxx.jpg,但不能直接访问
}

@Data
public class FastdfsFile {
    /**  base64 字符串 */
    private String base64Text;
    /**  文件拓展名 */
    private String exName;
    /**  fastdfs访问路径 */
    private String visitUrl;
    /**  文件id 用于访问fastdfs */
    private String fileId;
}
```

因为是上传的base64字符串，不可以直接访问



##### 3、Base64字符串上传后访问

图片通过 MultipartFile 上传后可以直接访问，但转base64字符串后却不能直接访问，这里介绍2钟方法。



###### 3.1  通过web服务器下载访问

JS:

```
var data = {
	"visitUrl":url //刚刚上传base64字符串返回的不能直接访问的URL
};
$.send("fastdfs/download-base64",data,"post",function (data) {
	$("#url_text").text(data);
	$("#img").attr("src",data);
});
```

Java:

```
@PostMapping("fastdfs/download-base64")
public ResultVo<String> downloadase64(@RequestBody FastdfsFile image, HttpServletResponse response) throws Exception{
	byte[] data = fdfsClient.download(image.getVisitUrl()
		.substring(image.getVisitUrl().indexOf("group")));
	return new ResultVo(new String(data);
	//返回了可直接显示的base64字符串
}
```



###### 3.2  JS直接访问文件服务器解码

JS：

```
//url为不能直接访问的链接
getBase64ByURL(url,function (base64) {
	$("#url_text").text(base64);
	$("#img").attr("src",base64);
});

function getBase64ByURL(url, callback) {
    var request = new XMLHttpRequest();
    request.open('GET', url, true);
    request.crossOrigin = 'anonymous'
    request.responseType = 'blob';
    request.onload = function () {
        var reader = new FileReader();
        reader.readAsText(request.response);
        reader.onload = function (e) {
            var base64img = e.target.result;
            console.log(base64img);
            callback(base64img);
        };
    };
    request.send();
};
```

注意，这种方法需要文件服务器支持跨域。





Java与文件服务器（FastDFS）之间访问都用的 fileId，即group1/M00/00/00/xxx.jpg 这一串

自己去掉 http://host:port/contextPath/

Over

