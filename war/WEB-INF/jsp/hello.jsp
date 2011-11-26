<%@ page pageEncoding="UTF-8"%>
<%@ include file="include-preceding-html.jsp"%>

<html>
<head>
<title><spring:message code="application.title" /></title>
<%@ include file="head-includes.jsp"%>
</head>

<body>
	<p>
		<a href="?lang=en_US">en</a> | <a href="?lang=de_DE">de</a> | <a
			href="?lang=cs_CZ">cz</a>
	</p>

	<h1>
		<spring:message code="heading" />
	</h1>
	<p>
		<spring:message code="greeting" />
		<c:out value="${model.now}" />
	</p>

	<h3>Products</h3>
	<c:forEach items="${model.products}" var="prod">
		<c:out value="${prod.description}" />
		<i>$<c:out value="${prod.price}" /> </i>
		<br>
		<br>
	</c:forEach>

	<br>
	<a href="<c:url value="priceincrease.html"/>">Increase Prices</a>
	<br>
	<a href="<c:url value="svj-navigatoru.html"/>">SVJ Navigátorů</a>
</body>
</html>
