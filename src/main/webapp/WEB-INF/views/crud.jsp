<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@taglib prefix="uf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<style >
label{
color:red;
font-family:Times New Roman;
}
</style>
</head>
	<h2><label>USER'S DATABASE</label></h2>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<table class="table table-bordered">
			<th><label>ID</label></th>
			<th><label>First name</label></th>
			<th><label>Last Name</label></th>
			<th><label>User Name</label></th>
			<th><label>Phone Number</label></th>
			<th><label>Email</label></th>
			<th><label>Password</label></th>
			
			
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.fname}</td>
					<td>${user.sname}</td>
					<td>${user.username}</td>
					<td>${user.pnumber}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					
				</tr>
			</c:forEach>
			<div class="container">
		</table>
</body>
</html>