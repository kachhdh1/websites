
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Administrator</h1>
			<p class="lead">Product inventory can be managed here</p>
		</div>

		<c:if test="${not empty pageContext.request.userPrincipal.name}">
			<h2>
				Welcome:
				<c:out value="${pageContext.request.userPrincipal.name}" />
				| <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
			</h2>
		</c:if>

		<h3>
			<a href="<c:url value="/admin/product"/>">Product Inventory</a>
		</h3>
		<p>Here you can view, check and manage product inventory.</p>
	</div>
</div>
<!-- /.container -->

<%@include file="/WEB-INF/views/templates/footer.jsp"%>
