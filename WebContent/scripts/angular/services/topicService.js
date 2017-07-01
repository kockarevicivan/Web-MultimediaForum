app.factory('topicService', [ '$http', function($http) {
	var exposedAPI = {
		getData : getData
	};

	return exposedAPI;

	function getData(topicId) {
		return $http.get('/WebProjekat/TopicAPIServlet?topicId=' + sanitize(topicId)).success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
} ]);