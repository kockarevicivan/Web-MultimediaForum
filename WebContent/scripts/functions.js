function sanitize(raw) {
	return raw.replace("-", "%20");
}

function displayToast(data) {
	alert(data.message);
}