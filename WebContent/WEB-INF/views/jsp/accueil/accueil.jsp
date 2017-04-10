<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<h1>Bienvenue</h1>
<div id="infoposition"></div>
<div id="map" style="height: 500px;"></div>

<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c&callback=initMap"
	async defer>
</script>
<form>
	<input id="latitudeshidden" type="hidden" name="latitudesConducteur" value="${latitudesConducteurs}">
	<input id="longitudeshidden" type="hidden" name="longitudesConducteur" value="${longitudesConducteurs}">
	</form>