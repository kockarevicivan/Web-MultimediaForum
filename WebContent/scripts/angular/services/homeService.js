app.factory('homeService', [ '$http', function($http) {
	var exposedAPI = {
		getHomeData : getHomeData,
		unfollowSubforum : unfollowSubforum,
		unsaveTopic : unsaveTopic,
		unsaveComment : unsaveComment,
		deleteMessage : deleteMessage
	};

	return exposedAPI;

	function getHomeData() {
		return $http.get('/WebProjekat/HomeAPIServlet').success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}

	// Subforum actions
	function unfollowSubforum(subforumId) {
		alert('UNFOLLOW subrofum: ' + subforumId)
	}

	// Topic actions
	function unsaveTopic(topicId) {
		alert('UNSAVE topic: ' + topicId)
	}
	
	// Comment actions
	function unsaveComment(commentId) {
		alert('UNSAVE comment: ' + commentId)
	}
	
	// Message actions
	function deleteMessage(messageId) {
		alert('DELETE message: ' + messageId)
	}
} ]);