<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Facture</title>
</head>
<body>
	<div>
		<p>Client connecté : ${client.nom} ${client.prenom}</p>
		<a href="index">Deconnexion</a>
	</div>
	
	<div>
		<h2>Facture numéro ${facture.id}</h2>
		<p>Montant : ${facture.montantEnEuros}€</p>
		<p>Date de création : <fmt:formatDate pattern="dd/MM/yyyy" value="${facture.dateCreation }"/></p>
		<p>Date d'échéance : <fmt:formatDate pattern="dd/MM/yyyy" value="${facture.dateEcheance }"/></p>
	</div>
	
	<div>
		<h3>Paiement.s reçu.s</h3>
		<table>
			<tr>
				<td>Montant</td>
				<td>Date Effective</td>
				<td>Carte</td>
			</tr>
			<c:forEach items="${paiements}" var="paiement">
				<tr>
					<td>${paiement.montantEnEuros}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${paiement.dateEffective }"/></td>
					<td>${paiement.carteBancaire.numero}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="tableauDeBord">Retour au tableau de bord</a>
</body>
</html>