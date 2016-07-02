<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Customer registered Successfully</h1>
			<p class="lead">You can not view and shop products</p>
		</div>
		
		<section class="container">
            <p>
                <a href="<spring:url value="/" />" class="btn btn-default">Products</a>
            </p>
        </section>
	</div>
</div>
<!-- /.container -->
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>
