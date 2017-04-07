<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1 class="titrePage"> Devenir partenaire </h1>


<div class=buttons-type-inscription>

	<p>Créer un compte weMove</p>

	<input type="button" class="butt-typeInscription"
		value="Devenir client">
	<input type="button" class="butt-typeInscription" value="Devenir conducteur">
</div>

  
<div class="client-inscription">

	<p>Créer un compte client WeMove en remplissant le fomulaire suivant</p>
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


		<input type="checkbox" name="conditionGeneraleDeVente" id="conditionGeneraleDeVente" value="1" checked /> J'accepte les conditions générales de ventes <span class="required" title="ce champ est obligatoire">*</span> 
 		<br />
		<input type="submit" value="Devenir utilisateur" />

	</form:form>
	
</div>



