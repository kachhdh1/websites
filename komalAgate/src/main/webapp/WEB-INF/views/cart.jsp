<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Cart</h1>
			<p class="lead">The products added to your cart.</p>
		</div>

		<section  ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
			
				<div>
					<a class="btn btn-danger" ng-click="clearCart()">
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
					<tr ng-repeat="item in cart.cartItems">
						<td>{{item.product.productName}}</td>
						<td>{{item.product.productPrice}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalAmount}}</td>
						<td>
							<a href="#" class="label label-danger" ng-click="removeFromCart(item.product.id)">
								<span class="glyphicon glyphicon-remove">remove</span>
							</a>
						</td>
					</tr>
					<tr>
	                    <th></th>
	                    <th></th>
	                    <th>Grand Total</th>
	                    <th>{{cartGrandTotal}}</th>
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
