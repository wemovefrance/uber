<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<h1>Carte</h1>

<div id="map" style="height: 500px;"></div>

<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c&callback=initMap"
	async defer>
	
</script>
<form>
	<input id="latitudeshidden" type="hidden" name="latitudesConducteur"
		value="${latitudesConducteurs}"> 
	<input id="longitudeshidden"
		type="hidden" name="longitudesConducteur"
		value="${longitudesConducteurs}"> 
	<input id="usernameshidden"
		type="hidden" name="usernamesConducteur"
		value="${usernamesConducteurs}">
	<input id="userIdshidden"
		type="hidden" name="idsConducteur"
		value="${userIdConducteurs}">
</form>
