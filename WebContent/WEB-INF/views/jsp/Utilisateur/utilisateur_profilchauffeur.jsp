<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <div class="infoChauffeur">
    
    	<div class="photo-nom-prenom-notes-conducteur">
   			 	<img src ="" id ="photo-profil-chauffeur"/>
    			<p> ${conducteur.prenom} ${conducteur.nom} </p>
   			 	<p class="noteChauffeur"> note </p>
    	</div>
   								 
    
    <p> Nombre de courses : </p>
    
    <p> Commentaires : </p>
    
    </div>
    
 	<div class="demanderCourse">
    
    <input type="button" value="Demander course" id="butt-ask-course"/>
    
    </div>