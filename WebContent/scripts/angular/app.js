var app = angular.module('webForumApp', ['ngRoute'], function($httpProvider){
	// Use x-www-form-urlencoded Content-Type
	  $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';

	  /**
	   * The workhorse; converts an object to x-www-form-urlencoded serialization.
	   * @param {Object} obj
	   * @return {String}
	   */ 
	  var param = function(obj) {
	    var query = '', name, value, fullSubName, subName, subValue, innerObj, i;

	    for(name in obj) {
	      value = obj[name];

	      if(value instanceof Array) {
	        for(i=0; i<value.length; ++i) {
	          subValue = value[i];
	          fullSubName = name + '[' + i + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value instanceof Object) {
	        for(subName in value) {
	          subValue = value[subName];
	          fullSubName = name + '[' + subName + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value !== undefined && value !== null)
	        query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
	    }

	    return query.length ? query.substr(0, query.length - 1) : query;
	  };

	  // Override $http service's default transformRequest
	  $httpProvider.defaults.transformRequest = [function(data) {
	    return angular.isObject(data) && String(data) !== '[object File]' ? param(data) : data;
	  }];
});

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