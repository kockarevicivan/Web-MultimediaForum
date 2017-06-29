var app = angular.module('webForumApp', ['ngRoute']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      controller: "HomeController",
      templateUrl: "/WebProjekat/scripts/angular/views/home.html"
    })
    .when('/topic/:topicId', {
      controller: "TopicController",
      templateUrl: "/WebProjekat/scripts/angular/views/topic.html"
    })
    .otherwise({
      redirectTo: '/'
    });
});