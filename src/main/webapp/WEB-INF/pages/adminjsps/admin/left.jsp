<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>菜单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value='/js/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/css/mymenu.css'/>" type="text/css" media="all">
<script language="javascript">
var bar1 = new Q6MenuBar("bar1", "五金商城")
function load() {
	bar1.colorStyle = 2;
	bar1.config.imgDir = "<c:url value='/images/img/'/>";
	bar1.config.radioButton=false;
	bar1.add("分类管理", "查看分类", "<c:url value='/category/list'/>", "body");
	bar1.add("分类管理", "添加分类", "<c:url value='/category/add'/>", "body");

	bar1.add("商品管理", "查看商品", "<c:url value='/item/list'/>", "body");
	bar1.add("商品管理", "添加商品", "<c:url value='/item/add'/>", "body");

	bar1.add("订单管理", "所有订单", "<c:url value='/order/list?state=0'/>", "body");
	bar1.add("订单管理", "未付款订单", "<c:url value='/order/list?state=1'/>", "body");
	bar1.add("订单管理", "已付款订单", "<c:url value='/order/list?state=2'/>", "body");
	bar1.add("订单管理", "未收货订单", "<c:url value='/order/list?state=3'/>", "body");
	bar1.add("订单管理", "已完成订单", "<c:url value='/order/list?state=4'/>", "body");


	bar1.add("库销管理","查看存销","<c:url value='/stock_sales/list'/>", "body")
	bar1.add("订货人管理","查看订货人","<c:url value='/user/list'/>","body")

	bar1.add("客户单位管理","查看客户单位","<c:url value='/customer/list'/>", "body")


    bar1.add("管理员管理","修改密码","<c:url value='/admin/modpassword?aid=${admin.aid}'/>","body")

	var d = document.getElementById("menu");
	d.innerHTML = bar1.toString();
}
</script>

</head>

<body onload="load()" style="margin: 0px;">
<div id="menu"></div>

</body>
</html>
