<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<tiles:insertAttribute name="Welcome" ignore="true"></tiles:insertAttribute> </title>
</head>

<body style="margin: 0px;">
<table width="100%" height="100%" cellspacing="5">
<tr>
<td colspan="2" height="10%" bgcolor="red">
 <tiles:insertAttribute name="modih"/>
</tr>

<tr>
<td bgcolor="lightblue" width="10%" height="80%">
<tiles:insertAttribute name="modim"/> </td>
<td bgcolor="gray"><tiles:insertAttribute name="modib"/> </td>
</tr>
<tr>
<td colspan="2" bgcolor="red">
<tiles:insertAttribute name="modif"/> </td>
</tr>
</table>
</body>
</html>