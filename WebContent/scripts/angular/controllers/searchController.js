app.controller('SearchController', function($scope, $rootScope, $location, $route, $routeParams, searchService) {
	
	$scope.searchData = $rootScope.searchData;
	
	$scope.submitSearch = function() {
		searchService.submitSearch($scope.form).success(function(data){
			$rootScope.searchData = data;
			$scope.searchData = data;
			$location.path('/searchResults');
		});
	}
});