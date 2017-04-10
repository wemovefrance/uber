<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
   <div class=" info-trajets">
   <ul class="mesTrajets"> 
   
   <li> Bonjour ${partenaire.nom} ${partenaire.prenom} </li>
   <li> Dernier trajet : ${dernierTrajet.dateDuTrajet} </li>
   <li> prochain trajet : ${prochainTrajet.dateDuTrajet} </li>
   </ul>
   </div> 
   
   <div class="map"> </div>
   
   <input type="button" id="gestionTrajet" value =" Gestion d'un trajet"/>
   <input type="button" id="gestionTransaction" value =" Gestion transactions"/>