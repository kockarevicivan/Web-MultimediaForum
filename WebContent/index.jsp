<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Domain.Entities.User" %>

<%
	User current = (User)request.getSession().getAttribute("CurrentUser");
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>WebForum | Home</title>

<link rel="stylesheet" href="css/index.css" />

<script src="scripts/jquery-3.2.1.min.js"></script>

<script src="scripts/angular/angular.min.js"></script>
<script src="scripts/angular/angular-route.min.js"></script>
<script src="scripts/angular/angular-mocks.js"></script>
<script src="scripts/angular/app.js"></script>

<script src="scripts/angular/services/homeService.js"></script>

<script src="scripts/angular/controllers/homeController.js"></script>

</head>
<body ng-app="webForumApp">
	<h1><%= current.firstName + " " + current.lastName + " - " + current.dateRegistered %></h1>
	<h2>#<%= current.username %></h2>
	<h3><%= current.email %></h3>
	<h4><%= current.telephoneNo %></h4>
	
	<main ng-controller="HomeController">
		<section>
			<h3>Followed subforums:</h3>
			<div class="itemWrapper" ng-repeat="subforum in data.followedSubforums" >
				<h4>{{ subforum.name }}</h4>
				<h5>{{ subforum.description }}</h5>
			</div>
		</section>
		
		<section>
			<h3>Saved topics:</h3>
			
			<div class="itemWrapper" ng-repeat="topic in data.savedTopics" >
				<h4>{{ topic.name }}</h4>
				<h5>{{ topic.content }}</h5>
			</div>
		</section>
		
		<section>
			<h3>Saved comments:</h3>
			
			<div class="itemWrapper" ng-repeat="comment in data.savedComments" >
				<h4>{{ comment.content }}</h4>
			</div>
		</section>
	</main>
</body>
</html>