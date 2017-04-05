<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
<link href="<c:url value="/css/materialize.css" />" rel="stylesheet">
<link href="<c:url value="/css/materialize.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/theme.css" />" rel="stylesheet">
<script src="<c:url value="/js/jmaterialize.js" />"></script>
<script src="<c:url value="/js/materialize.min.js" />"></script>
<script src="<c:url value="/js/googlemapapi.js" />"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<!-- Materialize -->
<title><tiles:insertAttribute name="title" /></title>

</head>

<body>
	<tiles:insertAttribute name="navigation" />
	<table>
		<tr>
			<th id="bodyaccueil"><tiles:insertAttribute name="body" /></th>
			<th id="menu"><tiles:insertAttribute name="menu" /></th>
		</tr>
	</table>
	<p class="footer">
		<tiles:insertAttribute name="footer" />
	</p>
</body>
</html>
