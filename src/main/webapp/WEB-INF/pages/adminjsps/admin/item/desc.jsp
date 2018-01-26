<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'bookdesc.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <%--<link href="/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/font-awesome.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/lib/respond.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css"/>
    <script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js"></script>

    <script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
    <script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script>
    <script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>

    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        body {
            font-size: 11pt;

        }

        #imgv {
            margin: 20px;
            border: solid 2px gray;
            width: 160px;
            height: 190px;
            text-align: center;
        }

        #img {
            width: 160px;
            height: 190px;
        }
    </style>
</head>

<body>
<div id="imgv">
    <img id="img" src="<c:url value='${item.image}'/>" border="0"/>
</div>
<form  id="form" action="" method="post">
    <label style="width: 60px;height: 25px">商品名称：</label>
    <input style="width: 210px; height: 25px;" type="text" name="iname" id="iname" value="${item.iname}"/><br/>
    <%--<label style="width: 60px;height: 25px">商品图片：</label>--%>
    <%--<input style="width: 223px; height: 25px;" type="file" name="file" id="file" value="${item.image}"/><br/>--%>
    <label style="width: 60px;height: 25px">普通单价：</label>
    <input style="width: 210px; height: 25px;" type="text" name="price" id="price" value="${item.price}"/><br/>
    <label style="width: 60px;height: 25px">会员单价：</label>
    <input style="width: 210px; height: 25px;" type="text" name="viprice" id="viprice" value="${item.viprice}"/><br/>
    <label style="width: 60px;height: 25px">商品库存：</label>
    <input style="width: 210px; height: 25px;" type="text" name="stock" id="stock" value="${item.stock}"/><br/>
    <label style="width: 60px;height: 25px">商品销量：</label>
    <input style="width: 210px; height: 25px;" type="text" name="sales" id="sales" value="${item.sales}"/><br/>
    <label style="width: 60px;height: 25px">商品详情：</label><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <textarea rows="10" cols="30" name="des" id="des">${item.des}</textarea><br>
    <label style="width: 60px;height: 25px">商品分类：</label>
    <select style="width: 210px; height: 25px;" name="cid" >
        <c:forEach items="${categories}" var="category">
            <option value="${category.cid}"
                    <c:if test="${item.cname == category.cname}">selected="selected"</c:if>>${category.cname}</option>
        </c:forEach>
    </select><br/><br>

    <input type="button" style="width: 50px;height: 25px" name="method" value="删除" onclick="delItem();"/>
    <input type="button" style="width: 50px;height: 25px" name="method" value="修改" onclick="modItem()"/>
</form>


<script type="text/javascript">
    function delItem() {
        layer.confirm('确定要删除吗?', function (index) {
            $.ajax({
                url: "/item/delItem",
                data: {
                    iid: "${item.iid}"
                }, success: function (result) {
                    if (result.count > 0) {
                        layer.confirm('删除成功！', function (index) {
                            location.href = "/item/list";
                        })
                    }
                }
            })
        })
    }
    function modItem() {
        $.ajax({
            url: "/item/modItem",
            data: {
                iid: "${item.iid}",
                iname: $("#iname").val(),
                price: $("#price").val(),
                viprice: $("#viprice").val(),
                stock: $("#stock").val(),
                sales: $("#sales").val(),
                cid: $("option:selected").val(),
                des: $("#des").val()
            },
            success: function (result) {
                if (result.count > 0) {
                    layer.confirm('修改成功！', function (index) {
                        location.href = "/item/list";
                    })
                }
            }
        })
    }
</script>
</body>
</html>
