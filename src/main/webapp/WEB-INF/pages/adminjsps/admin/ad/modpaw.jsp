<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/19
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改登录密码</title>
</head>
<body>
<div>
    <h1>修改密码</h1>
    <p style="font-weight: 900; color: red">${message}</p>
    <form id="form" action="/admin/savepwd">
        <label>请输入原密码：</label>
        <input type="text" name="apwd" value=""><br>
        <label>请输入新密码：</label>
        <input type="text" name="newpwd" value=""><br>
        <label>请确认新密码：</label>
        <input type="text" name="repwd" value=""><br>
        <input type="submit" value="确认修改"/>
    </form>
</div>

</body>
</html>
