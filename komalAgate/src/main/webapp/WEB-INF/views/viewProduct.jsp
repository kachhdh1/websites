
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Details</h1>
			<p class="lead">Selected product details listed below !</p>
		</div>

		<div class="row">
			<div class="col-md-6">
				<img src='<c:url value="/images/${product.id }.png"/>' style="width: 100%; height: 300px;">
			</div>
			<div class="col-md-6">
				<h2>${product.productName }</h2>
				<p>${product.productCategory } </p>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->

<%@include file="/WEB-INF/views/templates/footer.jsp"%>
