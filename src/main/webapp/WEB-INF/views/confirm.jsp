<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/conf.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
optgroup { font-size:14px; }
</style>
</head>
<body>
<div class="row">
<div class="col-sm-6">
<div class="panel panel-primary">
<div class="panel-heading">
<h4>Personal Details</h4>
</div>
<div class="panel-body">
<div class="text-center">

<h2>Customer Name : ${user.fname} ${user.sname}</h2>
<h3>User Name     : ${user.username}</h3>
<h3>Email Id      : ${user.email}</h3>
<h3>Phone Number  : ${user.pnumber}</h3>
<h3>Role          : ${user.role}</h3>

</div>



</div>

</div>
</div>



<div class="col-sm-6">
<div class="panel panel-primary">
<div class="panel-heading">
<h4>Billing Address</h4>
</div>
<div class="panel-body">
<div class="text-center">

<div class="form-group">
  <label for="sel1">Select The Address:</label>
  <select  class="form-control input-md" size="3" >
				
				<c:forEach items="${user.addresses}" var="ur">
                <option>				 
				 Door Number : ${ur.dnumber},Street Name : ${ur.stname},Area :${ur.area} ,City :${ur.city}, Pincode :${ur.pincode}
				</option>
                </c:forEach>
                
				
				<select>
				
</div>




</div>
</div>
<div class="panel-footer">
<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
</div>
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4 col-sm-offset-4">
<div class="text-center">
<a href="${flowExecutionUrl}&_eventId_edit" class="btn btn-primary"  data-toggle="modal" data-target="#myModal">Confirm</a>
</div>

</div>

</div>





<div class="modal fade success-popup" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document">
  
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
        <h4 class="modal-title" id="myModalLabel">Thank You !</h4>
      </div>
      <div class="modal-body text-center">
         <img src="resources/images/sy.jpg" class="img-responsive">
          <p class="lead">Your Product has been registered successfully and Your product will be shipped with in 24 hours!</p>
          <a href="home" class="rd_more btn btn-default">Go to Home</a>
      </div>
      </div>
    </div>
  </div>




</body>
</html>