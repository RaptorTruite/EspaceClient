<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Espace Client G19</h1>
	<c:if test="${erreur ne null}"><h2>${erreur}</h2></c:if>
	<form action="" method="post">
		<input type="email" name="EMAIL" placeholder="Email"><br>
		<input type="password" name="PASSWORD" placeholder="Mot De Passe"><br>
		<input type="submit" value="Connexion">
	</form>
</body>
</html>