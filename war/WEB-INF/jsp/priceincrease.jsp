<%@ page pageEncoding="UTF-8" %>
<%@ include file="include-preceding-html.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><spring:message code="application.title" /></title>
<%@ include file="head-includes.jsp"%>
<style>
.error {
	color: red;
}
</style>
</head>

<body>
	<h1>
		<spring:message code="priceincrease.heading" />
	</h1>
	<form:form method="post" commandName="priceIncrease">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">Increase (%):</td>
				<td width="20%"><form:input path="percentage" />
				</td>
				<td width="60%"><form:errors path="percentage" cssClass="error" />
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Execute" />
	</form:form>
	<a href="<c:url value="hello.html"/>">Home</a>
</body>
</html>
