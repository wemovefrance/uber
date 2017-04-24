<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<i class="fa fa-user-circle-o fa-5x" style="color:black"></i>

<p style="color:black"> Bonjour <c:out value="${utilisateur.login}"/> </p>
<p>  </p>
<form action="gestionprofil">
	<input class="btn-large waves-effect waves-light teal lighten-1" type="submit" value="Gestion du profil"  style="font-weight: normal;">
</form>
<!-- <p><a href="monprofil"><i class="fa fa-home fa-5x" style="color:#3498db"></i></a></p>
<p><a href="notifications"><i class="fa fa-envelope-o fa-5x" style="color:#3498db"></i></a></p>
<p><a href="deconnexion"><i class="fa fa-power-off fa-3x" style="color:#3498db"> </i></a>												
 -->