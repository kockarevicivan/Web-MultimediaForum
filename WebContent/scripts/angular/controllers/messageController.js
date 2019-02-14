app.controller('MessageController', function($scope, $route, $routeParams, messageService) {
	
	if($routeParams.messageId) {
		messageService.getData($routeParams.messageId).success(function(data){
			$scope.data = data;
		});
	}
	
	messageService.getNewMessageData().success(function(data){
		$scope.users = data;
	});
	
	$scope.submitNewMessage = function() {
		if(!$scope.form.recipientId) {
			$scope.form.recipientId = $('#recipientIdHidden').val();
		}
		
		messageService.submitNewMessage($scope.form).success(function(data){
			displayToast(data);
		});
	}
});