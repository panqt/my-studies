/**  @auther panqt 2019/03/21 16:23  */

$(function () {

    $("#send").click(function () {
        var target = $("#target").val();
        var titil = $("#titil").val();
        var text = $("#text").text();

        var data = {
            "target":target,
            "titil":titil,
            "text":text
        };

        $.send("modules/send-mail",data,"post",function (data) {
            alert(data);
        })
    });
});