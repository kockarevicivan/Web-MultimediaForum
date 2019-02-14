app.controller('UserController', function($scope, $route, $routeParams, userService) {
	
	$scope.roles = [
		{
			id: '0',
			name: 'Standard user'
		},
		{
			id: '1',
			name: 'Moderator'
		},
		{
			id: '2',
			name: 'Administrator'
		}
	];
	
	userService.getAllUsers().success(function(data){
		$scope.allUsers = data;
	});
	
	$scope.changeRole = function(user) {
		userService.changeRole(user).success(function(data){
			displayToast(data);
		});
	}
});