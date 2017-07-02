app.factory('userService', [ '$http', function($http) {
	var exposedAPI = {
		getAllUsers : getAllUsers,
		changeRole : changeRole
	};

	return exposedAPI;
	
	function getAllUsers() {
		return $http.get('/WebProjekat/AllUsersAPIServlet').success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
	
	function changeRole(user) {
		return $http.post('/WebProjekat/ChangeRoleAPIServlet', {
			userId : user.id,
			role: user.role
		}).success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
} ]);