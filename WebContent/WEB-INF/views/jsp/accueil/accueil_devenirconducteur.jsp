<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1 class="titrePage"> Devenir partenaire WeMove </h1>

    <div class="conducteur-inscription">

	<p>Créer un compte conducteur en remplissant le fomulaire
		suivant</p>
	<br /> <span class="required"> * Champ requis </span>
	<form:form modelAttribute="driver" method="post" action="inscriptionConducteur">

		<form:label path="nom"> Nom <span class="required"
				title="le nom est obligatoire">*</span>
		</form:label>
		<form:input path="nom" />
		<form:errors path="nom" />
		<br />

		<form:label path="prenom"> Prenom : <span
				class="required" title="ce champ est obligatoire">*</span>
		</form:label>
		<form:input path="prenom" />
		<form:errors path="prenom" />
		<br />
		
		
		<form:label path="login"> Login :<span class="required" title="ce champ est obligatoire">*</span> </form:label>
		<form:input path="login" />
		<form:errors path="login"/>
		
		<br />

		<form:label path="email"> Email :<span class="required"
				title="ce champ est obligatoire">*</span>
		</form:label>
		<form:input path="email" />
		<form:errors path="email" />
		<br />
		


  <label>Adresse <span class="required" title="ce champ est obligatoire">*</span></label>
  <input id="user_input_autocomplete_address" placeholder="Commencer à taper votre adresse...">
  <input type="hidden" id="street_number" name="street_number" disabled>
  <input type="hidden" id="route" name="route" disabled>
  <input type="hidden" id="locality" name="locality" disabled>
  <input type="hidden" id="country" name="country" disabled>


		<form:label path="motDePasse"> Mot de passe : <span
				class="required" title="ce champ est obligatoire">*</span>
		</form:label>
		<form:password path="motDePasse" />
		<form:errors path="motDePasse" />
		<br />

		<form:label path="confirmation"> Confirmation mot de passe :  <span
				class="required" title="ce champ est obligatoire">*</span>
		</form:label>
		<form:password path="confirmation" />
		<form:errors path="confirmation" />
		<br />
		
		<form:hidden id="lat" path="adresse.latitude" value=""/>
		<form:hidden id="lon" path="adresse.longitude" value=""/>
		<form:hidden id="tex" path="adresse.nom" value=""/>
		
		<form:checkbox path="condGV" value="true"/> J'accepte les conditions générales de ventes <span class="required" title="ce champ est obligatoire">*</span>
		
		<div style="backgound-color:red"><input type="submit" value="Devenir conducteur" /></div>

	</form:form>
	
	
</div>
	
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

	        /* Appel au service de geocodage avec l'adresse en paramètre */
	        geocoder.geocode({
	            'address': address
	        }, function(results, status) {
	            /* Si l'adresse a pu être géolocalisée */
	            if (status == google.maps.GeocoderStatus.OK) {
	                /* Récupération de sa latitude et de sa longitude */
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


