<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<link href="<c:url value="/css/materialize.css" />" rel="stylesheet">
<!--  <link href="<c:url value="/css/materialize.min.css" />" rel="stylesheet"> -->
<link href="<c:url value="/css/theme.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!--<script src="<c:url value="/js/jmaterialize.js" />"></script>-->
<!--<script src="<c:url value="/js/materialize.min.js" />"></script>--> 
<!-- <script src="<c:url value="/js/googlemapapi.js" />"></script> -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="<c:url value="/js/gestioncartejquery.js" />"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">

<title><tiles:insertAttribute name="title" /></title>
    
</head>

<body>
	<tiles:insertAttribute name="navigation" />
	<table width="100%">
		<tr>
			<th width="80%" class="bodyaccueil"><tiles:insertAttribute name="body" /></th>
			<th id="menu" width="20%"><tiles:insertAttribute name="menu" /></th>
		</tr>
	</table>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
