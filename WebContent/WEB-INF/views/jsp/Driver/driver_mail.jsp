<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Courses</h1>

<p>Courses non confirmées</p>

<ul class="listeNotifications">
	<c:forEach var="item" items="${listeTrajets}">
		<c:if test="${item.getStatus()==1}">
			<li>${item.dateDuTrajet}-Commentaire de l'utilisateur :
				${item.getCommentaire()} <i id="boutton${item.getId_trajet()}"
				class="fa fa-search-plus fa-1x" style="color: #3498db"
				onclick="rechercheNotifications('${item.getId_trajet()}')"></i>
			</li>
			<div id="tohide" style="visibility: hidden">
				<ul class="listeNotif${item.getId_trajet()}"
					id="listeNotif${item.getId_trajet()}">
				</ul>
				<form id="bouttonaccept" action="#" style="">
					<input id="bouttonaccept" type="button" value="accepter" /> <input
						id="bouttonaccept" type="button" value="refuser" />
				</form>
			</div>
		</c:if>
	</c:forEach>
</ul>

<p>Courses confirmées</p>

<ul class="listeNotifications">
	<c:forEach var="item" items="${listeTrajets}">
		<c:if test="${item.getStatus()==2}">
			<li>${item.dateDuTrajet}-Commentaire de l'utilisateur :
				${item.getCommentaire()} <i id="boutton${item.getId_trajet()}"
				class="fa fa-search-plus fa-1x" style="color: #3498db"
				onclick="rechercheNotifications('${item.getId_trajet()}')"></i>
			</li>
			<div id="tohide" style="visibility: hidden">
				<ul class="listeNotif${item.getId_trajet()}"
					id="listeNotif${item.getId_trajet()}">
				</ul>
				<form id="bouttonaccept" action="#" style="">
					<input id="bouttonaccept" type="button" value="accepter" /> <input
						id="bouttonaccept" type="button" value="refuser" />
				</form>
			</div>
		</c:if>
	</c:forEach>
</ul>


<script src="<c:url value="/js/driver_mail.js" />"></script>