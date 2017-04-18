<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div id="infoposition"></div>
<div id="map" style="height: 500px;border-style: solid;"></div>
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



<p> Bienvenue sur votre espace personnel ${utilisateur.prenom} ${utilisateur.nom} </p>  <br />
		
	
<br />




