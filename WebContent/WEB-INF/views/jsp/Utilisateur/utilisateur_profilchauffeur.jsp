<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="infoChauffeur">
    
    	<div class="photo-nom-prenom-notes-conducteur">
   			 	<img src ="" id ="photo-profil-chauffeur"/>
    			<p> Profil conducteur de <c:out value="${conducteurOnClick.prenom}"/> <c:out value="${conducteurOnClick.nom}"/> </p>
   			 	<p class="noteChauffeur"> Note moyenne  </p>
    	</div>
   						
    <p> Nombre de courses : </p>
 
    <p> Commentaires : </p>
    
    </div>
    
 	<div class="demanderCourse">
    
    <form action ="demandecourse">
    <input type="submit" value="Demander course" id="butt-ask-course"/>
    </form>
    </div>