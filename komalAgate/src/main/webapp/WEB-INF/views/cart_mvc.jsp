<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Cart</h1>
			<p class="lead">The products added to your cart.</p>
		</div>

		<section>
			<div >
			
				<div>
					<a class="btn btn-danger" href='<spring:url value="/mvc/cart/clear/${cart.cartId}" />'>
						<span class="glyphicon glyphicon-remove-sign">Clear Cart</span>
					</a>
				</div>
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
                    	<th>Action</th>
					</tr>
					<c:forEach items="${cart.cartItems}" var="item">
						<tr>
							<td>${item.product.productName}</td>
							<td>${item.product.productPrice}</td>
							<td>${item.quantity}</td>
							<td>${item.totalAmount}</td>
							<td>
								<a href='<spring:url value="/mvc/cart/remove/${item.product.id}/${cart.cartId}" />' class="label label-danger">
									<span class="glyphicon glyphicon-remove">remove</span>
								</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
	                    <th></th>
	                    <th></th>
	                    <th>Grand Total</th>
	                    <th>${cart.grandTotal }</th>
	                    <th></th>
                	</tr>
				</table>
			</div>
			<!-- Controller division ends -->
		</section>

	</div>
</div>
<!-- /.container -->
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>
