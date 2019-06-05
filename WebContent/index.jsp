<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><s:text name="usermgr.login.title" /> V2.0</title>
		<link rel="styleSheet" type="text/css" href="./css/style.css" />
		<!--[if IE]>
		<style type="text/css">
		#css3 {
			behavior: url(./css/ie-css3.htc);
			background: #FFF;
		}
		</style>
		<![endif]-->
	</head>

	<body>
		<table width="100%" height="100%">
			<tr>
				<td>
					&nbsp;
				</td>
				<td align="center" width="45%">
					<div id="css3">
						<s:form action="login" name="loginForm">
							<s:if test="redUrl==null">
							<%
								String redUrl = request.getParameter("redUrl");
								if (null == redUrl) {
									redUrl = "welcome.jsp";
								}
							%>
								<input type="hidden" id="1" name="redUrl" value="<%=redUrl%>" />
							</s:if>
							<s:else>
								<input type="hidden" id="2" name="redUrl" value="<s:property value='redUrl' />" />
							</s:else>
							<table border="0">
								<tr>
									<td colspan="3" align="center" height="50">
										<h2>
											<s:text name="usermgr.login.title" />
										</h2>
									</td>
								</tr>
								<tr>
									<td colspan="3" align="center">
										<s:actionerror cssStyle="color:#FF0000; font-weight:bold;" />
									</td>
								</tr>
								<tr>
									<td align="right" width="36%" height="30">
										<s:text name="usermgr.login.username" />
									</td>
									<td>
										<s:textfield id="username" name="username" />
									</td>
									<td>
										<s:if test="username==''">
											<s:fielderror cssStyle="color:#FF0000; font-weight:bold;">
												<s:param>username</s:param>
											</s:fielderror>
										</s:if>
									</td>
								</tr>
								<tr>
									<td align="right" height="30">
										<s:text name="usermgr.login.password" />
									</td>
									<td>
										<s:password id="password" name="password" />
									</td>
									<td>
										<s:if test="password==''">
											<s:fielderror cssStyle="color:#FF0000; font-weight:bold;">
												<s:param>password</s:param>
											</s:fielderror>
										</s:if>
									</td>
								</tr>
								<tr class="verCode">
									<td align="right" height="30">
										<s:text name="usermgr.login.verifyCode" />
									</td>
									<td>
										<input id="verifyCode" type="text" name="vercode" maxlength="4" value="" autocomplete="off" />
									</td>
									<td>
										<s:if test="vercode==''">
											<s:fielderror cssStyle="color: #FF0000; font-weight: bold;">
												<s:param>vercode</s:param>
											</s:fielderror>
										</s:if>
									</td>
								</tr>
								<tr>
									<td></td>
									<td colspan="2">
										<span class="verCode">
											<a href="#"><img id="verifyImage" src="authimg" border="0" title="<s:text name="usermgr.login.verifyCode.refresh" />" /></a>
										</span>
										<a href="#" id="find" title="<s:text name="usermgr.find.title" />"><s:text name="usermgr.find.forget" /></a>
									</td>
								</tr>
								<tr>
									<td colspan="3" align="center" height="50">
										<s:submit cssClass="btn" value="%{getText('usermgr.login.button.login')}" />
										<s:reset cssClass="btn" value="%{getText('usermgr.login.button.reset')}" />
									</td>
								</tr>
							</table>
						</s:form>
					</div>
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javaScript" src="./js/index.js"></script>
	</body>
</html>
