<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>

    
    <div class="photo-nom-prenom-notes-conducteur">
   			 	<img src ="" id ="photo-profil-chauffeur"/>
    			<p> <c:out value="${conducteurOnClick.prenom}"/> <c:out value="${conducteurOnClick.nom}"/> </p>
   			 	<p class="noteChauffeur"> Note moyenne </p>
    </div>
    
    
    <form method="get" action="utilisateur/profilchauffeur?userId='${conducteurOnClick.id_user}'">
    <input type= "submit" id="butt-consult-conducteur" value="Retour profil <c:out value="${conducteurOnClick.prenom }"/>"/>
	</form>
    
    <form:form modelAttribute="nouveauTrajet" action ="demandecourse" method="post">

	 <form:label path="dateDuTrajet"> Date du trajet <span class="required"
				title="ce champ est obligatoire">*</span>
		</form:label>
		<form:input path="dateDuTrajet" id="datepicker" placeholder="Sélectionner une date"/>
		<form:errors path="dateDuTrajet" />
		<br />

  <label>Adresse de départ</label>
  <input id="user_input_autocomplete_address" placeholder="Commencer à taper une adresse...">
	<input type="hidden" id="street_number" name="street_number" disabled>
  <input type="hidden" id="route" name="route" disabled>
  <input type="hidden" id="locality" name="locality" disabled>
  <input type="hidden" id="country" name="country" disabled> 
  <form:errors path="depart.nom" />
  
  <label>Adresse d'arrivée</label>
  <input id="user_input_autocomplete_address_2" placeholder="Commencer à taper une adresse...">
  <form:errors path="arrivee.nom" />
  
  	<form:hidden id="D" path="depart.nom" value=""/> 
	<form:hidden id="A" path="arrivee.nom" value=""/>   
    		
  
	<form:label path="commentaire"> Commentaire avec le volume et le poids des objets à déménager : <span
				class="required" title="ce champ est obligatoire">*</span>
		</form:label>
		<form:textarea path="commentaire" />
		<form:errors path="commentaire" />
		<br />

    	<div style="backgound-color:red"><input type="submit" value="Demander course" /></div>
    </form:form>  
    
 <script type="text/javascript"
  src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c">
</script>

<script type="text/javascript">

function initializeAutocompleteDeux(id) {
	  var element = document.getElementById(id);
	  if (element) {
	    var autocomplete = new google.maps.places.Autocomplete(element, { types: ['geocode'] });
	    google.maps.event.addListener(autocomplete, 'place_changed', onPlaceChangedDeux);
	  }
	}
	
function initializeAutocomplete(id) {
	  var element = document.getElementById(id);
	  if (element) {
	    var autocomplete = new google.maps.places.Autocomplete(element, { types: ['geocode'] });
	    google.maps.event.addListener(autocomplete, 'place_changed', onPlaceChanged);
	  }
	}
	
	////////////
		function onPlaceChanged() {
	  var place = this.getPlace();
	  //console.log(place);  // Uncomment this line to view the full object returned by Google API.
	  for (var i in place.address_components) {
	    var component = place.address_components[i];
	    for (var j in component.types) {  // Some types are ["country", "political"]
	      var type_element = document.getElementById(component.types[j]);
	      if (type_element) {
	        type_element.value = component.long_name;
	      }
	    }
	  }
	  var A = $('#street_number').val() + " " + $('#route').val() + ", " + $('#locality').val() + ", " + $('#country').val();
	  $('#A').val(A);
	}

	function onPlaceChangedDeux() {
	  var place = this.getPlace();
	  //console.log(place);  // Uncomment this line to view the full object returned by Google API.
	  for (var i in place.address_components) {
	    var component = place.address_components[i];
	    for (var j in component.types) {  // Some types are ["country", "political"]
	      var type_element = document.getElementById(component.types[j]);
	      if (type_element) {
	        type_element.value = component.long_name;
	      }
	    }
	  }
	  var D = $('#street_number').val() + " " + $('#route').val() + ", " + $('#locality').val() + ", " + $('#country').val();
	  $('#D').val(D);
	}

	/////////////////Listeners
	
	google.maps.event.addDomListener(window, 'load', function() {
	  initializeAutocompleteDeux('user_input_autocomplete_address');
	});
	
	google.maps.event.addDomListener(window, 'load', function() {
		  initializeAutocomplete('user_input_autocomplete_address_2');
		});

</script>


	
    
