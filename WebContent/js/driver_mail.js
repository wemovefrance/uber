var data;
function rechercheNotifications(id) {
	console.log("WAZAAAAAAAAAAAAA " + id);
	$.get("findnotifications", {
		"id_traj" : id
	}, function(data) {
		var ul = document.getElementById("listeNotif" + id);
		console.log(data);
		for (nn = 0; nn < data.length; nn++) {
			var li = document.createElement("li");
			li.appendChild(document.createTextNode(data));
			ul.appendChild(li);
		}
	});
	
	var boutton = document.getElementById("boutton"+id);
	boutton.style.visibility='hidden';
	var bouttonaccept = document.getElementById("bouttonaccept") ;
	boutton.style.visibility='visible';
	var tohideblock = document.getElementById("tohide") ;
	console.log(tohideblock);
	tohideblock.style.visibility='visible';
	
	// var ul = document.getElementById("listeNotif" + id);
	// var li = document.createElement("li");
	// li.appendChild(document.createTextNode(data));
	// ul.appendChild(li);

	//	
	// jQuery.ajax({
	// url: "findnotifications?id_traj="+id,
	// success: function (data) {
	// alert(data + "success");
	// },
	// error: function (data) {
	// alert(data + "error");
	// }
	// });

	// $.ajax({
	// url : 'findnotifications',
	// data : id,
	// success : function(data) {
	// console.log(data);
	// }
	// });
	//	
}
