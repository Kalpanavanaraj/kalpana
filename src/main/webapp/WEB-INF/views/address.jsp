<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<body background="resources/images/lens8.jpg">
<div class="container">
<style>

h2   {color: black;font-size: 50}
label
{
font-size: 32;
font-family:Times New Roman;
color:Green;
}
</style>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


  <h2>User Address Information</h2>
  
  <sf:form action="${context}/usadd/${user.id}" modelAttribute="address">
  
   <div class="form-group">
      <label for="Door Number">Door Number:</label>
      <sf:input type="text" style="width:600px;" class="form-control" id="txt" placeholder="Enter your Door Number" path="dnumber"/>
      <sf:errors path="dnumber" cssClass="error"/>
    </div>
    
     <div class="form-group">
      <label for="Street Number">Street Name:</label>
      <sf:input type="text" style="width:600px;" class="form-control"  id="txt" placeholder="Enter Your Street Number" path="stname"/>
      <sf:errors path="stname" cssClass="error"/>
    </div>
     <div class="form-group">
      <label for="Area">Area:</label>
      <sf:input type="text" style="width:600px;" class="form-control" id="txt" placeholder="Enter Your Area" path="area"/>
      <sf:errors path="area" cssClass="error"/>
    </div>
    <div class="form-group">
      <label for="City">City:</label>
      <sf:input type="text" style="width:600px;" class="form-control" id="text" placeholder="Enter Your City" path="city"/>
      <sf:errors path="city" cssClass="error"/>   
    </div>
     <div class="form-group">
      <label for="Pincode">Pincode:</label>
      <sf:input type="text" style="width:600px;" class="form-control" id="pwd" placeholder="Enter Your Pincode" path="pincode"/>
      <sf:errors path="pincode" cssClass="error"/>
    </div>
    <button type="submit" class="btn btn-primary" name="action" value="Submit">Submit</button> 
    <button type="submit" class="btn btn-primary" name="action" value="Add Another Address">Add Another Address</button>
      
    </sf:form>
  </div>

</body>
</html> 


