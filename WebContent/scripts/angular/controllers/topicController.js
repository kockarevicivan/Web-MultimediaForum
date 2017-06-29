app.controller('TopicController', function($scope, $route, $routeParams, topicService) {
	
	topicService.getData($routeParams.topicId).success(function(data){
		$scope.data = data;
	});
});