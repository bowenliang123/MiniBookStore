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
			<p>viewOrder</p>
			<h3>你的订单</h3>
			<br>
			
			<table class="table table-striped">
			<tr>
			<td>订单号</td>
			<td>书名</td>
			<td>订购数量</td>
			<td>出版社</td>
			<td>总价</td>
			<td>是否已付款</td>
			</tr>
			<s:iterator value="orderList" id="book">
				<tr>
					<td><s:property value="#book.id"/></td>
					<td><s:property value="#book.name" /></td>
					<td><s:property value="#book.count" /></td>
					<td><s:property value="#book.press" /></td>
					<td><s:property value="#book.count*#book.price" /></td>
					<td><s:property value="#book.status" /></td>
					<s:if test="#book.status == '未付款'">
					<td><s:a action="payOrder"><s:param name="bookId" value="#book.id"/>付款</s:a>
					</s:if>
				</tr>
			</s:iterator>
		</table>
		</div>

	</div>

	<script src="js/jquery-1.8.3.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>