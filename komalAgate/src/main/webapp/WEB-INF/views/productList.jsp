
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
					<th>View Product</th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>

					<td><img alt="image" src="#"></td>
					<td>${product.productName }</td>
					<td>${product.price }</td>
					<td><span class="glyphicon glyphicon-info-sign"></span> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<!-- /.container -->

<%@include file="/WEB-INF/views/templates/footer.jsp"%>
