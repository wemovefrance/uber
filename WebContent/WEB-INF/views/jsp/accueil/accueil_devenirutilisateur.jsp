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
		<form:errors path="nom" style="color:red"/>
		</form:label>
		<form:input path="nom"  STYLE="Text-ALIGN:center"  />
		<br />

		<form:label path="prenom"> Prenom : <span
				class="required" title="ce champ est obligatoire">*</span>
		<form:errors path="prenom" style="color:red"/>
		</form:label>
		<form:input path="prenom"  STYLE="Text-ALIGN:center"  />

		<form:label path="login"> Login :<span class="required"
				title="ce champ est obligatoire">*</span>
		<form:errors path="login" style="color:red"/>
		</form:label>
		<form:input path="login"  STYLE="Text-ALIGN:center" />

		<br />


		<form:label path="email"> Email :<span class="required"
				title="ce champ est obligatoire">*</span>
		<form:errors path="email" style="color:red"/>
		</form:label>
		<form:input path="email" STYLE="Text-ALIGN:center"  />

		<br />

		<form:label path="motDePasse"> Mot de passe : <span
				class="required" title="ce champ est obligatoire">*</span>
		<form:errors path="motDePasse" style="color:red" />
		</form:label>
		<form:password path="motDePasse"  STYLE="Text-ALIGN:center" />

		<br />

		<form:label path="confirmation"> Confirmation mot de passe :  <span
				class="required" title="ce champ est obligatoire">*</span>
		<form:errors path="confirmation" style="color:red" />
		</form:label>
		<form:password path="confirmation" STYLE="Text-ALIGN:center"  />

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



