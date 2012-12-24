<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:action name="getUsername" executeResult="true"></s:action>
<div class="well sidebar-nav">
	<ul class="nav nav-list">
		<li class="nav-header">用户资料</li>
		<li><s:a action="viewMemberProfile">查看个人信息</s:a></li>
		<li><s:a action="editMemberProfile_pre">编辑个人信息</s:a></li>

		<li class="nav-header">书城功能</li>
		<li><s:a action="booklist">查看所有图书</s:a></li>
		<li><a href="#"></a></li>
		
	</ul>
</div>
<!--/.well -->
