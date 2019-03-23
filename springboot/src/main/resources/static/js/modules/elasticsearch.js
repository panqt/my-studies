/**  @auther panqt 2019/03/21 17:55  */
$(function () {
    $("#set").click(function () {

        console.log($("#fromset").serialize()); // userId=12&userName=userName-12&departmentId=departmentId-12&roleId=roleId-12

        var data = {};

        var fromdata = $("#fromset").serializeArray();
        $.each(fromdata, function() {
            data [this.name] = this.value;
        });
        console.log(data)


        $.send("elasticsearch/save",data,"post",function (data) {
            alert("缓存成功");
        })
    });


    $("#get").click(function () {
        var userId = $("#userId").val();
        $.send("elasticsearch/get",{"userId":userId},"post",function (data) {
            $('#fromget').formEdit(data);
        })
    });

    $("#getLike").click(function () {
        var userName = $("#userName").val();
        $.send("elasticsearch/get-like",{"userName":userName},"post",function (data) {
            $('#fromget').formEdit(data);

            var str = ""
            for (var j = 0; j < data.length; j++) {
                str+=JSON.stringify(data[j])+"\n"
            }
            $("#textarea").text(str);
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