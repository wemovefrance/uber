<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<i class="fa fa-user-circle-o fa-3x" style="color:black"></i>
<p style="color:black"> Bonjour <c:out value="${conducteur.login}" /> </p>
<p style="font-size:70%"> <u>Nom</u> : <c:out value="${conducteur.nom}" /> </p>
<p style="font-size:70%"> <u>Prénom</u> : <c:out value="${conducteur.prenom}" /> </p>
<p style="font-size:70%"> <u>Contact</u> : <c:out value="${conducteur.email}" /> </p>
<!-- 
<form action="gestionprofil">
	<input class="btn-large waves-effect waves-light teal lighten-1" type="submit" value="Gestion du profil"  style="font-weight: normal; ">
</form> -->
<!-- <p><a href="monprofil"><i class="fa fa-home fa-5x" style="color:#3498db"></i></a></p>
<p><a href="carte"><i class="fa fa-map-o fa-5x" style="color:#3498db"></i></a></p> -->
<p style="color:#26a69a">Ajouter un vehicule : </p>
<p><a href="drivergestionvehicule"><i class="fa fa-car fa-2x" style="color:#26a69a"></i><i class="fa fa-plus fa-1x" style="color:#26a69a"></i></a></p>

<!-- <p><a href="notifications"><i class="fa fa-envelope-o fa-5x" style="color:#3498db"></i></a></p>
<p><a href="deconnexion"><i class="fa fa-power-off fa-3x" style="color:#3498db"> </i></a>		
  -->