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

	<div class="container-fluid">
		<div class="span3">
			<s:include value="member_nav_left.jsp"></s:include>
		</div>
		<!--/span-->
		<div class="span9">
			<p>editProfile_member</p>
			<br>
			<s:form action="editMemberProfile">

				<s:textfield name="account.nickName" label="nickName" text="account.nickName" />
				<s:textfield name="account.password" label="password" text="account.password"/>
				<s:radio name="account.gender" label="gender"
					list="#{'1':'Male','0':'Female'}" value="account.gender" />

				<s:submit />

			</s:form>
		</div>

	</div>

	<script src="js/jquery-1.8.3.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>