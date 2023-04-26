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
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <script src = "/resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h2>detail.jsp</h2>
<table class = "table table-dark table-hover">
    <tr>
        <th>${book.id}</th>
        <td>${book.bookName}</td>
        <td>${book.bookPublisher}</td>
        <td>${book.bookAuthor}</td>
        <td>${book.bookPrice}</td>
    </tr>
<%--    id: ${book.id}<br> 이하 교수님 풀이 --%>
<%--    name: ${book.bookName}<br>--%>
<%--    publisher: ${book.bookPublisher}<br>--%>
<%--    author: ${book.bookAuthor}<br>--%>
<%--    price: ${book.bookPrice}<br>--%>
</table>
</body>
</html>
