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

		<script src="scripts/angular/controllers/homeController.js"></script>
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
		
		<!--region GrayTrack-->
		<div class="grayTrack jumbojet">
			<div class="centerHelper padding20 boxSizing">
				<a class="active" href="javascript:;" data-main-target="subforumsMain"><i class="fa fa-list-ul" aria-hidden="true"></i> Subforums</a>
				<a href="javascript:;" data-main-target="savedTopicsMain"><i class="fa fa-floppy-o" aria-hidden="true"></i> Saved topics</a>
				<a href="javascript:;" data-main-target="savedCommentsMain"><i class="fa fa-floppy-o" aria-hidden="true"></i> Saved comments</a>
				<a href="javascript:;" data-main-target="messagesMain"><i class="fa fa-envelope" aria-hidden="true"></i> Messages</a>
			</div>
		</div>
		<!--endregion-->
		
		<!--region Main-->
		<div class="centerHelper padding20 boxSizing" ng-controller="HomeController">
			<main class="subforumsMain" style="display: inline-block;" >
				<article class="mainItem jumbojet boxSizing" ng-repeat="subforum in data.followedSubforums" >
					<img class="verticalCenter" ng-src="{{ subforum.iconPath }}"/>
					<div class="forumInfoWrapper verticalCenter">
						<a href="javascript:;">{{ subforum.name }}</a>
						<span><i>{{ subforum.description }}</i></span>
					</div>
					
					<i title="Open" class="fa fa-eye verticalCenter" aria-hidden="true" ng-click="openSubforum(subforum.id)"></i>
					<i title="Unfollow" class="fa fa-times verticalCenter" aria-hidden="true" ng-click="unfollowSubforum(subforum.id)"></i>
					
				</article>
			</main>
			
			<main class="savedTopicsMain" >
				<article class="mainItem jumbojet boxSizing" ng-repeat="topic in data.savedTopics" >
					<img class="verticalCenter" ng-src="{{ topic.subforum.iconPath }}" />
					<div class="forumInfoWrapper verticalCenter">
						<a href="javascript:;">{{ topic.name }}</a>
						<span><i>{{ topic.content }}</i></span>
					</div>
					
					<i title="Open" class="fa fa-eye verticalCenter" aria-hidden="true" ng-click="openTopic(topic.id)"></i>
					<i title="Unsave" class="fa fa-times verticalCenter" aria-hidden="true" ng-click="unsaveTopic(topic.id)"></i>
					
				</article>
			</main>
			
			<main class="savedCommentsMain" >
				<article class="mainItem jumbojet boxSizing" ng-repeat="comment in data.savedComments" >
					<img class="verticalCenter" src="images/commentIcon.png"/>
					<div class="forumInfoWrapper verticalCenter">
						<a href="javascript:;">{{ comment.content }}</a>
						<span><i>{{ comment.author.username }} - {{ comment.dateCreated | date}}</i></span>
					</div>
					
					<i title="Open" class="fa fa-eye verticalCenter" aria-hidden="true" ng-click="openComment(comment.id)"></i>
					<i title="Unsave" class="fa fa-times verticalCenter" aria-hidden="true" ng-click="unsaveComment(comment.id)"></i>
					
				</article>
			</main>
			
			<main class="messagesMain" >
				<article class="mainItem jumbojet boxSizing" ng-repeat="message in data.messages" >
					<img class="verticalCenter" src="images/avatar.jpg"/>
					<div class="forumInfoWrapper verticalCenter">
						<a href="javascript:;">{{ message.content }}</a>
						<span><i>{{ message.sender.username }}</i></span>
					</div>
					
					<i title="Open" class="fa fa-eye verticalCenter" aria-hidden="true" ng-click="openMessage(message.id)"></i>
					<i title="Unsave" class="fa fa-times verticalCenter" aria-hidden="true" ng-click="deleteMessage(message.id)"></i>
					
					<div class="seenIndicator" ng-if="message.isSeen == false"></div>
				</article>
			</main>
			
			<aside>
				<div class="suggestionsWrapper boxSizing">
					<h4>Recommended:</h4>
					<div class="suggestionsItem">
						<img class="verticalCenter" src="images/avatar.jpg" />
						<a href="#">How to use Robomongo for...</a>
					</div>
					<div class="suggestionsItem">
						<img class="verticalCenter" src="images/avatar.jpg" />
						<a href="#">How to use Robomongo for...</a>
					</div>
					<div class="suggestionsItem">
						<img class="verticalCenter" src="images/avatar.jpg" />
						<a href="#">How to use Robomongo for...</a>
					</div>
				</div>
				
				<div class="notificationWrapper">
					<a href="#" class="notificationItem boxSizing padding20">
						<i class="fa fa-thumbs-up" aria-hidden="true"></i> How to use Robomongo for...
					</a>
					<a href="#" class="notificationItem boxSizing padding20">
						<i class="fa fa-thumbs-down" aria-hidden="true"></i> How to use Robomongo for...
					</a>
					<a href="#" class="notificationItem boxSizing padding20">
						<i class="fa fa-thumbs-up" aria-hidden="true"></i> How to use Robomongo for...
					</a>
					<a href="#" class="notificationItem boxSizing padding20">
						<i class="fa fa-thumbs-down" aria-hidden="true"></i> How to use Robomongo for...
					</a>
					<a href="#" class="notificationItem boxSizing padding20">
						<i class="fa fa-thumbs-up" aria-hidden="true"></i> How to use Robomongo for...
					</a>
					<a href="#" class="notificationItem boxSizing padding20">
						<i class="fa fa-thumbs-down" aria-hidden="true"></i> How to use Robomongo for...
					</a>
				</div>
			</aside>
		</div>
		<!--endregion-->
		
		<script src="scripts/home.js"></script>
	</body>
</html>