<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<!-- Materialize -->
	
		<title> <tiles:insertAttribute name="title"/> </title>
	</head>
	
	<body>
		<tiles:insertAttribute name="navigation" />
		
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
		
		
	</body>
</html>