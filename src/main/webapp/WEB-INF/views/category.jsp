<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="pf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<body>
<pf:form class="form-horizontal" action="${context}/getcategory" modelAttribute="category" >



<fieldset>

<!-- Form Name -->
<legend>CATEGORY INFORMATION</legend>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name">CATEGORY NAME</label>  
  <div class="col-md-4">
  <pf:hidden path="id"/>
  <pf:input id="product_name" path="cname" placeholder="CATEGORY NAME" class="form-control input-md" required="" type="text"/>
   
  </div>
</div>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">ADD PRODUCT</label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">ADD</button>
  </div>
  </div>

</fieldset>
</pf:form>
<div class="container">
<table class="table table-bordered">
            <th>c_id</th>
			<th>C_name</th>
			<th>Edit</th>
			<th>Delete</th>
			<c:forEach items="${cat}" var="c">
			<tr>
			<td>${c.id}</td>
		    <td>${c.cname}</td>
	        <td><a href="${context}/editcategory/${c.id}"> <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Edit</button>
  </div></a></td>
					<td><a href="deletecategory/${c.id}"> <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Delete</button>
  </div></a></td>
  </tr>
			</c:forEach>
			</table>
</body>
</html>