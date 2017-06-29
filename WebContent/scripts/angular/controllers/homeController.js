app.controller('HomeController', function($scope, $route, $routeParams, homeService) {

	homeService.getHomeData().success(function(data){
		$scope.data = data;
	});
	
	// Subforum actions
	$scope.unfollowSubforum = function(subforumId) {
		homeService.unfollowSubforum(subforumId);
	};
	
	// Topic actions
	$scope.unsaveTopic = function(topicId) {
		homeService.unsaveTopic(topicId);
	};
	
	// Comment actions
	$scope.unsaveComment = function(commentId) {
		homeService.unsaveComment(commentId);
	};
	
	// Message actions
	$scope.deleteMessage = function(messageId) {
		homeService.deleteMessage(messageId);
	};
});