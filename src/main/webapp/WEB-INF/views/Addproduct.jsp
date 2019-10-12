<%@ taglib prefix="pf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ include file="header.jsp"%>
</head>
<body>

	<pf:form class="form-horizontal" action="${context}/getproduct"
		modelAttribute="product" enctype="multipart/form-data" >

		<fieldset>
			<!-- Form Name -->
			<legend>PRODUCTS INFORMATION</legend>


			<pf:hidden path="id" />
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_name">PRODUCT
					NAME</label>
				<div class="col-md-4">
					<pf:input id="product_name" path="pname" placeholder="PRODUCT NAME"
						class="form-control input-md" required="" type="text" />
						<pf:errors path="pname" style="color:red;"></pf:errors>
				
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_name_fr">PRODUCT
					DESCRIPTION FR</label>
				<div class="col-md-4">
					<pf:input id="product_name_fr" path="pdesc"
						placeholder="PRODUCT DESCRIPTION FR" class="form-control input-md"
						required="" type="text" />
					<pf:errors path="pdesc" style="color:red;"></pf:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="available_quantity">SELECT
					THE LIST OF CATEGORIES</label>
					<div class="col-md-4">
				<pf:select path="pcategory.id" class="form-control input-md">
				<pf:options items="${categories}" itemLabel="cname" itemValue="id"/>
				</pf:select>
					
				</div>
			</div>
<div class="form-group">
				<label class="col-md-4 control-label" for="available_quantity">SELECT
					THE OPTION</label>
					<div class="col-md-4">
				 <pf:select class="form-control" path="field" id="sel1">
    <option>men</option>
    <option>women</option>
  <option>kids</option>
    
  </pf:select>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="available_quantity">AVAILABLE
					QUANTITY</label>
				<div class="col-md-4">
					<pf:input id="available_quantity" path="pquantity"
						placeholder="AVAILABLE QUANTITY" class="form-control input-md"
						required="" type="text" />
						<pf:errors path="pquantity" style="color:red;"></pf:errors>
					
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_weight">PRODUCT
					COST</label>
				<div class="col-md-4">
					<pf:input id="product_weight" path="pcost"
						placeholder="PRODUCT COST" class="form-control input-md"
						required="" type="text" />
						<pf:errors path="pcost" style="color:red;"></pf:errors>
								</div>
			</div>



			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="percentage_discount">PERCENTAGE
					DISCOUNT</label>
				<div class="col-md-4">
					<pf:input id="percentage_discount" path="pdiscount"
						placeholder="PERCENTAGE DISCOUNT" class="form-control input-md"
						required="" type="text" />
					
				</div>
			</div>
				<!-- Text input-->
 		<div class="form-group">
				<label class="col-md-4 control-label" for="file">Select An
					Image</label>
				<div class="col-md-4">
					<pf:input id="online_date" path="file"
						class="form-control input-md" required="" type="file" />

				</div>
			</div> 
			

			
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton">REGISTER
					PRODUCT</label>
				<div class="col-md-4">
					<input type="submit" class="btn btn-primary" value="Submit">
				</div>
			</div>
		</fieldset>
	</pf:form>
	
	
	<div class="container">
		<table class="table table-bordered">

			<thead>
				<tr>
					<th>p_image</th>
					<th>p_id</th>
					<th>P_name</th>
					<th>p_description</th>
					<th>p_category</th>
					<th>Unisex</th>
					<th>A_quantity</th>
					<th>p_cost</th>
					<th>p_discount</th>
					<th>online_date</th>

					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>

			<c:forEach items="${products}" var="product">
				<tr>
					<c:url value="/resources/images/${product.id}.jpg" var="url" />
					<td><img src="${url}" width="150" align="middle" height="150">
					</td>
					<td>${product.id}</td>

					<td>${product.pname}</td>
					<td>${product.pdesc}</td>
					<td>${product.pcategory.cname}</td>
					<td>${product.field}</td>
					<td>${product.pquantity}</td>
					<td>${product.pcost}</td>
					<td>${product.pdiscount}</td>
					<td>${product.pdate}</td>
					<td><a href="${context}/editproduct/${product.id}"
						class="btn btn-primary"> Edit </a></td>
					<td><a href="deleteproduct/${product.id}"
						class="btn btn-primary"> Delete </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>