<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Product</h1>
			<p class="lead">Add the product here and it will be listed in
				product inventory page</p>
		</div>

		<form:form
			action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
			method="post" commandName="product" enctype="multipart/form-data">
			<div class="form-group">
				<label for="productName">Product Name</label> 
				<form:input path="productName" class="form-control" id="productName" />
			</div>
			<div class="form-group">
				<label for="productCategory">Product Category</label> 
				<form:input path="productCategory" class="form-control" id="productCategory" />
			</div>
			<div class="form-group">
				<label for="productPrice">Product Price</label> 
				<form:input path="productPrice" class="form-control" id="productPrice" />
			</div>
			<div class="form-group">
				<label for="productCondition">Product Condition</label> 
				<form:input path="productCondition" class="form-control" id="productCondition" />
			</div>
			<div class="form-group">
				<label class="control-label" for="productImage">Upload Picture</label> 
				<form:input type="file" path="productImage" class="form:input-large" id="productImage" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
</div>
<!-- /.container -->

<%@include file="/WEB-INF/views/templates/footer.jsp"%>
