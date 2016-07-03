<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Details</h1>
			<p class="lead">Selected product details listed below !</p>
		</div>

		<div class="row">
			<div class="col-md-6">
				<img src='<c:url value="/images/${product.id }.png"/>'
					style="width: 100%; height: 300px;">
			</div>
			<div class="col-md-6">
				<h2>${product.productName }</h2>
				<p>${product.productCategory }</p>
				<h4>${product.productPrice} INR</h4>
			</div>
			<br>
			
			<p >
				<a href='<spring:url value="/mvc/cart/add/${product.id}" />' class="btn btn-warning btn-large" >
					<span class="glyphicon glyphicon-shopping-cart">Order Now</span>
				</a>
				<a href="<spring:url value="/customer/cart" />" class="btn btn-default"><span
					class="glyphicon glyphicon-hand-right"></span>View Cart</a>
			</p>
			<br></br>
			<div>
				<c:if test="${not empty param.productAdd}" >
					<h4>Product Successfully added to your cart..</h4>
				</c:if>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>
