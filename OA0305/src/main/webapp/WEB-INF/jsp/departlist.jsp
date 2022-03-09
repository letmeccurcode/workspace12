<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>滴答办公系统-部门列表</title>
    <jsp:include page="path.jsp"></jsp:include>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="media/layui/css/layui.css" media="all">
    <script src="media/js/jquery.min.js"></script>
</head>
<body>
<div class="layui-container">
    <table class="layui-table" id="tbdata" lay-filter="tbop">
        <thead>
        <tr>
            <td>序号</td>
            <td>部门名称</td>
            <td>部门人数</td>
            <td>成立日期</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${pb.records}" var="d">
            <tr>
                <td>${d.id}</td>
                <td>${d.name}</td>
                <td>0</td>
                <td>${d.createtime}</td>
                <td><a class="layui-btn layui-btn-mini" href="departupdate.html">编辑</a>
                    <a class="layui-btn layui-btn-danger layui-btn-mini"
                       lay-event="del" onclick="deleteDepart(${d.id});">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-1">

        <a href="queryDeptsByPage/1/${pb.pageSize}" class="layui-laypage-prev" data-page="0">
            <i class="layui-icon">首页</i>
        </a>
        <c:if test="${pb.pageNo>1}">
            <a href="queryDeptsByPage/${pb.pageNo-1}/${pb.pageSize}" class="layui-laypage-prev" data-page="0">
                <i class="layui-icon">上页</i>
            </a>
        </c:if>

        <c:forEach begin="${pb.startno}" end="${pb.endno}" step="1" var="no">
            <c:if test="${pb.pageNo == no}">
                <span style="color:red;font-weight: bold;">${no}</span>
            </c:if>
            <c:if test="${pb.pageNo != no}">
                <a href="queryDeptsByPage/${no}/${pb.pageSize}">${no}</a>
            </c:if>
        </c:forEach>

        <c:if test="${pb.pageNo < pb.totalPages}">
            <a href="queryDeptsByPage/${pb.pageNo+1}/${pb.pageSize}" class="layui-laypage-next" data-page="2">
                <i class="layui-icon">下页</i>
            </a>
        </c:if>

        <a href="queryDeptsByPage/${pb.totalPages}/${pb.pageSize}" class="layui-laypage-next" data-page="2">
            <i class="layui-icon">尾页</i>
        </a>
        <span class="layui-laypage-skip">到第
           <input type="number" min="1" max="${pb.totalPages}"
                  onblur="checkNO(this.value,${pb.totalPages},${pb.pageSize});" value="1" class="layui-input">页
            <button type="button" class="layui-laypage-btn">确定</button>
        </span>
        <%--第几页/共几页--%>
        <span class="layui-laypage-count">共${pb.totalCount}条</span><span
            class="layui-laypage-count">第${pb.pageNo}页/共${pb.totalPages}页</span>
        <span class="layui-laypage-limits">
        <select lay-ignore="" onchange="changePage(this.value);">
                <option value="5" ${pb.pageSize==5?"selected":""}>5 条/页</option>
                <option value="10" ${pb.pageSize==10?"selected":""}>10 条/页</option>
                <option value="15" ${pb.pageSize==15?"selected":""}>15 条/页</option>
                <option value="30" ${pb.pageSize==30?"selected":""}>30 条/页</option>
        </select>
        </span>
    </div>
</div>
<script src="media/layui/layui.js"></script>

<script type="text/javascript">

    function checkNO(no, tp, ps) {
        if (no < 1 || no > tp) {
            alert("页码超出有效范围!");
            location.href = "queryDeptsByPage/1/" + ps;
        } else {
            location.href = "queryDeptsByPage/" + no + "/" + ps;
        }
    }

    function changePage(num) {
        location.href = "queryDeptsByPage/1/" + num;
    }

    function deleteDepart(id) {
        layui.use('table', function () {
            layer.confirm('是否确认删除部门?', function (index) {
                $.getJSON("deaprt_delete", {"id": id}, function (result) {
                    if (result.code = 200) {
                        layer.msg("删除成功", {icon: 6}, function () {
                            window.location.reload();//刷新
                        });
                    } else {
                        layer.msg("删除失败", {icon: 5});
                    }
                });
            });
        });
    }
</script>


</body>
</html>