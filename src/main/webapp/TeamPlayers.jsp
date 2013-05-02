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
	


<h1 style="font-family:verdana;">Team Players Application </h1>
<p style="font-family:arial;color:red;font-size:20px;">List of Players available on the Team </p> 

<c:forTokens items=",Ann,Rosie,Tom, Tim" delims="," var="name">
   <c:out value="${name}"/><p>
</c:forTokens> 
<br />
 
 
 
 
 <c:forEach items="${players}" var="player" varStatus="row">
		 ${player.name } - ${player.fittoplay} 
		<form action="notfit.html" method="post">
			<input name="playerID" value="${player.playerId}" type="hidden"> <input
				type="submit" value="notFit">
		</form>
		<form action="fit.html" method="post">
			<input name="playerID" value="${player.playerId}" type="hidden"> <input
				type="submit" value="fit">
		</form>
	</c:forEach>
	<form action="newplayer.html" method="post">
		<input name="name"> <input type="submit" value="NewPlayer">
	</form>
 

 <br />
 



</body>
</html>

