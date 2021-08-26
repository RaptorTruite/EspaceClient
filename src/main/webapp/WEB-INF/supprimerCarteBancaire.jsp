<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer Carte</title>
</head>
<body>
	<div>
		<h2>Voulez vous vraiment supprimer la carte ${carte.numero} ?</h2>
		<p><a href="confirmerSuppressionCarte?ID=${carte.id}">Oui</a><a href="tableauDeBord">Non</a></p>
	</div>
</body>
</html>