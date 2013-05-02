<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>



<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="name/html; charset=ISO-8859-1">
<title>Team Players</title>
</head>
<body   bgcolor="DDDDDD"  >
	
<a href="j_spring_security_logout">Logout: <security:authentication
			property="principal.username" />
</a>

<h1 style="font-family:verdana;">Team Players Application </h1>
<p style="font-family:arial;color:red;font-size:20px;">List of Players available on the Team </p> 

<br />
 
 
 
 
 <c:forEach items="${players}" var="player" varStatus="row">
		 ${player.playerId } -${player.name } - ${player.manager} 
		<form action="notfit.html" method="post">
			<input name="playerID" value="${player.playerId}" type="hidden"> <input
				type="submit" value="Not Fit to Play">
		</form>
		<form action="fit.html" method="post">
			<input name="playerID" value="${player.playerId}" type="hidden"> <input
				type="submit" value="Fit to Play">
		</form>
	</c:forEach>
	<form action="newplayer.html" method="post">
		<input name="name"> <input type="submit" value="NewPlayer">
	</form>
 

 <br />
 



</body>
</html>

