/**  @auther panqt 2019/03/21 16:49  */
$(function () {
    $("#set").click(function () {

        console.log($("#fromset").serialize()); // userId=12&userName=userName-12&departmentId=departmentId-12&roleId=roleId-12

        var data = {};

        var fromdata = $("#fromset").serializeArray();
        $.each(fromdata, function() {
           data [this.name] = this.value;
        });
        console.log(data)


        $.send("redis/set",data,"post",function (data) {
            alert(data);
        })
    });


    $("#get").click(function () {
        var userId = $("#userId").val();
        $.send("redis/get",{"userId":userId},"post",function (data) {
            $('#fromget').formEdit(data);
        })
    });
});











$.fn.formEdit = function(data){
    return this.each(function(){
        var input, name;
        if(data == null){this.reset(); return; }
        for(var i = 0; i < this.length; i++){
            input = this.elements[i];
            //checkbox的name可能是name[]数组形式
            name = (input.type == "checkbox")? input.name.replace(/(.+)\[\]$/, "$1") : input.name;
            if(data[name] == undefined) continue;
            switch(input.type){
                case "checkbox":
                    if(data[name] == ""){
                        input.checked = false;
                    }else{
                        //数组查找元素
                        if(data[name].indexOf(input.value) > -1){
                            input.checked = true;
                        }else{
                            input.checked = false;
                        }
                    }
                    break;
                case "radio":
                    if(data[name] == ""){
                        input.checked = false;
                    }else if(input.value == data[name]){
                        input.checked = true;
                    }
                    break;
                case "button": break;
                default: input.value = data[name];
            }
        }
    });
};