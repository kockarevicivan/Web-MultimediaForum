app.factory('profileService', [ '$http', function($http) {
	var exposedAPI = {
		getData : getData
	};

	return exposedAPI;

	function getData(topicId) {
		return $http.get('/WebProjekat/ProfileAPIServlet').success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
} ]);