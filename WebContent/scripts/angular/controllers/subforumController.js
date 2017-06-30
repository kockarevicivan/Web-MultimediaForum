app.controller('SubforumController', function($scope, $route, $routeParams, subforumService) {
	
	if($routeParams.subforumId) {
		subforumService.getData($routeParams.subforumId).success(function(data){
			$scope.data = data;
		});
	}
	
	subforumService.getAllSubforums().success(function(data){
		$scope.allSubforums = data;
	});
});