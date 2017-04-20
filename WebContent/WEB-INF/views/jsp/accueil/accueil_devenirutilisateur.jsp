<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div class="client-inscription" style="width: 90%; margin-left: 10%">

	<h1 class="titrePage">Devenir partenaire WeMove</h1>
	<p>Creer un compte client en remplissant le fomulaire suivant</p>
	<br /> 

	<form:form method="post" action="inscriptionUtilisateur"
		modelAttribute="user"  style="width: 60%; margin-left: 20%">

		<form:label path="nom" > Nom <span class="required"
				title="le nom est obligatoire">*</span>
		</form:label>
		<form:input path="nom"  STYLE="Text-ALIGN:center"  />
		<form:errors path="nom" />
		<br />

		<form:label path="prenom"> Prenom : <span
				class="required" title="ce champ est obligatoire">*</span>
		</form:label>
		<form:input path="prenom"  STYLE="Text-ALIGN:center"  />
		<form:errors path="prenom" />

		<form:label path="login"> Login :<span class="required"
				title="ce champ est obligatoire">*</span>
		</form:label>
		<form:input path="login"  STYLE="Text-ALIGN:center" />
		<form:errors path="login" />

		<br />


		<form:label path="email"> Email :<span class="required"
				title="ce champ est obligatoire">*</span>
		</form:label>
		<form:input path="email" STYLE="Text-ALIGN:center"  />
		<form:errors path="email" />

		<br />

		<form:label path="motDePasse"> Mot de passe : <span
				class="required" title="ce champ est obligatoire">*</span>
		</form:label>
		<form:password path="motDePasse"  STYLE="Text-ALIGN:center" />
		<form:errors path="motDePasse" />

		<br />

		<form:label path="confirmation"> Confirmation mot de passe :  <span
				class="required" title="ce champ est obligatoire">*</span>
		</form:label>
		<form:password path="confirmation" STYLE="Text-ALIGN:center"  />
		<form:errors path="confirmation" />

		<br />
		<input type="checkbox" id="test5" />
      	<label for="test5"> J'accepte les conditions générales de vente</label>
      	<form:hidden id="lat" path="condGV" value="" />
		<br />

		<p>* Champ requis </p>
		
		<br />
		<input  id="butt-ask-course" type="submit" value="Devenir utilisateur"   class="btn-large waves-effect waves-light teal lighten-1"/>

	</form:form>




</div>



