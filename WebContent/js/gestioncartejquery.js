// Position par défaut (Port de Marseille)

// var centerpos = new google.maps.LatLng(43.327469,5.358023) ;
// var map = new google.maps.Map(document.getElementById("map"), optionsGmaps);
/*var latlng;*/
var myKey = "AIzaSyBhHjZ-FFC3DuM36RLB6GRvs53eH26zY9c";
var map;
var markerPos;
var longitudes;
var latitudes;
var usernamesConducteurs ;
var gmarkers = [];
var label ;
var nn ;
/*
 * marker = new google.maps.Marker({ position: latlng, map: map, title:"Vous
 * êtes ici", icon: "fleche.png" });
 */
var options = {
	enableHighAccuracy : true,
	timeout : 5000,
	maximumAge : 0
};
/*
 * var optionsGmaps = { center:centerpos, mapTypeId:
 * google.maps.MapTypeId.ROADMAP, zoom: 15 };
 */
/*
 * function loadScript() { var script = document.createElement('script');
 * script.type = 'text/javascript'; script.src =
 * "https://maps.googleapis.com/maps/api/js?key=" + myKey +
 * "&sensor=false&callback=initialize"; document.body.appendChild(script); }
 */

function plotMarker(Lat, Long, Label) {
	markerPos = new google.maps.LatLng(Lat, Long);
	var marker = new google.maps.Marker({
		position : markerPos,
		map : map,
		title : Label,
	});
	gmarkers.push(marker);
	var infowindow = new google.maps.InfoWindow({
	    content: '<a href="/frWeMove/utilisateur/profilchauffeur?userId=' +userid+ '"> '+Label+' </a>'});
	var ttt = gmarkers[nn] ;
	ttt.addListener('click', function() {
	    infowindow.open(map, ttt);
	  });
}

function initMap() {
	
	map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : -34.397,
			lng : 150.644
		},
		zoom : 9
	});
	recoverPosition();
		for (nn = 0; nn < longitudes.length; nn++) {			
			label = usernamesConducteurs[nn] ;
			label = label.replace(']','');
			label = label.replace('[','');
			label = label.replace(' ','');			
			userid = userIdsConducteurs[nn] ;
			userid = userid.replace(']','');
			userid = userid.replace('[','');
			userid = userid.replace(' ','');
			Lat = latitudes[nn] ;
			console.log("Lat1="+Lat);
			Lat = Lat.replace(']','');
			Lat = Lat.replace('[','');
			Lat = Lat.replace(' ','');
			Lat=Number(Lat);
			console.log("Lat2="+Lat);
			Long = longitudes[nn] ;
			console.log("Long1="+Long);
			Long = Long.replace(']','');
			Long = Long.replace('[','');
			Long = Long.replace(' ','');
			Long=Number(Long);
			// plotMarker(Lat,Long, "test");
			console.log("Long2="+Long);
			console.log(Lat);
			console.log(Long);
			plotMarker(parseFloat(Lat), parseFloat(Long), label, userid);
		}
				/*
			markerPos = new google.maps.LatLng(Lat,Long);
			var marker = new
			  google.maps.Marker({ 
				  position: markerPos, 
				  map: map, 
				  title: label
			  });
			gmarkers.push(marker);
			var infowindow = new google.maps.InfoWindow({
				    content: label
			  });
			gmarkers[nn].addListener('click', function() {
				    infowindow.open(map, gmarkers[nn]);
				  });*/
	
		
	  // markerPos = new google.maps.LatLng(40,5);
		/*
	  markerPos = new google.maps.LatLng(43.5338335,5.509246999999999); 
	  var marker = new google.maps.Marker(
			  { position: markerPos, map: map, title:"Vous êtes ici"
	  });
*/
	var infoWindow = new google.maps.InfoWindow({
		map : map
	});

	// PERMET DE RECUPERER LA POSITION DU NAVIGATEUR
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = {
				lat : position.coords.latitude,
				lng : position.coords.longitude
			};
			infoWindow.setPosition(pos);
			infoWindow.setContent('Votre position');
			map.setCenter(pos);
		}, function() {
			handleLocationError(true, infoWindow, map.getCenter());
		});
	} else {
		// Browser doesn't support Geolocation
		handleLocationError(false, infoWindow, map.getCenter());
	}
};

// SI JE RECUPERE LA POSITION, ALORS J'EXECUTE CE CODE
function maPosition(position) {
	var crd = position.coords;
	var infopos = "test";
	console.log('Your current position is:');
	console.log(`Latitude : ${crd.latitude}`);
	sessionStorage.setItem("latitude", crd.latitude);
	console.log(`Longitude: ${crd.longitude}`);
	sessionStorage.setItem("longitude", crd.longitude);
	console.log(`More or less ${crd.accuracy} meters.`);
	console.log(`-------------------------------`);
	document.getElementById("infoposition").innerHTML = infopos;

	// Un nouvel objet LatLng pour Google Maps avec les paramètres de
	// position
	// latlng = new google.maps.LatLng(position.coords.latitude,
	// position.coords.longitude);
	/*
	 * var pos2 = new google.maps.LatLng(43.327469,5.358023) ; // latlng = new
	 * google.maps.LatLng(pos2.coords.latitude, pos2.coords.longitude); // Ajout
	 * d'un marqueur à la position trouvée var marker = new google.maps.Marker({
	 * position: pos2, map: map, title:"Vous êtes ici" }); /* // Permet de
	 * centrer la carte sur la position latlng map.panTo(latlng);
	 */
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow
			.setContent(browserHasGeolocation ? 'Erreur: Nous n\'avons pas réussi à vous trouver.'
					: 'Erreur: Votre navigateur ne supporte pas la géolocalisation.');
};

function error(err) {
	console.warn(`ERROR(${err.code}): ${err.message}`);
};

// Fonction de callback en cas d’erreur
function erreurPosition(error) {
	var info = "Erreur lors de la géolocalisation : ";
	switch (error.code) {
	case error.TIMEOUT:
		info += "Timeout !";
		break;
	case error.PERMISSION_DENIED:
		info += "Vous n’avez pas donné la permission";
		break;
	case error.POSITION_UNAVAILABLE:
		info += "La position n’a pu être déterminée";
		break;
	case error.UNKNOWN_ERROR:
		info += "Erreur inconnue";
		break;
	}
	document.getElementById("infoposition").innerHTML = info;
}


function recoverPosition() {
	latitudesAll = document.getElementById('latitudeshidden').value;
	latitudes = latitudesAll.split(',');
	longitudesAll = document.getElementById('longitudeshidden').value;
	longitudes = longitudesAll.split(',');
	usernamesConducteursAll = document.getElementById('usernameshidden').value;
	usernamesConducteurs = usernamesConducteursAll.split(',');
	userIdsConducteursAll = document.getElementById('userIdshidden').value;
	userIdsConducteurs = userIdsConducteursAll.split(',');
}
/*
 * function repeatResearchPos(){
 * setInterval('navigator.geolocation.getCurrentPosition(maPosition)',erreurPosition,5000); };
 */
navigator.geolocation.getCurrentPosition(maPosition);
