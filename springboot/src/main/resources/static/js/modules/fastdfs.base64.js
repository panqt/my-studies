/**  @auther panqt 2019/03/20 22:50
 *
 *   解决图片，base64 之间的相互转换问题
 * */


/** 把本地图片 编码成 base64 字符串，上传到web服务器，web服务器再上传到文件服务器
 *
 * */
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





/** 从web服务器 获得 图片的访问地址。客户端用地址访问文件服务器。获得 base64 图片
 *
 * */

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
