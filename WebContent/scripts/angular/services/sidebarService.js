app.factory('sidebarService', [ '$http', function($http) {
	var exposedAPI = {
		getData : getData
	};

	return exposedAPI;

	function getData(topicId) {
		return $http.get('/WebProjekat/SidebarAPIServlet').success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
} ]);