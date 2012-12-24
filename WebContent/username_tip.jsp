<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h4>
	你好，
	<s:property value="userName" />
	！
</h4>

<p>
	【身份:
	<s:property value="role" />】
</p>