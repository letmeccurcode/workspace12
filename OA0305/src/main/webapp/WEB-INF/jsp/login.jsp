<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>协同办公平台</title>
    <jsp:include page="path.jsp"></jsp:include>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="media/layui/css/layui.css"
          media="all">
    <link rel="stylesheet" type="text/css" href="media/css/login.css"
          media="all">
    <link rel="stylesheet" type="text/css" href="media/css/verify.css">
    <script type="text/javascript" src="media/js/jquery.min.js"></script>

    <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>

</head>
<body class="layui-bg-black">
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
    <form action="emp_login" method="post">
        <h1>
            <strong>协同办公平台</strong> <em>Tick-tock Office System</em>
        </h1>
        <div class="layui-user-icon larry-login">
            <input type="text" placeholder="账号" class="login_txtbx" id="noid" name="no"/>
        </div>
        <div class="layui-pwd-icon larry-login">
            <input type="password" placeholder="密码" name="pass" id="passid" class="login_txtbx"/>
        </div>
        <input type="hidden" name="ip" id="ip1"> <input type="hidden"
                                                        name="city" id="cy1">
        <div class="feri-code">
            <div id="mpanel4"></div>
        </div>
        <div class="layui-submit larry-login">
            <input type="button" onclick="empLogin();" id="btn1" disabled="disabled" value="立即登陆"
                   class="submit_btn"/>
        </div>
    </form>
    <div class="layui-login-text">
        <p>© 2016-2018 北京协同科技有限公司 版权所有</p>
    </div>
</div>
<script type="text/javascript" src="media/js/login.js"></script>
<script type="application/javascript" src="media/js/verify.min.js"></script>
<script type="text/javascript">
    $(function () {
        //滑动验证码
        $('#mpanel4').pointsVerify({
            defaultNum: 3, //默认的文字数量
            checkNum: 1, //校对的文字数量
            vSpace: 5, //间隔
            imgName: ['1.jpg', '2.jpg'],
            imgSize: {
                width: '400px',
                height: '200px',
            },
            barSize: {
                width: '400px',
                height: '40px',
            },
            ready: function () {
            },
            success: function () {
                //......后续操作
                $("#btn1").attr("disabled", false);
            },
            error: function () {
            }
        });
    });
</script>

<script>

    var ip = "";
    var city = "";
    /*$()页面加载完毕之后自动执行匿名函数*/
    $(function () {
        ip = returnCitySN["cip"];//获取IP
        $.ajax({
            url: 'http://api.map.baidu.com/location/ip?ak=ia6HfFL660Bvh43exmH9LrI6',
            type: 'POST',
            dataType: 'jsonp',
            success: function (data) {
                city = data.content.address_detail.province + "," + data.content.address_detail.city;//获取城市
            }
        });
    })

    function empLogin() {
        var no = $("#noid").val();
        var pass = $("#passid").val();
        console.log(no);
        console.log(pass);
        $.ajax({
            url: "emp_login",
            data: {"no": no, "pass": pass, "ip": ip, "city": city},
            type: "POST",
            dataType: "json",
            success: function (result) {
                if (result.status == 200) {
                    location.href = "${basePath}page_index";//跳转首页
                } else {
                    alert(result.message); //失败的提示信息
                    window.location.reload();//刷新
                }
            }
        })
    }

</script>

</body>
</html>