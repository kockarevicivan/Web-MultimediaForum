<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Domain.Entities.User" %>

<%
	User current = (User)request.getSession().getAttribute("CurrentUser");
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>WebForum | Home</title>
		
		<link rel="stylesheet" href="css/atom.css" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<link rel="stylesheet" href="css/fontLoader.css" />
		
		<link rel="stylesheet" href="css/default.css" />
		
		<script src="scripts/jquery-3.2.1.min.js"></script>
		
		<script src="scripts/angular/angular.min.js"></script>
		<script src="scripts/angular/angular-route.min.js"></script>
		<script src="scripts/angular/angular-mocks.js"></script>
		<script src="scripts/angular/app.js"></script>

		<script src="scripts/angular/services/homeService.js"></script>
		<script src="scripts/angular/services/topicService.js"></script>

		<script src="scripts/angular/controllers/homeController.js"></script>
		<script src="scripts/angular/controllers/topicController.js"></script>
	</head>
	<body ng-app="webForumApp">
		<!--region Header-->
		<header class="jumbojet">
			<div class="centerHelper padding20 boxSizing">
				<a class="headerLogo" href="javascript:;"><span>Web</span>Forum</a>
				<form>
					<input class="boxSizing" type="text" placeholder="Pretraga..." />
					<button><i class="fa fa-search" aria-hidden="true"></i></button>
				</form>
				<a class="headerMenu" href="javascript:;"><%= current.username %> <i class="fa fa-sort-desc" aria-hidden="true"></i></a>
			</div>
		</header>
		<!--endregion-->
		
		<div ng-view></div>
		
		<script src="scripts/home.js"></script>
	</body>
</html>