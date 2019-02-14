app.controller('ProfileController', function($scope, $route, $routeParams, profileService) {
	profileService.getData().success(function(data){
		$scope.data = data;
	});
});