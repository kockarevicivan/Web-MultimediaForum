app.controller('HomeController', ['$scope', 'homeService', function($scope, homeService) {
	homeService.success(function(data){
		$scope.data = data;
	});
}]);