<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link href="/css/bootstrap.min.css" rel="stylesheet">
      <link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
      <link href="/css/font-awesome.css" rel="stylesheet">
      <script type="text/javascript" src="/lib/respond.min.js"></script>
      <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css"/>
      <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css"/>
      <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css"/>
      <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin"/>
      <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css"/>
      <script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js"></script>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

</style>
  </head>
  
  <body>
    <h1>添加分类</h1>
    <p style="font-weight: 900; color: red">${msg }</p>
    <form action="" method="post">
    	分类名称：<input type="text" name="cname" id="cname"/>
    	<input type="button" onclick="addCategory()" value="添加分类"/>
    </form>

    <script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
    <script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script>

    <script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>


  <script type="text/javascript">
      function addCategory() {
          $.ajax({
              url:"/category/addCategory",
              data:{
                  cname:$("#cname").val()
              },success:function (result) {
                  if (result.count > 0){
                      layer.confirm('添加成功！',function (index) {
                          location.href="/category/list"
                      })
                  }else {
                      layer.msg("该分类名称已经存在!请重新输入!");
                  }
              }
          })
      }
  </script>
  </body>
</html>
