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
    .when('/subforum/:subforumId', {
      controller: "SubforumController",
      templateUrl: "/WebProjekat/scripts/angular/views/subforum.html"
    })
    .when('/subforums', {
      controller: "SubforumController",
      templateUrl: "/WebProjekat/scripts/angular/views/allSubforums.html"
    })
    .otherwise({
      redirectTo: '/'
    });
});