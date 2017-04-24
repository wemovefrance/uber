<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Courses</h4>

<p class="titresDriverMap">---------------- Courses demandées non
	confirmées ----------------</p>

<ul class="listeNotifications">
	<c:forEach var="item" items="${listeTrajets}">
		<c:if test="${item.getStatut()==1}">
			<li>${item.getDateDuTrajet()}-${item.getDepart().getNom()} a
				${item.getArrivee().getNom()} <i id="boutton${item.getId_trajet()}"
				class="fa fa-search-plus fa-1x" style="color: #26a69a"
				onclick="rechercheNotifications('${item.getId_trajet()}')"></i>
			</li>
			<div id="tohide${item.getId_trajet()}" style="display: none">
				<form action="annulerCourse" method="post">
					<input type="hidden" name="idTraj" value="${item.getId_trajet()}" />
					<input id="bouttonaccept" type="submit" name="choix"
						value="annuler" class="btn-large waves-effect waves-light teal lighten-1"/>
				</form>
			</div>
		</c:if>
	</c:forEach>
</ul>

<p>---------------- Courses acceptées par le conducteur
	----------------</p>

<ul class="listeNotifications">
	<c:forEach var="item" items="${listeTrajets}">
		<c:if test="${item.getStatut()==2}">
			<li>${item.getDateDuTrajet()}-${item.getDepart().getNom()} a
				${item.getArrivee().getNom()} <i id="boutton${item.getId_trajet()}"
				class="fa fa-search-plus fa-1x" style="color: #26a69a"
				onclick="rechercheNotifications('${item.getId_trajet()}')"></i>
			</li>
			<div id="tohide${item.getId_trajet()}" style="display: none">
				<form action="annulerCourse" method="post">
					<input type="hidden" name="idTraj" value="${item.getId_trajet()}" />
					<input id="bouttonaccept" type="submit" name="choix"
						value="annuler" class="btn-large waves-effect waves-light teal lighten-1"/>
				</form>
			</div>
		</c:if>
	</c:forEach>
</ul>

<p>---------------- Courses annulées ----------------</p>

<ul class="listeNotifications">
	<c:forEach var="item" items="${listeTrajets}">
		<c:if test="${item.getStatut()==0}">
			<li>${item.getDateDuTrajet()}-${item.getDepart().getNom()} a
				${item.getArrivee().getNom()}
			</li>
		</c:if>
	</c:forEach>
</ul>


<script src="<c:url value="/js/driver_mail.js" />"></script>