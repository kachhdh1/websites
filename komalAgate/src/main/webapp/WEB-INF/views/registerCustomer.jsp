<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>

	        <form:form action="${pageContext.request.contextPath}/register" method="post"
	                   commandName="customer">
	
	        <h3>Basic Info</h3>
	        
			<span style="color: #ff0000">${registerErrorMsg}</span>
	        <div class="form-group">
	            <label for="name">Name</label><form:errors path="customerName" cssStyle="margin-left:5px; color: #ff0000"/>
	            <form:input path="customerName" id="name" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="email">Email</label><form:errors path="customerEmail" cssStyle="margin-left:5px; color: #ff0000"/>
	            <form:input path="customerEmail" id="email" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="phone">Phone</label>
	            <form:input path="customerPhone" id="phone" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="username">Username</label><form:errors path="username" cssStyle="margin-left:5px; color: #ff0000"/>
	            <form:input path="Username" id="username" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="password">Password</label><form:errors path="password" cssStyle="margin-left:5px; color: #ff0000"/>
	            <form:password path="password" id="password" class="form-control"/>
	        </div>
	
	
	        <h3>Billing Address</h3>
	
	        <div class="form-group">
	            <label for="billingStreet">Street Name</label>
	            <form:input path="billingAddress.streetName" id="billingStreet" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="billingApartmentNumber">Apartment Number</label>
	            <form:input path="billingAddress.apartmentName" id="billingApartmentName" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="billingCity">City</label>
	            <form:input path="billingAddress.city" id="billingCity" class="form-control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="billingState">State</label>
	            <form:input path="billingAddress.state" id="billingState" class="form-control"/>
	        </div>
	
	        <%-- <div class="form-group">
	            <label for="billingCountry">Country</label>
	            <form:input path="billingAddress.country" id="billingCountry" class="form-control"/>
	        </div> --%>
	        <button type="submit" class="btn btn-default">Register</button>
	        </form:form>
        </div>
        </div>

        <%@include file="/WEB-INF/views/templates/footer.jsp" %>
