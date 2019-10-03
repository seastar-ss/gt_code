/**
 * Created by YMKJ on 2017/6/7.
 */
var otherjs = require('../public/otherjs');
// require("../../asset/static/js/jquery.cookie");
// require('../../asset/static/js/writeObject');
$(function(){
    var height=document.body.offsetHeight;
    // var ts=new Date().getTime();
    var ts;
    console.log("time"+ts);
    console.log(height);
    $("#page-wrapper").css("min-height",height);
    $(".wrapper-content").css("height",height);

    // if (!isIE()){
    //     //如果是非IE浏览器，则调用此函数，为控件添加事件处理函数。
    //     doAdd();
    // }

    function doAdd()
    {
        function addEvent(obj, name, func)
        {
            obj.addEventListener(name, func, false);
        }

        function OnUserEventReturn()
        {
            //在收到Edit控件上的回车事件时，将焦点放在id为powerpass_noie的标签上。
            //document.getElementById("powerpass").focus();
        }

        function OnUserEventTab()
        {
            //在收到Edit控件上的Tab事件时，将焦点放在id为powerpass_noie的标签上。
            document.getElementById("powerpass").focus();
        }

        function OnPassEventReturn()
        {
            //在收到Password控件上的回车事件时，将焦点放在id为login的标签上。
            //document.getElementById("login").focus();
        }

        function OnPassEventTab()
        {
            //在收到Password控件上的Tab事件时，将焦点放在id为login的标签上。
            //document.getElementById("login").focus();
            //在收到Password控件上的Tab事件时，将焦点放在id为test2的标签上。
            document.getElementById("test2").focus();
        }
        document.onkeydown = function(e)
        {
            var ev =(typeof e == 'undefined')? window.event:e;
            if(ev.keyCode == 9 && document.activeElement.id == "test1")
            {
                var psObj = document.getElementById( "poweredit" );
                psObj.focus();
            }
        }

        //获取对象
        var poweredit = document.getElementById("poweredit");
        //添加Edit控件的回车事件，如果收到此事件，则触发OnUserEventReturn()函数
        addEvent(poweredit, "EventReturn",OnUserEventReturn);
        //添加Edit控件的Tab事件，如果收到此事件，则触发OnUserEventTab()函数
        addEvent(poweredit, "EventTab",OnUserEventTab);

        //获取对象
        var powerpass = document.getElementById("powerpass");
        //添加Password控件的回车事件，如果收到此事件，则触发OnPassEventReturn()函数
        addEvent(powerpass, "EventReturn",OnPassEventReturn);
        //添加Password控件的Tab事件，如果收到此事件，则触发OnPassEventTab()函数
        addEvent(powerpass, "EventTab",OnPassEventTab);

        //----------------------------------新增非IE浏览器光标事件begin-------------------------------------------------
        //添加Password控件的Focus事件，如果收到此事件，则触发OnPassEventFocus()函数
        // addEvent(powerpass, "EventFocus",OnPassEventFocus);
        //添加Password控件的Blur事件，如果收到此事件，则触发OnPassEventBlur()函数
        // addEvent(powerpass, "EventBlur",OnPassEventBlur);
        //----------------------------------新增非IE浏览器光标事件end-------------------------------------------------

        //添加Password控件的密码强弱度事件，如果收到此事件，则触发OnEventDegree(arg1)函数
        // addEvent(powerpass, "EventDegree",OnEventDegree);
    }



     // function OnPassEventFocus()
     // {
     //     //处理focus事件
     //     window.document.getElementById("EEE").innerHTML = "EventFocus事件";
     // }
     //
     // function OnPassEventBlur()
     // {
     //     //处理blur事件
     //     window.document.getElementById("EEE").innerHTML = "EventBlur事件";
     // }

     //处理非IE浏览器下控件的密码强弱度事件
     // function OnEventDegree(arg1)
     // {
     //     var degree = "";
     //     if(arg1 == "W")
     //     {
     //         degree = "弱";
     //     }
     //     else if(arg1 == "M")
     //     {
     //         degree = "中";
     //     }
     //     else if(arg1 == "S")
     //     {
     //         degree = "强";
     //     }
     //     var passWordLen = powerpass.getLength();
     //     window.document.getElementById("EEE").innerHTML = "密码强度:" + degree + "<br>密码长度：" + passWordLen;
     // }


    $('.loginBtn').click(function(){
        var times={};
        otherjs.ajax({
            url: "/iapro-server/user/getServerTime",
            type: 'post',
            data: JSON.stringify(times),
            contentType: "application/json",
            dataType: "json",
            success: function(data) {
                console.log(data.message);
                ts=new Date(Date.parse(data.message.replace(/-/g, "/")));
                ts=ts.getTime();
                console.log("get stamp:",ts);
                doLogin();
            },
            error: function() {
                window.alert("获取时间失败");
            }
        })
        saveUserInfo();
    })

    function doLogin() {
        //获取用户名密文
        // var username =getEditInput("poweredit", ts ,"EEE", "用户名输入错误：");
        // if(username==null){
        //     return;
        // }
        var userName=$("#userName").val();

        //获取密码密文
        var password =getPassInput("powerpass", ts ,"showText", "密码输入错误：");

        if(userName==""){
                $("#showText").text("");
                $("#showText").css("display", "block");
                $("#showText").text("请输入用户名");
            } else if(password==null){
                $("#showText").text("");
                $("#showText").css("display", "block");
                $("#showText").text("请输入密码");
             return;
        }else {
            var obj = {
                "log_account": userName,
                "pwd":password,
                "ts":ts
            };
            console.log(obj)
            otherjs.ajax({
                url: "/iapro-server/user/login",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(obj),
                dataType: "json",
                success: function(data) {
                    if(data.sucess==1){
                        console.log(data);
                        localStorage.setItem("userinfor",JSON.stringify(data));
                        localStorage.getItem("userinfor");
                        if(data.data.proId==""||data.data.proId==null){
                            window.location.href="../setProduct/html-main.html";
                        }else {
                            window.location.href="../index/html-main.html";
                        }
                    }else if(data.sucess==2){
                        $("#showText").text("");
                        $("#showText").css("display", "block");
                        $("#showText").text("用户名或密码错误");
                    }

                },
                error: function() {
                    window.alert("请求失败");
                }
            })
        }

        //获取机器码密文
        // var MFM = getMFMInput("powerutil", ts ,"EEE", "机器码错误：");
        // if(MFM==null){
        //     return;
        // }

        //将获取到的密文赋值到页面中的form表单
        // console.log(username);
        // console.log(password);
        // console.log(MFM);
        // var logonForm = document.getElementById("logonForm");
        // logonForm.log_account.value = username;
        // logonForm.pwd.value = password;
        // logonForm.MFM.value = MFM;
        //提交
        // logonForm.submit();
    }
    if ($.cookie("rmbUser") == "true") {
        $("#rmbUser").attr("checked", true);
        $("#userName").val($.cookie("userName"));
    }

    function saveUserInfo() {
        if ($("#rmbUser").is(":checked") == true) {
            var userName = $("#userName").val();
            $.cookie("rmbUser", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
            $.cookie("userName", userName, { expires: 7 }); // 存储一个带7天期限的 cookie
        }
        else {
            $.cookie("rmbUser", "false", { expires: -1 });
            $.cookie("userName", '', { expires: -1 });
        }
    }

    otherjs.ajax({
        url: "/iapro-server/dictionary/obtainAll",
        type: 'post',
        contentType: "application/json",
        dataType: "json",
        success: function(data) {
            localStorage.setItem("obtainAll",JSON.stringify(data));
            // localStorage.getItem("obtainAll");
            console.log(data);
        },
        error: function() {
            window.alert("数据请求失败");
        }
    })
})
