app.factory('homeService', [ '$http', function($http) {
	var exposedAPI = {
		getHomeData : getHomeData,
		openSubforum : openSubforum,
		unfollowSubforum : unfollowSubforum,
		openTopic : openTopic,
		unsaveTopic : unsaveTopic,
		openComment : openComment,
		unsaveComment : unsaveComment,
		openMessage : openMessage,
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
	function openSubforum(subforumId) {
		alert('OPEN subforum: ' + subforumId)
	}

	function unfollowSubforum(subforumId) {
		alert('UNFOLLOW subrofum: ' + subforumId)
	}

	// Topic actions
	function openTopic(topicId) {
		alert('OPEN topic: ' + topicId)
	}

	function unsaveTopic(topicId) {
		alert('UNSAVE topic: ' + topicId)
	}
	
	// Comment actions
	function openComment(commentId) {
		alert('OPEN comment: ' + commentId)
	}
	
	function unsaveComment(commentId) {
		alert('UNSAVE comment: ' + commentId)
	}
	
	// Message actions
	function openMessage(messageId) {
		alert('OPEN message: ' + messageId)
	}
	
	function deleteMessage(messageId) {
		alert('DELETE message: ' + messageId)
	}
} ]);