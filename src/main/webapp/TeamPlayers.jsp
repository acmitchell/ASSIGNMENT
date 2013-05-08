<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>



<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="name/html; charset=ISO-8859-1">
<title>Team Players</title>
</head>
<body bgcolor="DDDDDD">
	<h1 style="font-family: verdana;">Team Players Application</h1>


	<a href="j_spring_security_logout">Logout: <security:authentication
			property="principal.username" />
	</a>

	<p style="font-family: arial; color: brown; font-size: 20px;">Enter
		New Player Details</p>
	<form action="newplayer.html" method="post">

		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
				<td>Telephone</td>
				<td><input type="text" name="contactno"></td>
				<td>Date of Birth</td>
				<td><input type="text" name="dob"></td>
				<td><input type="submit" value="Create New Player"></td>
			</tr>

		</table>
	</form>
	<p style="font-family: arial; color: red; font-size: 20px;">Your
		Players Fit to Play</p>
	<table class="data" border=1>
		<tr>
			<th>Player Name</th>
		</tr>

		<c:forEach items="${fitplayers}" var="player" varStatus="row">
			<tr>
				<td>${player.name }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<p style="font-family: arial; color: green; font-size: 20px;">Your
		Players on the Team</p>

	<table class="data" border=1>
		<tr>
			<th>Player Name</th>
			<th>Contact Telephone Numbers</th>
			<th>Date Of Birth</th>
			<th>Player Fit to Play</th>
			<th>Remove Player</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${players}" var="player" varStatus="row">
			<tr>
				<td>${player.name }</td>
				<td>${player.contactno}</td>
				<td>${player.dob }</td>


				<c:choose>
					<c:when test="${player.fittoplay }">
						<td>
							<form action="notfit.html" method="post">
								<input name="playerId" value="${player.playerId}" type="hidden">
								<input type="submit" value="Not Fit to Play">
							</form>
						</td>
					</c:when>
					<c:otherwise>
						<td><form action="fit.html" method="post">
								<input name="playerId" value="${player.playerId}" type="hidden">
								<input type="submit" value="Fit to Play">
							</form></td>
					</c:otherwise>
				</c:choose>
				<td>
					<form action="delete.html" method="post">
						<input name="playerId" value="${player.playerId}" type="hidden">
						<input type="submit" value="Delete Player">
					</form>
				</td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>

