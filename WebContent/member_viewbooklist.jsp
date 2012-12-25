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
	<s:include value="topbanner.jsp"></s:include>

	<div class="container-fluid">
		<div class="span3">
			<s:include value="member_nav_left.jsp"></s:include>
		</div>
		<!--/span-->
		<div class="span9">
			<p>viewProfile_member</p>
			<br>
			
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
					<td><s:property value="#book.id"/></td>
					<td><s:property value="#book.name" /></td>
					<td><s:property value="#book.publishDate" /></td>
					<td><s:property value="#book.press" /></td>
					<td><s:property value="#book.description" /></td>
					<td><s:property value="#book.price" /></td>
					<td><s:a action="previewOrder"><s:param name="bookId" value="#book.id"/>订购</s:a>
				</tr>
			</s:iterator>
		</table>
		</div>

	</div>

	<script src="js/jquery-1.8.3.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>