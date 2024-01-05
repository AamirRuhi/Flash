<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="right" bgcolor="red"><a href=logout.do?uid=<%=(String)session.getAttribute("uid") %>><%=(String)session.getAttribute("uid") %></a></h1>
</body>
</html>