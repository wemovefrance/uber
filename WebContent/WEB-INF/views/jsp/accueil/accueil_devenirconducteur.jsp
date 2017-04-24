<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="conducteur-inscription" style="width: 90%; margin-left: 10%">

	<h3 class="titrePage">Devenir partenaire WeMove</h3>
	<p>Creer un compte conducteur en remplissant le fomulaire suivant</p>
	<br /> <span class="required">  </span>
	<form:form modelAttribute="driver" method="post"
		action="inscriptionConducteur" style="width: 60%; margin-left: 20%">

		<form:label path="nom"> Nom <span class="required"
				title="le nom est obligatoire">*</span>
		<form:errors path="nom" style="color:red"/>  
		</form:label>
		<form:input path="nom"  STYLE="Text-ALIGN:center" />
		<form:errors class="error" path="nom" />
		<br />

		<form:label path="prenom"> Prenom : <span
				class="required" title="ce champ est obligatoire">*</span>
		<form:errors path="prenom" style="color:red"/>
		</form:label>
		<form:input path="prenom" STYLE="Text-ALIGN:center"  />
		<form:errors class="error" path="prenom" />
		<br />


		<form:label path="login"> Login :<span class="required"
				title="ce champ est obligatoire">*</span>
		<form:errors path="login" style="color:red" />
				
		</form:label>
		<form:input path="login"  STYLE="Text-ALIGN:center" />
		<form:errors class="error" path="login" />

		<br />

		<form:label path="email"> Email :<span class="required"
				title="ce champ est obligatoire">*</span>
		<form:errors path="email" style="color:red" />
		</form:label>
		<form:input path="email"  STYLE="Text-ALIGN:center" />
		<form:errors class="error" path="email" />
		<br />



		<label>Adresse <span class="required"
			title="ce champ est obligatoire">*</span>
		<form:errors path="adresse.nom" style="color:red" /></label>
		<input id="user_input_autocomplete_address"
			placeholder="Commencer a taper votre adresse..."  STYLE="Text-ALIGN:center" >
		<input type="hidden" id="street_number" name="street_number" disabled>
		<input type="hidden" id="route" name="route" disabled>
		<input type="hidden" id="locality" name="c" disabled>
		<input type="hidden" id="country" name="country" disabled>
		<form:errors class="error" path="adresse.nom" />

		<form:label path="motDePasse"> Mot de passe : <span
				class="required" title="ce champ est obligatoire">*</span>
		<form:errors path="motDePasse" style="color:red"  />
		</form:label>
		<form:password path="motDePasse" STYLE="Text-ALIGN:center"  />
		<form:errors class="error" path="motDePasse" />
		<br />

		<form:label path="confirmation"> Confirmation mot de passe :  <span
				class="required" title="ce champ est obligatoire">*</span>
		</form:label>
		<form:password path="confirmation"  STYLE="Text-ALIGN:center"  />
		<form:errors class="error" path="confirmation" />
		<br />

		<form:hidden id="lat" path="adresse.latitude" value="" />
		<form:hidden id="lon" path="adresse.longitude" value="" />
		<form:hidden id="tex" path="adresse.nom" value="" />
		
			<br />
		<input type="checkbox" id="test5" />
      	<label for="test5"> J'accepte les conditions générales de vente</label>
      	<form:hidden id="lat" path="condGV" value="" />
		<br />

		<p>* Champ requis </p>

		<div style="backgound-color: red">
			<input id="butt-ask-course" type="submit" value="Devenir conducteur" class="btn-large waves-effect waves-light teal lighten-1" />
		</div>

	</form:form>


</div>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c">
	
</script>

<script src="<c:url value="/js/autocomplete.js" />"></script>

<script type="text/javascript">
	function geocode() {
		var longitude = 0;
		var latitute = 0;
		var address = $('#street_number').val() + " " + $('#route').val()
				+ ", " + $('#locality').val() + ", " + $('#country').val();
		console.log(address);
		var geocoder = new google.maps.Geocoder();

		/* Appel au service de geocodage avec l'adresse en paramï¿½tre */
		geocoder.geocode({
			'address' : address
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

