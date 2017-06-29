angular.module( 'directives', [] ).directive( 'comment', function () {
  return {
    restrict: 'E', // allow as an element; the default is only an attribute
    scope: {       // create an isolate scope
      comment: '='  // map the var in the shouts attribute to this scope
    },
    templateUrl: '/WebProjekat/scripts/angular/views/components/comment.html', // load the template file
    controller: function ( $scope ) {
      $scope.comment = commentModel;
    }
  };
});