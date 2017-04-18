<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<p> <c:out value="${utilisateur.prenom}"/> Voici les informations relatives a votre compte </p>

<div id="formulaire">

<form:form modelAttribute="utilisateurUpdate" action="gestionprofil" method="post">


	<form:label path="nom"> Nom <span class="required" title="le nom est obligatoire">*</span> </form:label>
 	<form:input path="nom" value = "${utilisateur.nom}"  STYLE="Text-ALIGN:center" />
 	<form:errors class="error" path="nom"/>

 	<br />
	
 	<form:label path="prenom"> Prenom : <span class="required" title="ce champ est obligatoire">*</span></form:label>
 	<form:input path="prenom" value = "${utilisateur.prenom}"  STYLE="Text-ALIGN:center" />
 	<form:errors class="error" path="prenom"/>

	
 	<form:label path="login"> Login :<span class="required" title="ce champ est obligatoire">*</span> </form:label>
 	<form:input  path="login" value = "${utilisateur.login}"  STYLE="Text-ALIGN:center" />
 	<form:errors class="error" path="login"/>

 <br />
	
 	<form:label path="email"> Email :<span class="required" title="ce champ est obligatoire">*</span> </form:label>
 	<form:input path="email" value = "${utilisateur.email}"  STYLE="Text-ALIGN:center" />
 	<form:errors class="error" path="email"/>


 <br />
 
 
	<form:label path="motDePasse"> Mot de passe :  <span class="required" title="ce champ est obligatoire">*</span> </form:label>
	<form:password path="motDePasse" value = "${utilisateur.motDePasse}"  STYLE="Text-ALIGN:center" />
	<form:errors class="error" path="motDePasse"/>
		
	<br />
 	
	<form:label path="confirmation"> Confirmation :  <span class="required" title="ce champ est obligatoire">*</span> </form:label>
	<form:password path="confirmation"  value = "${utilisateur.motDePasse}"  STYLE="Text-ALIGN:center" />
	<form:errors class="error" path="confirmation"/>
		
	<br />
	
	<form:hidden id="lat" path="adresse.latitude" value=""/>
		<form:hidden id="lon" path="adresse.longitude" value=""/>
 	
 	<input type="submit" class="bouttonmenuaccueil"  id="butt-submit" value="Mise a jour de mon profil" />
 	<br /> 
	<span class="message"> <c:out value="${message}"/></span> 	
	
 
</form:form>


 
 </div>