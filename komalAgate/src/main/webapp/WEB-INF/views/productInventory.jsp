<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Inventory</h1>
			<p class="lead">View, check and update all the products here !</p>
		</div>

		<table class="table table-striped table-hover">
			<thead class="bg-success">
				<tr class="bg-success">
					<th>Photo Thumb</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Category</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>

					<td><img src='<c:url value="/images/${product.id }.png"/>' style="width:100%; height: 100px;" /></td>
					<td>${product.productName }</td>
					<td>${product.productPrice }</td>
					<td>${product.productCategory }</td>
					<td>
						<a href='<spring:url value="/products/viewProduct/${product.id}" />' >
							<span class="glyphicon glyphicon-info-sign" ></span>
						</a>
					 	<!-- Shweta starts-->
					 	<a href='<spring:url value="/admin/deleteProduct/${product.id}" />'>
					 	<span class="glyphicon glyphicon-remove"></span>
					 	</a>
					 	<!-- Shweta ends *below span class is yours* -->
					 	<!-- <span class="glyphicon glyphicon-remove"></span> -->
					 	<!--  shweta adding code for update starts -->
					 	<a href='<spring:url value="/admin/updateProduct/${product.id}" />'>
					 	<span class="glyphicon glyphicon-pencil"></span>
					 	</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<spring:url value="/admin/productInventory/addProduct" />" 
			class="btn btn-primary btn-sm">Add Product</a>
	</div>
</div>
<!-- /.container -->

<%@include file="/WEB-INF/views/templates/footer.jsp"%>
