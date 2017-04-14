<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="infoChauffeur">

	<div class="photo-nom-prenom-notes-conducteur">
		<img src="" id="photo-profil-chauffeur" />
		<h1>
			Profil conducteur de <c:out value="${conducteurOnClick.login}"/>
		</h1>
		<p> <u>Prenom</u> : <c:out value="${conducteurOnClick.prenom}" /> &nbsp;&nbsp;&nbsp;&nbsp; <u>Nom</u> : <c:out value="${conducteurOnClick.nom}" /> </p>
		<p><u>Vehicules a disposition :</u></p>
		<ul>
			<c:forEach items="${vehiculeByConducteur}" var="vehicule">
				<li>
					<ul>
					<li><c:out value="${vehicule.marque}" /> <c:out value="${vehicule.modele}" /><li>
					<li><u>Volume du coffre :</u> <c:out value="${vehicule.volumeCoffre}" /> metres cubes<li>	
					<br>
					</ul>
				</li>
			</c:forEach>
		</ul>

	</div>

</div>
<div class="demanderCourse" >

	<form action="demandecourse">
		<input type="submit" value="Demander course" id="butt-ask-course" />
	</form>
</div>