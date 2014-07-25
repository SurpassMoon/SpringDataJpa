<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({ url: "user/jqueryAjax", context: document.body, success: function(data){
	        alert(data);
	      }}); 
	});
</script>
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