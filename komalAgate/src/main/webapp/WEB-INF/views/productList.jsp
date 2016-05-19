<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Products</h1>
			<p class="lead">Check out all the products here !</p>
		</div>

		<table class="table table-striped table-hover">
			<thead class="bg-success">
				<tr class="bg-success">
					<th>Photo Thumb</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Category</th>
					<th>View Product</th>
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
					<!-- <span class="glyphicon glyphicon-info-sign"></span></td> -->
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<!-- /.container -->

<%@include file="/WEB-INF/views/templates/footer.jsp"%>
