<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regler Facture</title>
</head>
<body>
	<div>
	<p>Client connecté : ${client.nom} ${client.prenom}</p>
		<a href="index">Deconnexion</a>
	</div>
	
	<div>
		<h1>Reglement de la facture ${facture.id}</h1>
		<h2>Montant de la facture : ${facture.montantEnEuros}€</h2>
	</div>
	
	<form action="reglerFacture" method="post">
		<label>Montant du réglement</label>
		<input type="number" name="MONTANT" max="${facture.montantEnEuros - facture.totalPaiementsRecus }" required>
		
		<br>
		
		<label>Date d'échéance</label>
		<input type="date" name="ECHEANCE" required>
		
		<br>
		
		<label>Carte bancaire</label>
		<select name="ID_CARTE" required>
			<c:forEach items="${cartes}" var="carte">
			<option value="${carte.id}">${carte.numero}</option>
			</c:forEach>
		</select>
		
		<br>
		
		<input type="hidden" name="ID_FACTURE" value="${facture.id }">
		<input type="submit" value="Régler">
	</form>
</body>
</html>