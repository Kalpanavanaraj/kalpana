<%@ include file="header.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/show.css">
<script src="${pageContext.request.contextPath}/resources/show.js"></script>
<style>
div.static {
   position: relative;
  left:180px;
    }
    </style>
</head>
<body>
<br><br><br><br><br><br><br><br>
<div class="static">
<div class="container">    
		<div class="row">
			<div class="col-md-8">				
				<div class="panel panel-default  panel--styled">
					<div class="panel-body">
						<div class="col-md-12 panelTop">	
							<div class="col-md-4">	
								<c:url value="/resources/images/${products.id}.jpg" var="url" />
					<img src="${url}" class="img-responsive" width="350" align="middle" height="350">
							</div>
							<div class="col-md-8">	
								<h2>${products.pname}</h2>
								<p>${products.pdesc}</p>
							</div>
						</div>
						
						<div class="col-md-12 panelBottom">
							<div class="col-md-4 text-center">
								<a href= "${pageContext.request.contextPath}/acart/${products.id}"  class="btn btn-lg btn-add-to-cart"><span class="glyphicon glyphicon-shopping-cart"></span>   Add to Cart</a>						
							</div>
							<div class="col-md-4 text-left">
								<h5>Price <span class="itemPrice">&#8377 ${products.pcost}</span></h5>
							</div>
							<div class="col-md-4">
								<div class="stars">
								 <div id="stars" class="starrr"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
    </div>
    </div>
    
    </body>
    </html>