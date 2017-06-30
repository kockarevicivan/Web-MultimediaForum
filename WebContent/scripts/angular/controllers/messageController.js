app.controller('MessageController', function($scope, $route, $routeParams, messageService) {
	
	if($routeParams.messageId) {
		messageService.getData($routeParams.messageId).success(function(data){
			$scope.data = data;
		});
	}
});