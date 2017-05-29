<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte</title>
</head>
<body>

	<section>
		<c:out value="${account.name}"/>&nbsp;: 
		<fmt:formatNumber type="currency" 
		value="${account.balanceAmount.valueWithFractionDigits}" 
		currencySymbol="${account.balanceAmount.currency.symbol}"/>
	</section>

</body>
</html>