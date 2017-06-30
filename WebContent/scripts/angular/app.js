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
    .when('/newTopic', {
      controller: "ProfileController",
      templateUrl: "/WebProjekat/scripts/angular/views/newTopic.html"
    })
    .when('/subforum/:subforumId', {
      controller: "SubforumController",
      templateUrl: "/WebProjekat/scripts/angular/views/subforum.html"
    })
    .when('/subforums', {
      controller: "SubforumController",
      templateUrl: "/WebProjekat/scripts/angular/views/allSubforums.html"
    })
    .when('/message/:messageId', {
      controller: "MessageController",
      templateUrl: "/WebProjekat/scripts/angular/views/message.html"
    })
    .when('/newMessage', {
      controller: "MessageController",
      templateUrl: "/WebProjekat/scripts/angular/views/newMessage.html"
    })
    .when('/editProfile', {
      controller: "ProfileController",
      templateUrl: "/WebProjekat/scripts/angular/views/editProfile.html"
    })
    .otherwise({
      redirectTo: '/'
    });
});