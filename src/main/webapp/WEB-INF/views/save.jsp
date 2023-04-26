<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-04-25
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save.jsp</title>
</head>
<body>
<h2>save.jsp</h2>
<form action="save" method ="post">
    <input type="text" name="bookName" placeholder="제목"><br>
    <input type="text" name="bookPublisher" placeholder="출판사"><br>
    <input type="text" name="bookAuthor" placeholder="저자"><<br>
    <input type="text" name="bookPrice" placeholder="정가"><br>
    <input type="submit" value="등록">
</form>
</body>
</html>
