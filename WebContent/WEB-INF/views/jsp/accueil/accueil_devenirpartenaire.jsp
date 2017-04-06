<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


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
	
	<form:form id="utilisateur" method="post" action="inscriptionUtilisateur">

		<form:label path="nom"> Nom <span class="required" title="le nom est obligatoire">*</span></form:label>
		<input name="nom" id="nom" type="text"/>
		
		<br />

		<label for="prenom"> Prenom : <span class="required" title="ce champ est obligatoire">*</span></label>
		<input name="prenom" id="prenom" type="text" />
		
		<br />

		<label for="email"> Email :<span class="required" title="ce champ est obligatoire">*</span> </label>
		<input name="email" id="email" type="text" />
		
		<br />

		<label for="motDePasse"> Mot de passe : <span class="required" title="ce champ est obligatoire">*</span></label>
		<input name="motDePasse" id="motDePasse" type="password" />
		
		<br />

		<label for="confirmation"> Confirmation mot de passe :  <span class="required" title="ce champ est obligatoire">*</span> </label>
		<input name="confirmation" id="confirmation" type="password"/>
		
		<br />

		<label for="dateNaissance"> Date de naissance : <span class="required" title="ce champ est obligatoire">*</span>
		</label>
		<input type="date" name="dateNaissance" id="dateNaissance" />

		<br />

		<label for="adresse"> Adresse : <span class="required" title="ce champ est obligatoire">*</span></label>
		<input name="adresse" id="adresse" type="text" />
		<br />
		
		<label for="noTelpehone"> Télépgone : <span class="required" title="ce champ est obligatoire">*</span></label>
		<input name="noTelpehone" id="noTelpehone" type="text" />
	
		<br />

		<label for="catSP"> Catégorie socio-professionnelle : </label>
		<input name="catSP"  id="catSP" type="text"/>
		
		<br />

		<input type="checkbox" name="conditionGeneraleDeVente" id="conditionGeneraleDeVente" value="1" unchecked/> J'accepte les conditions générales de ventes <span class="required" title="ce champ est obligatoire">*</span> 
 
		<input type="submit" value="Devenir partenaire" />

	</form:form>
</div>


<div class="conducteur-inscription">

	<p>Créer un compte conducteur WeMove en remplissant le fomulaire suivant</p>
	<br /> 
	
	<span class="required"> * Champ requis </span>
	
	<form id="conducteur" method="post" action="InscriptionConducteur">

		<label for="nom"> Nom <span class="required" title="le nom est obligatoire">*</span></label>
		<input name="nom" id="nom" type="text"/>
		<
		<br />

		<label for="prenom"> Prenom : <span class="required" title="ce champ est obligatoire">*</span></label>
		<input name="prenom" id="prenom" type="text" />
		
		<br />

		<label for="email"> Email :<span class="required" title="ce champ est obligatoire">*</span> </label>
		<input name="email" id="email" type="text" />
		
		<br />

		<label for="motDePasse"> Mot de passe : <span class="required" title="ce champ est obligatoire">*</span></label>
		<input name="motDePasse" id="motDePasse" type="password" />
		
		<br />

		<label for="confirmation"> Confirmation mot de passe :  <span class="required" title="ce champ est obligatoire">*</span> </label>
		<input name="confirmation" id="confirmation" type="password"/>
		
		<br />

		<label for="dateNaissance"> Date de naissance : <span class="required" title="ce champ est obligatoire">*</span>
		</label>
		<input type="date" name="dateNaissance" id="dateNaissance" />

		<br />

		<label for="adresse"> Adresse : <span class="required" title="ce champ est obligatoire">*</span></label>
		<input name="adresse" id="adresse" type="text" />
		<br />
		
		<label for="noTelpehone"> Télépgone : <span class="required" title="ce champ est obligatoire">*</span></label>
		<input name="noTelpehone" id="noTelpehone" type="text" />
	
		<br />

		<label for="catSP"> Catégorie socio-professionnelle : </label>
		<input name="catSP"  id="catSP" type="text"/>
		
		<br />

		<input type="checkbox" name="conditionGeneraleDeVente" id="conditionGeneraleDeVente" value="1" unchecked/> J'accepte les conditions générales de ventes <span class="required" title="ce champ est obligatoire">*</span> 
 
		<input type="submit" value="Devenir partenaire" />
	
</form>


</div>

