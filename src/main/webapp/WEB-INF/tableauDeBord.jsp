<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tableau de Bord</title>
</head>
<body>
	<div>
		<p>Client connecté : ${sessionScope.client.nom} ${sessionScope.client.prenom}</p>
		<a href="index">Deconnexion</a>
	</div>

	<div>
		<h1>Facture.s à régler</h1>
		<table>
			<tr>
				<td>Numéro</td>
				<td>Date d'échéance</td>
				<td>Montant</td>
				<td>Action</td>
			</tr>
			<c:forEach var="facture" items="${facturesARegler}">
				<tr>
					<td>${facture.id}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${facture.dateEcheance}"/></td>
					<td>${facture.montantEnEuros}</td>
					<td><a href="reglerFacture?ID=${facture.id}">Regler</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div>
		<h1>Facture.s reglée.s</h1>
		<table>
			<tr>
				<td>Numéro</td>
				<td>Date d'échéance</td>
				<td>Montant</td>
				<td>Action</td>
			</tr>
			<c:forEach var="facture" items="${facturesReglees}">
				<tr>
					<td>${facture.id}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${facture.dateEcheance}"/></td>
					<td>${facture.montantEnEuros}</td>
					<td><a href="voirFactureReglee?ID=${facture.id}">Voir</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div>
		<h1>Carte.s Bancaire.s</h1>
		<table>
			<tr>
				<td>Numéro</td>
				<td>Expiration</td>
				<td>Cryptogramme</td>
				<td>Action</td>
			</tr>
			<c:forEach var="carte" items="${cartesBancaires}">
				<tr>
					<td>${carte.numero}</td>
					<td>${carte.moisExpiration}/${carte.anneeExpiration}</td>
					<td>${carte.cryptogramme}</td>
					<td><a href="supprimerCarte?ID=${carte.id}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="ajouterCarte">Ajouter une carte bancaire</a>
	</div>
</body>
</html>