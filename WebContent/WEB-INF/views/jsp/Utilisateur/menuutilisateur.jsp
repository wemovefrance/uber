<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<i class="fa fa-user-circle-o fa-5x"></i>
<p> Bonjour <c:out value="${utilisateur.login}"/> </p>
<p>  </p>
<form action="gestionprofil">
	<input class="bouttonmenuaccueil" type="submit" value="Gestion du profil">
</form>
<p><a href="monprofil"><i class="fa fa-home fa-5x" style="color:#3498db"></i></a></p>
<p><a href="monprofil"><i class="fa fa-map-o fa-5x" style="color:#3498db"></i></a></p>
<p><a href="notifications"><i class="fa fa-envelope-o fa-5x" style="color:#3498db"></i></a></p>
<p><a href="deconnexion"><i class="fa fa-times fa-3x" style="color:#3498db"> </i></a>												
