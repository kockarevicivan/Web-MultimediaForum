app.factory('messageService', [ '$http', function($http) {
	var exposedAPI = {
		getData : getData,
		getNewMessageData : getNewMessageData,
		submitNewMessage : submitNewMessage,
	};

	return exposedAPI;

	function getData(messageId) {
		return $http.get('/WebProjekat/MessageAPIServlet?messageId=' + sanitize(messageId)).success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
	
	function getNewMessageData() {
		return $http.get('/WebProjekat/NewMessageAPIServlet').success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
	
	function submitNewMessage(data) {		
		return $http.post('/WebProjekat/NewMessageAPIServlet', data).success(function(data) {
			return data;
		}).error(function(err) {
			return err;
		});
	}
} ]);