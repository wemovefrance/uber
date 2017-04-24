<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<i class="fa fa-cog fa-3x" aria-hidden="true"></i>
<h3>Voici ci-dessous les informations relatives à votre compte </h3>

<div id="formulaire">

<form:form modelAttribute="driverUpdate" action="gestionprofil" method="post">


	<form:label path="nom"> Nom <span class="required" title="le nom est obligatoire">*</span> </form:label>
 	<form:input path="nom" value = "${conducteur.nom}"  STYLE="Text-ALIGN:center" />
 	<form:errors class="error" path="nom"/>

 	<br />
	
 	<form:label path="prenom"> Prenom : <span class="required" title="ce champ est obligatoire">*</span></form:label>
 	<form:input path="prenom" value = "${conducteur.prenom}"  STYLE="Text-ALIGN:center"  />
 	<form:errors class="error" path="prenom"/>

	
 	<form:label path="login"> Login :<span class="required" title="ce champ est obligatoire">*</span> </form:label>
 	<form:input  path="login" value = "${conducteur.login}" STYLE="Text-ALIGN:center"  />
 	<form:errors class="error" path="login"/>

 <br />
	
 	<form:label path="email"> Email :<span class="required" title="ce champ est obligatoire">*</span> </form:label>
 	<form:input path="email" value = "${conducteur.email}"  STYLE="Text-ALIGN:center" />
 	<form:errors class="error" path="email"/>
 	
 	 <br />

	<label> Adresse <span class="required" title="ce champ est obligatoire">*</span></label>
  	<input id="user_input_autocomplete_address" value ="${adresse.nom}"  STYLE="Text-ALIGN:center" >
  	<input type="hidden" id="street_number" name="street_number" disabled>
  	<input type="hidden" id="route" name="route" disabled>
  	<input type="hidden" id="locality" name="locality" disabled>
  	<input type="hidden" id="country" name="country" disabled>
	<form:errors path="adresse.nom" />
	
 	<br />
	
	<form:label path="motDePasse"> Mot de passe :  <span class="required" title="ce champ est obligatoire">*</span> </form:label>
	<form:password path="motDePasse" value = "${conducteur.motDePasse}" STYLE="Text-ALIGN:center" />
	<form:errors class="error" path="motDePasse"/>
		
	<br />
 	
	<form:label path="confirmation"> Confirmation :  <span class="required" title="ce champ est obligatoire">*</span> </form:label>
	<form:password path="confirmation"  value = "${conducteur.motDePasse}"  STYLE="Text-ALIGN:center" />
	<form:errors class="error" path="confirmation"/>
		
	<br />
	
	<form:hidden id="lat" path="adresse.latitude" value=""/>
	<form:hidden id="lon" path="adresse.longitude" value=""/>
 	<form:hidden id="tex" path="adresse.nom" value=""/>
 	
 	<input  type="submit" id="butt-submit" value="Mise a jour de mon profil" class="btn-large waves-effect waves-light teal lighten-1" />
 	<br /> 
 	<span class="message"> <c:out value="${message}"/></span>
 	
	
 
</form:form>
 
<script type="text/javascript"
  src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c">
</script>

<script src="<c:url value="/js/autocomplete.js" />"></script>

<script type="text/javascript">



	function geocode(){
		   var longitude = 0;
	        var latitute = 0;
	        var address = $('#street_number').val() + " " + $('#route').val() + ", " + $('#locality').val() + ", " + $('#country').val();
	        console.log(address);
	        var geocoder = new google.maps.Geocoder();

	        /* Appel au service de geocodage avec l'adresse en paramï¿½tre */
	        geocoder.geocode({
	            'address': address
	        }, function(results, status) {
	            /* Si l'adresse a pu ï¿½tre gï¿½olocalisï¿½e */
	            if (status == google.maps.GeocoderStatus.OK) {
	                /* Rï¿½cupï¿½ration de sa latitude et de sa longitude */
	                latitude = results[0].geometry.location.lat();
	                longitude = results[0].geometry.location.lng();
	                $('#lat').val(latitude);
	                $('#lon').val(longitude);
	                $('#tex').val(address);

	                console.log($('#lat').val());
	                console.log($('#lon').val());
	            } 
	        });
	}
	

	
</script>


  </div>