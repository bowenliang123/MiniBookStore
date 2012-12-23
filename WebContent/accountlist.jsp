<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Account List</title>
<!-- Bootstrap -->
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href=".">MiniBookStore 迷你书城</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href=".">Home</a></li>
						<li><a href="about.jsp">About</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<h1>Account List</h1>
		<table class="table">
			<tr><td>昵称</td><td>性别</td><td>角色</td></tr>
			<s:iterator value="accountList" id="account">
				<tr>
					<td><s:property value="#account.nickName" /></td>
					<td><s:property value="#account.gender" /></td>
					<td><s:property value="#account.role" /></td>
				</tr>
			</s:iterator>
		</table>

	</div>

	<script src="js/jquery-1.8.3.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>