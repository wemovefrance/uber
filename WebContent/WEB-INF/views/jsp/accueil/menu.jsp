<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test ="${ utilisateur != null }">

<c:set var ="url" value="utilisateur/monprofil"/>

<p> <a href="${url}"> <input type="button"  class="bouttonmenuaccueil" value="Retour à mon espace personnel"/>  </a> </p>

</c:if>
<h4 class="center black-text">Login</h4>

<c:if test ="${ conducteur != null }">

<c:set var ="url" value="conducteur/monprofil"/>

<p> <a href="${url}"> <input type="button"  class="bouttonmenuaccueil" value="Retour à mon espace personnel"/>  </a> </p>

</c:if>

<c:if test ="${ conducteur == null && utilisateur == null }">

<p> Connectez-vous pour accéder à votre espace personnel </p>

</c:if>



<form:form action="/frWeMove/accueil/connexion" method="post" modelAttribute="partner" >

	<form:label path="login" > Nom d'utilisateur : </form:label>
	 <form:errors class="error" path="login" style="color:red"/> 
	<form:input path="login"  class="accueilinput" STYLE="Text-ALIGN:center"/>
	<br />
	<form:label path="motDePasse" > Mot de passe : </form:label>
	<form:errors class="error" path="motDePasse" style="color:red"/> 
	<form:password class="accueilinput" path="motDePasse" STYLE="Text-ALIGN:center" />
	<br />
	
	<input class="btn-large waves-effect waves-light teal lighten-1" type="submit" value="Se connecter" >
	
</form:form>
<br />
<form action="/frWeMove/accueil/inscriptionUtilisateur">
	<input class="btn-large waves-effect waves-light teal lighten-1" type="submit" value="Inscription passager" style="font-weight: normal;">
</form>
<br />
<form action="/frWeMove/accueil/inscriptionConducteur">
	<input class="btn-large waves-effect waves-light teal lighten-1" type="submit" value="Inscription conducteur" style="font-weight: normal;">
</form>
