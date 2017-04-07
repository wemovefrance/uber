<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="<c:url value="/css/materialize.css" />" rel="stylesheet">
<!--  <link href="<c:url value="/css/materialize.min.css" />" rel="stylesheet"> -->
<link href="<c:url value="/css/theme.css" />" rel="stylesheet">
<!--<script src="<c:url value="/js/jmaterialize.js" />"></script>-->
<!--<script src="<c:url value="/js/materialize.min.js" />"></script>--> 
<!-- <script src="<c:url value="/js/googlemapapi.js" />"></script> -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="<c:url value="/js/gestioncartejquery.js" />"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">

<title><tiles:insertAttribute name="title" /></title>


<script>
    function initMap() {
    	 var map = new google.maps.Map(document.getElementById('map'), {
    	   center: {lat: -34.397, lng: 150.644},
    	   zoom: 9	 })

    var infoWindow = new google.maps.InfoWindow({map: map});

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function(position) {
        var pos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };

        infoWindow.setPosition(pos);
        infoWindow.setContent('Votre position');
        map.setCenter(pos);
      }, function() {
        handleLocationError(true, infoWindow, map.getCenter());
      });
    } else {
      // Browser doesn't support Geolocation
      handleLocationError(false, infoWindow, map.getCenter());
    }
  };

  function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
                          'Erreur: Nous n\'avons pas réussi à vous trouver.' :
                          'Erreur: Votre navigateur ne supporte pas la géolocalisation.');
  }
</script>
    
</head>

<body>
	<tiles:insertAttribute name="navigation" />
	<table width="100%">
		<tr>
			<th
			 class="bodyaccueil"><tiles:insertAttribute name="body" /></th>
			<th id="menu"><tiles:insertAttribute name="menu" /></th>
		</tr>
	</table>
	<p id="footer">
		<tiles:insertAttribute name="footer" />
	</p>
</body>
</html>
