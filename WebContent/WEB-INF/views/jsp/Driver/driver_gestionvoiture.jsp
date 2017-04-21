<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h4>Vos vehicules</h4>
<ul>
	<c:forEach var="vehicule" items="${listeVehicule}">
		<li><c:out value="${vehicule.marque}" /> <c:out
				value="${vehicule.modele}" /> (<c:out
				value="${vehicule.typeVehicule}" /> ): volume du coffre = <c:out
				value="${vehicule.volumeCoffre}" /> metres cubes <a
			href="removeVehicule?idcar=${vehicule.id_vehi}"><i
				class="fa fa-minus fa-1x" style="color: #26a69a"></i></a></li>
	</c:forEach>

</ul>

<p onclick="afficheFormulaire()"><i class="fa fa-plus fa-2x" style="color: #26a69a"></i></p>


<form:form id="formulaireNouveauVehicule" method="post" action="drivergestionvehicule"
	modelAttribute="nouveauVehicule"  style="display:none">

	<form:label path="marque"> Marque : </form:label>
	<form:input path="marque" STYLE="Text-ALIGN:center" />
	<br />

	<form:label path="modele"> Modele </form:label>
	<form:input path="modele" STYLE="Text-ALIGN:center"/>
	<br />

	<form:label path="volumeCoffre"> Volume coffre (m3) </form:label>
	<form:input path="volumeCoffre" STYLE="Text-ALIGN:center"/>
	<br />

	<form:label path="typeVehicule"> Type de vehicule </form:label>
	<form:input path="typeVehicule" STYLE="Text-ALIGN:center" />
	<br />
	<br />

	<input type="submit" value="Ajouter vehicule"  class="btn-large waves-effect waves-light teal lighten-1"/>
</form:form>

<script src="<c:url value="/js/driver_gestionvoiture.js" />"></script>