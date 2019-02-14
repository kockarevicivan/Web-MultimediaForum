app.directive('customComment', function () {
	
	return {
		templateUrl: '/WebProjekat/scripts/angular/views/components/comment.html',
		restrict: 'E',
		scope: {
			commentModel: '='
		}
	};
});