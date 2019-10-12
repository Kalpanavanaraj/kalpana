<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>creation of webpage</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

<!-- Latest compiled JavaScript -->
<script src="resources/bootstrap/jquery.min.js"></script>

<!-- jQuery library -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>


</head>
<body background="resources/images/lens5.jpg">
<marquee>
	<h1>
		<center>
		<img src="resources/images/12.jpg"  style="width:100px;height:90px;">
		
			<font size="32" color="white">LENSMAKER</font>
		</center>
	</h1>
	</marquee>
	<%@ include file="header.jsp"%>	
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
<div class="carousel-inner">

      <div class="item active">
        <img src="resources/images/lens2.jpg" alt="Los Angeles" style="width:100%;height:80%">
        <div class="carousel-caption">
          <h3><font size="10">Stylish look</font></h3>
          <p><font size="3">I get to see life through rose-colored glasses a lot of the time</font></p>
        </div>
      </div>
   

      <div class="item">
        <img src="resources/images/lens6.jpg" alt="Chicago" style="width:100%;height:100%">
        <div class="carousel-caption">
          <h3><font size="10">Casual Look</font> </h3>
          <p><font size="3">I think sometimes when you want attention, you can wear sunglasses, and people are like, 'Who is that?'</font></p>
        </div>
      </div>
    
      
      <div class="item">
        <img src="resources/images/lens3.jpg" alt="New York" style="width:100%;height:100%">
        <div class="carousel-caption">
          <h3><font size="10">Trendy look</font></h3>
          <p><font size="3">A pair of powerful spectacles has sometimes sufficed to cure a person in love.</font></p>
        </div>
      </div>
      <div class="item">
        <img src="resources/images/lens1.jpg" alt="New York" style="width:100%;">
        <div class="carousel-caption">
          <h3><font size="10">Contact Lens</font></h3>
          <p><font size="3">I look at all good things with a bit of a dark lens, I suppose, especially with something like love.</font></p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>


	
</body>
</html>