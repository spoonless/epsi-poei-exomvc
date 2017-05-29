<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'un compte</title>
</head>
<body>

<c:if test="${not empty error}">
	<c:out value="${error}"></c:out>
</c:if>
<form action="<c:url value="/accounts"/>" method="POST">
	<label>Nom du compte</label>
	<input name="accountName" value="<c:out value="${param['accountName']}"/>"><br>
	<label>Numéro du compte</label>
	<input name="accountNumber" value="<c:out value="${param['accountNumber']}"/>"><br>
	<label>Solde initial</label>
	<input name="accountBalanceInteger" value="<c:out value="${param['accountBalanceInteger']}"/>">,
	<input name="accountBalanceFraction" size="2" maxlength="2" value="<c:out value="${param['accountBalanceFraction']}"/>"><br>
	<button type="submit">Créer</button>
</form>

</body>
</html>