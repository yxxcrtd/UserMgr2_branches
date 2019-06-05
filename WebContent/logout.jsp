<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Logout</title>
	</head>

	<body>
		注销成功！
		<s:a href="login.action">重新登录</s:a>
		<br />
		<script>document.write(document.cookie);</script>
	</body>
</html>
