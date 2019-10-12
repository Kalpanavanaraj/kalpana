<%@ include file="header.jsp"%>
<html lang="en">
    <head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<body>
		
<div class="container">
    <div class="row">
   
    	<div class="col-md-12">
    	 <c:forEach items="${view}" var="product">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail" >
					<h1 class="text-center"><span class="label label-info">${product.pname}</span></h1>
					<c:url value="/resources/images/${product.id}.jpg" var="url" />
				<img src="${url}" width="500" align="middle" height="400"
 class="img-responsive">
					<div class="caption">
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<h3>${product.pcategory.cname}</h3>
							</div>
							<div class="col-md-6 col-xs-6 price">
								<h3>
								<label>&#8377 ${product.pcost}</label></h3>
							</div>
						</div>
						<p>${product.pdate}</p>
						<div class="row">
							<div class="col-md-6">
								<a class="btn btn-primary btn-product"><span class="glyphicon glyphicon-thumbs-up"></span> Like</a> 
							</div>
							<div class="col-md-6">
								<a href="show/${product.id}" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a></div>
						</div>

						<p> </p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		
		</div>
		</div>
		
</body>
</html>