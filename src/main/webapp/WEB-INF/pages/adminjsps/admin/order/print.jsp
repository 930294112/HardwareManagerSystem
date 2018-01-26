<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>订单列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <link href="/css/font-awesome.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        * {
            font-size: 13pt;
        }


    </style>
    <style type="text/css" media="print">
        .noprint{
            display: none;
        }

    </style>
</head>

<body>
<div>
    <input id="btnPrint" type="button" value="打印订单" class="noprint" onclick="javascript:window.print(); "
           style="color:#00f; font-weight:bold;text-decoration:none;cursor:pointer!important; cursor:hand"/><br>
    订货人姓名：${order.user.realname}<br>
    订货人电话：${order.user.tel}<br>
    订货人留言:${order.context}<br>
    客户单位名称：${order.customer.cuname}
    <table border="1" width="100%" cellspacing="0" background="black">
        <tr >
            <td colspan="6">
                订单编号：${order.oid}&nbsp;&nbsp;&nbsp;&nbsp;
                下单时间：${order.ordertime}&nbsp;&nbsp;&nbsp;&nbsp;
                总金额：<font color="red"><b>${order.subtotal}&yen;&nbsp;&nbsp;&nbsp;&nbsp;</b></font>

            </td>
        </tr>

        <tr align="center">
            <td>商品名称</td>
            <td>商品类型</td>
            <td>商品单价</td>
            <td>商品数量</td>
            <td>商品小计</td>
            <td></td>
        </tr>
        <c:forEach items="${order.orderItemList}" var="oderItem">
            <tr align="center">
                <td>${oderItem.item.iname}</td>
                <td>${oderItem.item.category.cname}</td>
                <td>${oderItem.item.price}</td>
                <td>${oderItem.count}</td>
                <td>${oderItem.total}</td>
                <td><span class="fa fa-square-o" aria-hidden="true" style="font-style: italic;"></span></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
