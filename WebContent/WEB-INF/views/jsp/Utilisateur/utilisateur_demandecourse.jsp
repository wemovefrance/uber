<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
    <div class="photo-nom-prenom-notes-conducteur">
   			 	<img src ="" id ="photo-profil-chauffeur"/>
    			<p> ${conducteur.prenom} ${conducteur.nom} </p>
   			 	<p class="noteChauffeur"> note </p>
    </div>
    
    <input type= "button" id="butt-consult-conducteur" value="Consulter profil"/>
    
    <form:form modelAttribute="trajet" action ="" method="post">
    
<%--     		<form:label path="nomCourse"> Nom de maCourse <span class="required" title="champ obligatoire">*</span></form:label>
    		<form:input path="nomCourse" />
    		<form:errors path="nomCourse" /> 
    		
    		<label for="dateCourse"> Programmer ma course <span class="required" title="champ obligatoire">*</span></label>
    		<input type="date" id="dateCourse" name="dateCourse" />	
    
    		<input type="submit" value="Demander course"/>  --%>
    		
    </form:form>  
    
    