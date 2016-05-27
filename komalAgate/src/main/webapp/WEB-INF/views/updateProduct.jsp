
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Update Product</h1>
			<p class="lead">Update the product here and it will be listed in
				product inventory page</p>
		</div>
	<form:form
			action="${pageContext.request.contextPath}/admin/productInventory/updateProduct"
			method="post" commandName="product" enctype="multipart/form-data">
	
		<div class="form-group">
				<label for="productName">Product Name</label> 
				<form:input path="productName" value="${product.productName }" class="form-control" id="productName" />
			</div>
			<!-- category -->
		<div class="form-group">
				<label for="productCategory">Product Category</label> 
				<form:input path="productCategory" value="${product.productCategory }" class="form-control" id="productCategory" />
			</div>
			<!-- price -->
			<div class="form-group">
				<label for="productPrice">Product Price</label> 
				<form:input path="productPrice"  value="${product.productPrice }" class="form-control" id="productPrice" />
				<form:hidden path="id" value="${product.id }"/>
			</div>
			<!-- condition -->
			<div class="form-group">
				<label for="productCondition">Product Condition</label> 
				<form:input path="productCondition" value="${product.productCondition }" class="form-control" id="productCondition" />
			</div>
			<div class="col-md-6">
				<label for="productImage">Product Image</label>
				 <img src='<c:url value="/images/${product.id }.png"/>' style="width: 50%; height: 100px;">
			 <form:input type="file" path="productImage" class="form:input-large" id="productImage" /> 
			</div>
			<button type="submit" class="btn btn-default">Update</button>
	</form:form>
		
	</div>
</div>
<!-- /.container -->

<%@include file="/WEB-INF/views/templates/footer.jsp"%>
