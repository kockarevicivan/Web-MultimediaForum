app.factory('subforumService', [ '$http', function($http) {
	var exposedAPI = {
		getData : getData,
		getAllSubforums : getAllSubforums
	};

	return exposedAPI;

	function getData(subforumId) {
		return $http.get('/WebProjekat/SubforumAPIServlet?subforumId=' + sanitize(subforumId)).success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
	
	function getAllSubforums() {
		return $http.get('/WebProjekat/AllSubforumsAPIServlet').success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
} ]);