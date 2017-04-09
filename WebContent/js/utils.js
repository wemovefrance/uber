//NE PAS OUBLIER D'INCLURE jquery avant d'incluse ce fichier

//Requête à utiliser en mode GET
//Sur un contrôleur qui renvoie un réponse en JSON
function getUrl(url, cb) {
	$.get( url )
	.done(function(dataReponse) {
		alert( "success" );
		//Voir dans la console la réponse
		console.log( dataReponse );
		//Appel du callback sur la réponse
		if(typeof cb === "function") {
			cb(dataReponse);
		}
	})
	.fail(function() {
		alert( "error" );
	})
	.always(function() {
		//alert( "complete" );
	});
}


//Requête à utiliser en mode POST
//Sur un contrôleur qui renvoie un réponse en JSON
function postUrl(url, dataPost, cb) {
	$.post(url, dataPost)
	.done(function(dataReponse) {
		alert( "success" );
		//Voir dans la console la réponse
		console.log( dataReponse );
		//Appel du callback sur la réponse
		if(typeof cb === "function") {
			cb(dataReponse);
		}
	})
	.fail(function() {
		alert( "error" );
	})
	.always(function() {
		//alert( "complete" );
	});
}

/*
//CODE DES EXEMPLES A UTILISER ET A MODIFIER SI BESOIN
//ET A METTRE DANS UN AUTRE FICHIER JS

//Exemple pour récupérer la liste des conducteurs
//avec la méthode GET 
//
getUrl("/recupererListeConducteurs", function(dataReponse) {

	//Affiche le tableau de conducteur [{"name" : "Dupond", "voiture": "audi A3"}, {"name" : "Martin", "voiture": "mercedes class C"}]
	console.log(dataReponse); 

	//Affiche un conducteur {"name" : "Dupond", "voiture": "audi A3"}
	console.log(dataReponse[0]); 
});


//Exemple pour créer une commande
//avec la méthode POST
//
var dataPost = {"idConducteur" : 5, "idPassager": 7, "depart" : {"lat" : 123, "lng" : 123}, "arrivee" : {"lat" : 456, "lng" : 456} }
postUrl("/creerCommande", dataPost, function(dataReponse) {

	//Affiche {"status" : "OK"}
	console.log(dataReponse); 
});


*/
