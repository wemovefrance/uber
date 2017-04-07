var options = {
  enableHighAccuracy: true,
  timeout: 5000,
  maximumAge: 0
};

function success(pos) {
  var crd = pos.coords;
  console.log('Your current position is:');
  console.log(`Latitude : ${crd.latitude}`);
  sessionStorage.setItem("latitude",crd.latitude);
  console.log(`Longitude: ${crd.longitude}`);
  sessionStorage.setItem("longitude",crd.longitude);
  console.log(`More or less ${crd.accuracy} meters.`);
  console.log(`-------------------------------`);
};

function error(err) {
  console.warn(`ERROR(${err.code}): ${err.message}`);
};
function repeatResearchPos(){
	setInterval('navigator.geolocation.getCurrentPosition(success)',5000);
};