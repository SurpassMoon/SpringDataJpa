<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:url value="/user/form/1" var="form" />
	<form action="${form}" method="post" onsubmit="return checkFrm(this)">
		<input type="text" name="roles[0].name">
 		<input type="text" name="roles[1].name">
		<input type="text" name="roles[2].name"><br>
		<input type="text" name="num">
		<input type="text" name="num">
		<input type="text" name="num"><br>
		<input type="text" name="params">
		<input type="text" name="params">
		<input type="text" name="params">
		<input type="submit">
	</form>
</body>
</html>