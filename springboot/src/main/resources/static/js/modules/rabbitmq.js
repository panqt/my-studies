/**  @auther panqt 2019/03/22 3:11  */
$(function () {
    $("#direct").click(function () {

        var message = $("#message").val();

        $.send("rabbitmq/direct",{"message":message},"post",function (data) {
            console.log();
        })
    });


    $("#topic").click(function () {
        var data = {};
        var form = $("#topicform").serializeArray();
        $.each(form, function() {
            data [this.name] = this.value;
        });
        data.routingKey = data.addr + '.' + data.type;

        $.send("rabbitmq/topic",data,"post",function (data) {
            console.log()
        })
    });
});