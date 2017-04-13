<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div id="infoposition"></div>
<div id="map" style="height: 500px;"></div>

<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c&callback=initMap"
	async defer>
	
</script>
<form>
	<input id="latitudeshidden" type="hidden" name="latitudesConducteur"
		value="${latitudesConducteurs}"> <input id="longitudeshidden"
		type="hidden" name="longitudesConducteur"
		value="${longitudesConducteurs}"> <input id="usernameshidden"
		type="hidden" name="usernamesConducteur"
		value="${usernamesConducteurs}"> <input id="userIdshidden"
		type="hidden" name="idsConducteur" value="${userIdConducteurs}">
</form>



<div class=" info-trajets">
	<ul class="mesTrajets">

		<li>Bonjour ${utilisateur.nom} ${utilisateur.prenom} <br />
		</li>
		<li>Dernier trajet : ${dernierTrajet.dateDuTrajet}</li>
		<li>prochain trajet : ${prochainTrajet.dateDuTrajet}</li>
	</ul>
</div>
<br />


<div class="map"></div>

<input type="button" id="gestionTrajet" value=" Gestion d'un trajet" />
<input type="button" id="gestionTransaction"
	value=" Gestion transactions" />
