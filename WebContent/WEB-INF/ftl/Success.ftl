<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
		<title></title>
	</head>
	
	<body>
		<div>Welcome, ${username} &nbsp;&nbsp;&nbsp;&nbsp; <a href="user.action">用户管理</a></div>
		<br />
		<div><a href="http://localhost/Groups/u/${username}">我的个人空间</a></div>
		<br />
		<div><a href="${redUrl}?userId=${session.getAttribute("jitar.login.userId")}&loginName=${session.getAttribute("jitar.login.loginName")}">教研平台</a></div>
	</body>
</html>
