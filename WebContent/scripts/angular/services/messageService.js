app.factory('messageService', [ '$http', function($http) {
	var exposedAPI = {
		getData : getData
	};

	return exposedAPI;

	function getData(messageId) {
		return $http.get('/WebProjekat/MessageAPIServlet?messageId=' + sanitize(messageId)).success(function(data) {
			console.log(data);
			return data;
		}).error(function(err) {
			return err;
		});
	}
} ]);

function sanitize(raw) {
	return raw.replace("-", "%20");
}