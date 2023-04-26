<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-04-26
  Time: 오전 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>update.jsp</h2>
  <form action="/update" method ="post">
    <input type="text" name="id" value="${book.id}" readonly><br>
    <%-- value에 저렇게 쓰면 기존 값을 미리 채워넣을 수 있다.
     readonly : 보여주긴 하되, 수정은 안된다.
     input type ="hidden" 사용자에게 보여지진 않음.--%>
    <input type="text" name="bookName" value="${book.bookName}"><br>
    <input type="text" name="bookPublisher" value="${book.bookPublisher}"><br>
    <input type="text" name="bookAuthor" value="${book.bookAuthor}"><<br>
    <input type="text" name="bookPrice" value="${book.bookPrice}"><br>
    <input type="submit" value="수정">
  </form>

</body>
</html>
