/**  @author panqt 2019/04/04 22:16  */
$(function () {

    $("#login").click(function () {
        var data = {};
        var fromdata = $("#from").serializeArray();
        $.each(fromdata, function() {
            data [this.name] = this.value;
        });

        $.send("auth",data,"get",function (data) {
            window.location.href=contextPath+"welcome"
        })
    });

    $("#captcha").click(function () {
        var data = {};
        $.send("captcha",data,"get",function (data) {
            $("#captcha").attr("src",data);
        })
    });
});