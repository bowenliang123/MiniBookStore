<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Book List</title>
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

		<h1>Book List</h1>
		<table class="table table-striped">
			<tr>
				<td>ID</td>
				<td>书名</td>
				<td>发布日期</td>
				<td>出版社</td>
				<td>简介</td>
				<td>价格</td>
			</tr>
			<s:iterator value="bookList" id="book">
				<tr>
					<td><s:property value="#book.id" /></td>
					<td><s:property value="#book.name" /></td>
					<td><s:property value="#book.publishDate" /></td>
					<td><s:property value="#book.press" /></td>
					<td><s:property value="#book.description" /></td>
					<td><s:property value="#book.price" /></td>
				</tr>
			</s:iterator>
		</table>

	</div>

	<script src="js/jquery-1.8.3.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>