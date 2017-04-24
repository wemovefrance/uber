<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<i class="fa fa-user-circle-o fa-5x" aria-hidden="true"></i>
<div class="infoChauffeur">

	<div class="photo-nom-prenom-notes-conducteur">
		<img src="" id="photo-profil-chauffeur" />
		
		<h4> Profil conducteur de <c:out value="${conducteurOnClick.login}"/> </h4>
   			 	
   			 	<p>  <c:out value="${conducteurOnClick.prenom}"/> possède les véhicule(s) suivant(s) : </p>
   			 	<ul> 
   			 				<c:forEach items="${vehiculeByConducteur}" var="vehicule">
   			 				<li>
   			 				- <c:out value = "${vehicule.marque}"/> <c:out value = "${vehicule.modele}"/> de type <c:out value = "${vehicule.typeVehicule}"/> avec un volume de coffre estimé à <c:out value = "${vehicule.volumeCoffre}"/> m3 <br />
   			 				</li>
   			 				</c:forEach>
   			 	</ul> 

	</div>
	
	

</div>
<div class="demanderCourse" >

	<form action="demandecourse">
		<input type="submit" value="Demander course" id="butt-ask-course" class="btn-large waves-effect waves-light teal lighten-1" />
	</form>
</div>