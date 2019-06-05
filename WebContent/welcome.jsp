<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Welcome</title>
	</head>

	<body>
		欢迎您：<font style="color: #FF0000; font-size: 14px; font-weight: bold;">${username}</font>！
		<s:a href="http://www.jitar.com.cn/JGroups">进入系统</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
		<s:a href="logout.action">退出系统</s:a>
		<script>document.write("<li>Cookie is: " + document.cookie);</script>
	</body>
</html>
