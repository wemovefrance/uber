<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<i class="fa fa-user-circle-o fa-5x"></i>
<p> Bonjour <c:out value="${conducteur.prenom}" /> </p>
<p>  </p>
<form action="gestionprofil">
	<input class="bouttonmenuaccueil" type="submit" value="Gestion du profil"  style="font-weight: normal;">
</form>
<p><a href="monprofil"><i class="fa fa-home fa-5x" style="color:#3498db"></i></a></p>
<p><a href="carte"><i class="fa fa-map-o fa-5x" style="color:#3498db"></i></a></p>
<p><a href="drivergestionvehicule"><i class="fa fa-car fa-3x" style="color:#3498db"></i><i class="fa fa-plus fa-2x" style="color:#3498db"></i></a></p>
<p><a href="notifications"><i class="fa fa-envelope-o fa-5x" style="color:#3498db"></i></a></p>
<p><a href="deconnexion"><i class="fa fa-power-off fa-3x" style="color:#3498db"> </i></a>		
