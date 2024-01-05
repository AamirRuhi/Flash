<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table  border="5"bgcolor="cyan">
<tr><td>State Name</td><td>Dist Name</td><td>Name</td><td>Phone</td></tr>
<c:forEach items="${ok}" var="b" >
<tr>
<td><c:out value="${b.stCode}" /></td>
<td><c:out value="${b.distCode}" /></td>
<td><c:out value="${b.name}" /></td>
<td><c:out value="${b.phone}" /></td>
</tr>
</c:forEach>
</table>

</body>
</html>