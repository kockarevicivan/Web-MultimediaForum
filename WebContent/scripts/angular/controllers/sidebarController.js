app.controller('SidebarController', function($scope, $route, $routeParams, sidebarService) {
	
	sidebarService.getData().success(function(data){
		$scope.data = data;
	});
});