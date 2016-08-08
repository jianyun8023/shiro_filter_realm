<%--
  Created by IntelliJ IDEA.
  User: z9475
  Date: 2016/8/7
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addmin登陆</title>
</head>
<body>
<form method="post">
    <label>${message}</label><br>
    <label>用户名：</label><input type="text" placeholder="请输入用户名" name="username"><br>
    <label>密码：</label><input type="password" placeholder="请输入密码" name="password"><br>
    <label><input type="checkbox" name="rememberMe">记住登陆</label><br>
    <input type="submit" value="登陆">
</form>
</body>
</html>
