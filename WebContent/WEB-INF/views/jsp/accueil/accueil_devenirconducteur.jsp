<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1 class="titrePage"> Devenir partenaire </h1>

    <div class="conducteur-inscription">

	<p>Créer un compte conducteur WeMove en remplissant le fomulaire
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
		
		
<!-- 		 -->
		


<!--  -->


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
		
		<form:hidden id="lat" path="adresse.latitude" value="40"/>
		<form:hidden id="lon" path="adresse.longitude" value="35"/>
		
		<input type="checkbox" name="conditionGeneraleDeVente" id="conditionGeneraleDeVente" value="1" checked /> J'accepte les conditions générales de ventes <span class="required" title="ce champ est obligatoire">*</span>
		<input type="submit" value="Devenir conducteur" />

	</form:form>
	


<script type="text/javascript">
$(function(){
	var longitude = 0;
	var latitute = 0;

	$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c", function(data){
       	latitude = data.results[0].geometry.location.lat;
       	longitude = data.results[0].geometry.location.lng;
       	console.log("ok");
       	
	});	
	$("form").submit(function(e){
		/* var parameters = "origin=Boston,MA&destination=Concord,MA&sensor=false";
		//$.getJSON(escape("http://maps.googleapis.com/maps/api/directions/json?" + parameters), function(data){
		$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c", function(data){
	   
	       	
		});	 */
		$('#lat').val(latitude);
       	$('#lon').val(longitude);
       	$(this).submit();
	});
})
	
</script>



</div>