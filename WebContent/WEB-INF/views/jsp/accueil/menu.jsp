<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test ="${ utilisateur != null }">

<c:set var ="url" value="utilisateur/monprofil"/>

<p> <a href="${url}"> <input type="button"  class="bouttonmenuaccueil" value="Retour à mon espace personnel"/>  </a> </p>

</c:if>


<c:if test ="${ conducteur != null }">

<c:set var ="url" value="conducteur/monprofil"/>

<p> <a href="${url}"> <input type="button"  class="bouttonmenuaccueil" value="Retour à mon espace personnel"/>  </a> </p>

</c:if>

<c:if test ="${ conducteur == null && utilisateur == null }">

<p> Connectez-vous pour accéder à votre epsace personnel </p>

</c:if>



<form:form action="/frWeMove/accueil/connexion" method="post" modelAttribute="partner">

	<form:label path="login" > Nom d'utilisateur : </form:label>
	<form:input path="login"  class="accueilinput"/>
	 <form:errors class="error" path="login"/> 
	<br />
	<form:label path="motDePasse" > Mot de passe : </form:label>
	<form:password class="accueilinput" path="motDePasse" />
	<form:errors class="error" path="motDePasse"/> 
	<br />
	
	<input class="bouttonmenuaccueil" type="submit" value="Se connecter" style="font-weight: normal;">
	
</form:form>

<form action="/frWeMove/accueil/inscriptionUtilisateur">
	<input class="bouttonmenuaccueil" type="submit" value="Inscription passager" style="font-weight: normal;">
</form>
<form action="/frWeMove/accueil/inscriptionConducteur">
	<input class="bouttonmenuaccueil" type="submit" value="Inscription conducteur" style="font-weight: normal;">
</form>
