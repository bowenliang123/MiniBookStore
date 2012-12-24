<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>未知标题页面</title>
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

	<div class="container">

		<h1>Sorry…登录失败！</h1>
		<h3>错误的账号或密码。</h3>
		<h3>
			<a href="./signin.jsp">点击重新登录</a>
		</h3>
		<h3>
			<a href=".">回到首页</a>
		</h3>

	</div>

	<script src="js/jquery-1.8.3.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>