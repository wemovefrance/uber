<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<%-- <link href="<c:url value="/css/materialize.css" />" rel="stylesheet"> 
 <link href="<c:url value="/css/materialize.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet" --%><!-- 
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--   <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/> -->
	<!--<script src="<c:url value="/js/jmaterialize.js" />"></script>-->
	<!--<script src="<c:url value="/js/materialize.min.js" />"></script>-->
	<!-- <script src="<c:url value="/js/googlemapapi.js" />"></script> -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="<c:url value="/js/gestioncartejquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/update-profil-util.js"/>">
	
</script>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" /> -->

<title><tiles:insertAttribute name="title" /></title>


  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="/frWeMove/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="/frWeMove/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body id="bodyAll">
	<tiles:insertAttribute name="navigation" />
	

   <div class="section">
	<div class="container">
		<br>
		<br>
		
		<div class="row center" style="width: 60%; margin-left: 20%">
			<h5 class="center brown-text">
				<tiles:insertAttribute name="menu" />
			</h5>
		</div>
		<br>
		<br>
	   </div>
    </div>



	<div class="container">
		<div class="row center">
			<tiles:insertAttribute name="body" />
		</div>
	</div>

	<footer class="page-footer teal">
		<div class="container">

			<div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>

			<div class="footer-copyright">
				<div class="container">
					Adapted of template <a class="brown-text text-lighten-3"
						href="http://materializecss.com">Materialize</a>
				</div>
			</div>
	</footer>

	<!--  Scripts-->
	<script src="<c:url value="https://code.jquery.com/jquery-2.1.1.min.js"/>"></script>
	<script src="<c:url value="/js/materialize.js"/>"></script>
	<script src="<c:url value="/js/init.js"/>"></script>
	<script type="text/javascript" src="../js/materialize.min.js"></script>
	<script>
	 $( document ).ready(function() {
      $(".button-collapse").sideNav();
      
    });
	 
	
	 </script>
</body>
</html>
