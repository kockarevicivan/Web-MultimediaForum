app.factory('searchService', [ '$http', function($http) {
	var exposedAPI = {
		submitSearch : submitSearch
	};
	
	return exposedAPI;
	
	function submitSearch(data) {		
		return $http.post('/WebProjekat/SearchAPIServlet', data).success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
} ]);