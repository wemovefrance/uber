<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1 class="titrePage"> Devenir partenaire WeMove </h1>
 
<div class="client-inscription">

	<p>Créer un compte client en remplissant le fomulaire suivant</p>
	<br /> 
	<span class="required"> * Champ requis </span>
	
	<form:form method="post" action="inscriptionUtilisateur" modelAttribute="user"  >

		<form:label path="nom"> Nom <span class="required" title="le nom est obligatoire">*</span> </form:label>
		<form:input path="nom"/>
		<form:errors path="nom"/>		
		<br />

		<form:label path="prenom"> Prenom : <span class="required" title="ce champ est obligatoire">*</span></form:label>
		<form:input path="prenom"/>
		<form:errors path="prenom"/>
		
		<form:label path="login"> Login :<span class="required" title="ce champ est obligatoire">*</span> </form:label>
		<form:input path="login" />
		<form:errors path="login"/>
		
		<br />
		

		<form:label path="email"> Email :<span class="required" title="ce champ est obligatoire">*</span> </form:label>
		<form:input path="email" />
		<form:errors path="email"/>
		
		<br />
		

		<form:label path="motDePasse"> Mot de passe : <span class="required" title="ce champ est obligatoire">*</span></form:label>
		<form:password path="motDePasse"/>
		<form:errors path="motDePasse"/>
		
		<br />
 
		<form:label path="confirmation"> Confirmation mot de passe :  <span class="required" title="ce champ est obligatoire">*</span> </form:label>
		<form:password path="confirmation"/>
		<form:errors path="confirmation"/>
		
		<br />
		
		<form:hidden id="lat" path="adresse.latitude" value=""/>
		<form:hidden id="lon" path="adresse.longitude" value=""/>
		<form:hidden id="tex" path="adresse.nom" value=""/>

		J'accepte les conditions générales de ventes <span class="required" title="ce champ est obligatoire">*</span>
		<form:checkbox id="checkbox" path="condGV"/>  
 		<br />
		<input type="submit" value="Devenir utilisateur" />

	</form:form>
	

	
	
</div>



