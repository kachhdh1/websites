<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Customer</h1>

			<p class="lead">Customer Details</p>
		</div>

		<form:form commandName="order" class="form-horizaontal">

			<h3>Billing Address</h3>

			<div class="form-group">
				<label for="shippingStreet">Street Name</label>
				<form:input path="cart.customer.billingAddress.streetName"
					id="shippingStreet" class="form-control" />
			</div>

			<div class="form-group">
				<label for="shippingApartmentNumber">Apartment Name</label>
				<form:input path="cart.customer.billingAddress.apartmentName"
					id="shippingApartmentNumber" class="form-control" />
			</div>

			<div class="form-group">
				<label for="shippingCity">City</label>
				<form:input path="cart.customer.billingAddress.city"
					id="shippingCity" class="form-control" />
			</div>

			<div class="form-group">
				<label for="shippingState">State</label>
				<form:input path="cart.customer.billingAddress.state"
					id="shippingState" class="form-control" />
			</div>

			<input type="hidden" name="_flowExecutionKey" />

			<br>
			<br>
			<button class="btn btn-default"
				name="_eventId_backToCollectCustomerInfo">Back</button>
			<input type="submit" value="Next" class="btn btn-default"
				name="_eventId_billingDetailCollected" />
			<button class="btn btn-default" name="_eventId_cancel">Cancel</button>
		</form:form>


		<%@include file="/WEB-INF/views/templates/footer.jsp"%>