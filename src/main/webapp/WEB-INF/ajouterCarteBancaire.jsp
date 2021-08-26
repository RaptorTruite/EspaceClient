<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter une carte bancaire</title>
</head>
<body>
	<form action="ajouterCarte" method="post">
		<label>Numéro</label>
		<input type="text" name="NUMBER" minlength="16" maxlength="16" required>
		
		<br>
		
		<label>Expiration</label>
		<select name="MONTH" required>
		<c:forEach var="mois" items="${mois}">
			<option value="${mois}">${mois}</option>
		</c:forEach>
		
		</select>
		<select name="YEAR" required>
			<c:forEach var="annee" items="${annees}">
			<option value="${annee}">${annee}</option>
		</c:forEach>
		</select>
		
		<br>
		
		<label>Cryptogramme</label>
		<input type="text" name="CRYPTO" minlength="3" maxlength="3" required>
		
		<br>
		
		<input type="submit" value="Ajouter">
	</form>
</body>
</html>