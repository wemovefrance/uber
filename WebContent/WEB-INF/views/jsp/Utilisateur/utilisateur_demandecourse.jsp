<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <!--  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script> -->


    <div class="photo-nom-prenom-notes-conducteur">
   			 	<img src ="" id ="photo-profil-chauffeur"/>
    			<p> <c:out value="${conducteurOnClick.prenom}"/> <c:out value="${conducteurOnClick.nom}"/> </p>
    </div>


  </form>
  
    
    <form:form modelAttribute="nouveauTrajet" action ="demandecourse" method="post">

	 <%-- <form:label path="dateDuTrajet"> Date du trajet <span class="required"
				title="ce champ est obligatoire">*</span>
		</form:label>
		<form:input path="dateDuTrajet" id="datepicker" placeholder="Sélectionner une date"/>
		<form:errors path="dateDuTrajet" />
		<br /> --%>
		
		 <label>Date du trajet<span class="required"
				title="ce champ est obligatoire">*</span>
		 <form:errors path="dateDuTrajet"  style="color:red" /></label>
		<input type="date" class="datepicker" id="dateTrajet" STYLE="Text-ALIGN:center">
  
  	<form:hidden id="dateT" path="dateDuTrajet" value=""/> 

  <label>Adresse de départ <span class="required"
				title="ce champ est obligatoire">*</span>
  <form:errors path="depart.nom"  style="color:red"  /></label>
  <input id="user_input_autocomplete_address" placeholder="Commencer à taper une adresse..." STYLE="Text-ALIGN:center">
	<input type="hidden" id="street_number" name="street_number" disabled>
  <input type="hidden" id="route" name="route" disabled>
  <input type="hidden" id="locality" name="locality" disabled>
  <input type="hidden" id="country" name="country" disabled> 
  
  <label>Adresse d'arrivée</label>
  <form:errors path="arrivee.nom"  style="color:red" />
  <input id="user_input_autocomplete_address_2" placeholder="Commencer à taper une adresse..." STYLE="Text-ALIGN:center">
  
  	<form:hidden id="D" path="depart.nom" value=""/> 
	<form:hidden id="A" path="arrivee.nom" value=""/>   
	
	
<form:select style="display:block" name="forfaitKilomètre" id="forfaitKilometre" path="distance" >
  <form:option value = "30.0">0 - 50 km  </form:option>
  <form:option value = "50.0">50 - 100 km</form:option>
  <form:option value = "70.0">100 - 150 km</form:option>
  <form:option value = "150.0">Plus de  150 km</form:option>
</form:select>

		
		<form:label path="poids" id="poids"> Estimer le poids des objets à transporter en kg <span
				class="required" title="ce champ est obligatoire">*</span>
		<form:errors path="poids"  style="color:red"  />
		</form:label>
		<form:input path="poids" id="weight" type="number" STYLE="Text-ALIGN:center"/>
		<br />
    		
  
	<form:label path="commentaire"> Commentaires : <span
				class="required" title="ce champ est obligatoire">*</span>
		<form:errors path="commentaire"  style="color:red" />
		</form:label>
		<form:textarea path="commentaire" STYLE="Text-ALIGN:center" />
		<br />
		

    	<div style="backgound-color:red"><input class="btn-large waves-effect waves-light teal lighten-1" type="submit" value="Demander course" /></div>
    	<br />
    	<div style="backgound-color:red"><input class="btn-large waves-effect waves-light teal lighten-1" type="button" value="Simuler Prix" onclick="simulerPrix()"/></div>
    	
    	
    <form:label path="prix" id="prix"> Résultat de l'estimation du prix en euros : <span
				class="required" title="ce champ est obligatoire">*</span>
	<form:errors path="prix" />
	</form:label>
    <form:input path="prix" id="p" value=""/>
	<br />
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

<script type="text/javascript">

///// Simuler prix
	
function simulerPrix() {
	
	var kilometre = parseInt($('#forfaitKilometre').val());
	var poids = parseInt($('#weight').val());
	
	var prix = kilometre + poids * 0.50 ;
	
	console.log(typeof poids);
	console.log(typeof kilometre);
	console.log(prix);
	
	$('#p').val(prix);
	
	/////Autocomplete date
	
	 $('.datepicker').pickadate({
		    selectMonths: true, // Creates a dropdown to control month
		    selectYears: 15 // Creates a dropdown of 15 years to control year
		  });
	
	var dat = $('#dateTrajet').val();
	 $('#dateT').val(dat);
	
}

</script>
