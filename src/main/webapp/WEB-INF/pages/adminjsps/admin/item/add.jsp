<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

</style>
  </head>
  
  <body>
    <h1>添加商品</h1>

    <form action="/item/addItem" method="post" enctype="multipart/form-data">

		<label style="width: 60px;height: 25px">商品名称：</label>
		<input style="width: 210px; height: 25px;" type="text" name="iname"/><br/>
		<label style="width: 60px;height: 25px">商品图片：</label>
		<input style="width: 223px; height: 25px;" type="file" name="file"/><br/>
		<label style="width: 60px;height: 25px">普通单价：</label>
		<input style="width: 210px; height: 25px;" type="text" name="price"/><br/>
		<label style="width: 60px;height: 25px">会员单价：</label>
		<input style="width: 210px; height: 25px;" type="text" name="viprice"/><br/>
		<label style="width: 60px;height: 25px">商品库存：</label>
		<input style="width: 210px; height: 25px;" type="text" name="stock" id="stock"/><br/>
		<label style="width: 60px;height: 25px">商品销量：</label>
		<input style="width: 210px; height: 25px;"  type="text" name="sales" id="sales"/><br/>
		<label style="width: 60px;height: 25px">商品详情：</label><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<textarea rows="10" cols="30" name="des" id="des"></textarea><br>
		<label style="width: 60px;height: 25px">商品分类：</label>
		<select style="width: 210px; height: 25px;" name="cid">
		<c:forEach items="${categories}" var="category">
			<option value="${category.cid}">${category.cname}</option>
		</c:forEach>
    	</select>
    	<br/>
    	<input type="submit" style="height: 30px" value="添加商品"/>
    </form>

  </body>
</html>
