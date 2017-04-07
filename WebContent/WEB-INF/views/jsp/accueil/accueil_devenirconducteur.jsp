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


		<input type="checkbox" name="conditionGeneraleDeVente" id="conditionGeneraleDeVente" value="1" checked /> J'accepte les conditions générales de ventes <span class="required" title="ce champ est obligatoire">*</span>
		<input type="submit" value="Devenir conducteur" />

	</form:form>

<h1>Google Direction API Demo</h1>

<div id="test"> </div>

<button type="button" onclick="getDirections()">Get Directions</button>

<script type="text/javascript">
function getDirections() {
	var parameters = "origin=Boston,MA&destination=Concord,MA&sensor=false";
	//$.getJSON(escape("http://maps.googleapis.com/maps/api/directions/json?" + parameters), function(data){
	$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c", function(data){
       
		var longitude = 0;
		var latitute = 0;
       	latitude = data.results[0].geometry.location.lat;
       	longitude = data.results[0].geometry.location.lng;
       	console.log(latitude);
       	console.log(longitude);
	});
	

   		$.ajax({
   			var position = 'lat='+25+'&lon'+27;
		      type: "POST",
		      dataType : 'json',
		      url: "http://localhost:8080/frWeMove/accueil/inscriptionConducteur",
		      data: JSON.stringify(position),
		      success :function(result) {
		       // do what ever you want with data
		     }
   		})
}
	
</script>



</div>