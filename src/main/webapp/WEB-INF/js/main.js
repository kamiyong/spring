console.log("get in.");

window.onload = function () {
	console.log("This is main.js from outside.");

	function $(id) {
		return document.getElementById(id);
	}

	var show = $("show");

	show.onclick = function () {
		console.log("Show click.");
		show.style.border = "3px solid green";
	}

	var query = $("query");

	query.onclick = function () {
		console.log("query data.");
		var url = "/spring/role/getAllRole";

		var ajax = new XMLHttpRequest();
		ajax.open("GET", url, true);

		
		ajax.onreadystatechange = function () {
			console.log("readyState: ", ajax.readyState);
			console.log("status: ", ajax.status);
			if (ajax.readyState == 4 && ajax.status == 200) {
				var text = ajax.responseText;
				var json = JSON.parse(text);
				console.log(json);
			} else {
				console.log("Failed to query data.");
			}
		}
		ajax.send();

	}
}