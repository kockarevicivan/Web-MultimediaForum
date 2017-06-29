app.controller('HomeController', ['$scope', 'homeService', function($scope, homeService) {
	homeService.getHomeData().success(function(data){
		$scope.data = data;
	});
	
	// Subforum actions
	$scope.openSubforum = function(subforumId) {
		homeService.openSubforum(subforumId);
	};
	
	$scope.unfollowSubforum = function(subforumId) {
		homeService.unfollowSubforum(subforumId);
	};
	
	// Topic actions
	$scope.openTopic = function(topicId) {
		homeService.openTopic(topicId);
	};
	
	$scope.unsaveTopic = function(topicId) {
		homeService.unsaveTopic(topicId);
	};
	
	// Comment actions
	$scope.openComment = function(commentId) {
		homeService.openComment(commentId);
	};
	
	$scope.unsaveComment = function(commentId) {
		homeService.unsaveComment(commentId);
	};
	
	// Message actions
	$scope.openMessage = function(messageId) {
		homeService.openMessage(messageId);
	};
	
	$scope.deleteMessage = function(messageId) {
		homeService.deleteMessage(messageId);
	};
}]);