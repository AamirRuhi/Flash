<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://localhost:8080/Tiles3springmvc/js/jquery-1.7.2.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getDistList()
{
	var stcode= document.getElementById("stCode").value; 
	  alert("kk "+stcode)
	  $("#d").empty();
	$.ajax({
		url : "http://localhost:8080/Tiles3springmvc/dist.do?stcode="+ stcode,
		type : "GET",
		contentType : "application/json",
		dataType : 'json',
     success : function(data) {
			alert("hi " + data);
			
     for (var i = 0; i < data.length; i++) {
				val = new Option(data[i].distName,
						data[i].distCode);
				$('#d').append(val);
				
			}
		},

		error : function(jqXHR, exception) {
			console.log(exception);
		}
	});	  
}
</script>
</head>
<body>
<f:form action="reg.do" method="get" commandName="r">
<table border="3" bgcolor="cyan" align="center">
<tr><td>State Name</td>
<td><f:select path="stCode" id="stCode" onchange="getDistList();">
<f:option value="0">Select state Name</f:option>
<f:options items="${lst}" itemValue="stCode" itemLabel="stName"/>
</f:select></td>
<td>Dist Name</td><td><f:select path="distCode" id="d">

</f:select></td></tr>

<tr><td>Name </td><td><input type="text" name="name"></td>
<td>Phone </td><td><input type="text" name="phone"></td></tr>
<tr><td><input type="submit" value="REGIST"></td></tr>
</table>
</f:form>
</body>
</html>