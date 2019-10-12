<%@ include file="header.jsp"%>
<html>
<head>

  <script>
    function validatePassword() {
    	
            var password = document.getElementById("Password").value;
            var confirmPassword = document.getElementById("ConfirmPassword").value;
            if (password != confirmPassword) {
            	 document.getElementById('message').innerHTML = 'Enter Confirm Password Same as Password!!!';
            	  $("#buttonActivate").prop("disabled", true);
                return false;
            }
            else
            	{ 
            	$('#message').hide();
            	$("#buttonActivate").prop("disabled", false);
            	return true;
            	}
           
        }
    
    </script> 
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


  <h2>Sign Up</h2>
  
  <sf:form action="getuser" modelAttribute="user" >
  
   <div class="form-group">
      <label for="First Name">First Name:</label>
      <sf:input type="text" style="width:600px;" class="form-control" id="txt" placeholder="Enter First Name" path="fname"/>
      <sf:errors path="fname" cssClass="error"/>
    </div>
    
     <div class="form-group">
      <label for="Sur Name">Last Name:</label>
      <sf:input type="text" style="width:600px;" class="form-control"  id="txt" placeholder="Enter Last Name" path="sname"/>
      <sf:errors path="sname" cssClass="error"/>    
    </div>
    <div class="form-group">
      <label for="User Name">User Name:</label>
      <sf:input type="text" style="width:600px;" class="form-control"  id="txt" placeholder="Enter User Name" path="username"/>
      <sf:errors path="username" cssClass="error"/>    
    </div>
     <div class="form-group">
      <label for="Phone Number">Phone Number:</label>
      <sf:input type="text" style="width:600px;" class="form-control" id="txt" placeholder="Enter Phone Number" path="Pnumber"/>
      <sf:errors path="pnumber" cssClass="error"/>  
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <sf:input type="email" style="width:600px;" class="form-control" id="email" placeholder="Enter email" path="email"/>
      <sf:errors path="email" cssClass="error"/>  
    </div>
     <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" style="width:600px;" class="form-control" id="Password"  placeholder="Enter password" />
      <sf:errors path="password" cssClass="error"/>      
    </div>
     <div class="form-group">
      <label for="pwd">Re-Enter Password:</label>
      <sf:input type="password" oninput="validatePassword()" style="width:600px;" class="form-control" id="ConfirmPassword"  placeholder="Enter Re-Enter Password:" path="password"/>
    <span id="message"></span>
    </div>
    
    
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
   <button type="submit" class="btn btn-primary" id="buttonActivate" value="Submit"  >Continue</button>   
   
  </sf:form>
  </div>

</body>
</html>