<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/8
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台登录</title>

    <script src="/js/jquery-3.2.1.js"></script>
    <style>
        div{
            margin: auto;
            text-align: center;
            width: 100%;
            height: 100%;
            border: 1px solid black;
            background-image: url("<c:url value='/images/img/login.jpg'/>");
            background-repeat: no-repeat;
            background-size: cover;
        }
        #form{
            font-size: 24px;
            margin-top: 3%;
        }
        h1{
            margin-top: 10%;
        }
        .i1{
            font-size: 18px;
        }
        #i2{
            width: 90px;
            height: 43px;
            border-radius: 20%;

        }

    </style>
</head>
<body>
<div>
    <h1>管理员登录</h1>

    <p style="font-weight: 900; color: red">${message}</p>
    <form id="form" action="/admin/loginSubmit">
        <input type="hidden" name="method" value="login">
        管理员账户：<input class="i1" type="text" name="aname" value=""  placeholder="请输入用户名"/><br/><br>
        密　　　码：<input  class="i1" type="password" name="apwd" placeholder="请输入密码"/><br/><br>
        <input id="i2" type="submit"  value="进入后台"/>
    </form>
</div>


</body>
</html>
