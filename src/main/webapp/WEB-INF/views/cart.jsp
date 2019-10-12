<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/car.css">
	


</head>
<body>
	<div class="container">
	<c:choose>
	<c:when test="${not empty cart}">
	<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Product</th>
					<th style="width: 10%">Price</th>
					<th style="width: 8%">Quantity</th>
					<th style="width: 22%" class="text-center">Subtotal</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cart.cartitem}" var="ci">
					<tr>
						<td data-th="Product">
							<div class="row">
								<c:url value="/resources/images/${ci.product.id}.jpg" var="url" />
								<div class="col-sm-4 hidden-xs">
									<img src="${url}" width="150" align="middle" height="150" class="img-responsive"/></div>
									<div class="col-sm-8">
										<h4 class="nomargin">Brand Name-${ci.product.pname}</h4>
										<p>Product-${ci.product.pcategory.cname}</p>
										<p>Description-${ci.product.pdesc}</p>
									</div>
								</div>
						</td>
						<td data-th="Price">&#8377; ${ci.product.pcost}</td>
						<td data-th="Quantity"><input type="number"
							id="count_${ci.cartitemid}" min="1" max="3"
							class="form-control text-center" value="${ci.subQty}" /></td>
						<td data-th="Subtotal" class="text-center">&#8377;
							${ci.subTotalCost}</td>
						<td class="actions" data-th="">
							<button type="button"  name="refresh" value="${ci.cartitemid}"
								class="btn btn-info btn-sm">
								<span class="glyphicon glyphicon-refresh"></span>
							</button>
							<a href="${context}/deleteitem/${ci.cartitemid}" class="btn btn-danger btn-sm">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>



				</c:forEach>

			</tbody>
			<tfoot>
				<tr class="visible-xs">
					<td class="text-center"><strong>Total &#8377;
							${cart.grandTotal}</strong></td>
				</tr>
				<tr>
					<td><a href="#" class="btn btn-warning"><span
							class="glyphicon glyphicon-chevron-left"></span> Continue
							Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td>
					<td class="hidden-xs text-center"><strong>Total
							&#8377; ${cart.grandTotal}</strong></td>
					<td><a href="${context}/memberShip" class="btn btn-success btn-block">Checkout
							<span class="glyphicon glyphicon-chevron-right"></span>
					</a></td>
				</tr>
			</tfoot>
		</table>
	
	
	
	</c:when>
	<c:otherwise>
	<div class="jumbotron">
	<div class="text-center"> 
	
	<h1>your cart is empty!!!</h1>
	</div>
	</div>
	
	</c:otherwise>
	</c:choose>
			</div>

	<script>
	$(document).ready(function(){
		$('button[name="refresh"]').click(function(){
		var cartlineid=$(this).attr('value');
		var countelement=$('#count_' + cartlineid);
		var originalcount=countelement.attr('value');
		var currentcount=countelement.val();

			
			
				console.log('Posting to : http://localhost:6060/lens');
				var updateurl='http://localhost:6060/lens' +'/'+ cartlineid +'/update?count='+currentcount;
				window.location.href=updateurl;
			
		}
		);
			});
</script>

</body>
</html>