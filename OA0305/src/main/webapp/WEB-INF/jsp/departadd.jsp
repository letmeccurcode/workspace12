<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>滴答办公系统-部门新增</title>
    <jsp:include page="path.jsp"></jsp:include>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="media/layui/css/layui.css" media="all">
    <script src="media/layui/layui.js"></script>
    <script src="media/js/jquery.min.js"></script>
</head>
<body>

<div class="layui-container" style="margin-top: 5px">
    <form class="layui-form" action="#" method="post" id="fm">

        <div class="layui-form-item">
            <label class="layui-form-label">部门名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="name" autocomplete="off"
                       placeholder="请输入部门名称" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">创立日期</label>
            <div class="layui-input-block">
                <input type="text" name="createtime" placeholder="请输入创立日期" id="date" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <input class="layui-btn" style="margin-left: 10%" type="button" onclick="addDept();" value="确认新增">
        </div>
    </form>
</div>


<script>

    function addDept() {
        var fm = $("#fm").serialize();
        $.ajax({
            url: "addDepartAjax",
            data: fm,
            type: "POST",
            dataType: "JSON",
            success: function (res) {
                if (res.status == 2) {
                    alert(res.msg);
                    //查询所有部门列表
                } else {
                    alert(res.msg);
                }
            }
        })
    }


</script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(
        ['form', 'laydate'],
        function () {
            var form = layui.form, layer = layui.layer, laydate = layui.laydate;

            //日期
            laydate.render({
                elem: '#date'
            });


            //自定义验证规则
            form.verify({
                title: function (value) {
                    if (value.length < 5) {
                        return '标题至少得5个字符啊';
                    }
                },
                pass: [/(.+){6,12}$/, '密码必须6到12位'],
                content: function (value) {
                    layedit.sync(editIndex);
                }
            });
        });
</script>
</body>
</html>