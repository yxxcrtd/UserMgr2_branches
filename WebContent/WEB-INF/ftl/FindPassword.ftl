<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title><@s.text name="usermgr.find.title" /></title>
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
				<td width="70%">
					<div id="css3">
						<div class="1">
							<div id="wizardcontent">
								<center>
									<table border="0">
										<tr>
											<td colspan="2" align="center" height="50">
												<h2>
													<@s.text name="usermgr.find.step.one" />
												</h2>
											</td>
										</tr>
										<tr>
											<td align="right" width="39%" height="50">
												<@s.label for="username" value="%{getText('usermgr.login.username')}" />
											</td>
											<td>
												<@s.textfield id="username" name="username" onfocus="this.select();" />
												<span class="loadImg"></span>
												<span id="usernameTip"></span>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center" height="70">
												<input type="button" class="btn" onClick="loadNext(1, 2, 1);" value="<@s.text name="usermgr.find.step.next" />" />
											</td>
										</tr>
									</table>
								</center>
							</div>
							<ul id="mainNav" class="threeStep">
								<li class="current corner"><em><@s.text name="usermgr.find.step.tip.one" /></span></li>
								<li><em><@s.text name="usermgr.find.step.tip.two" /></span></li>
								<li class="finalStep"><em><@s.text name="usermgr.find.step.tip.three" /></span></li>
							</ul>
							<div style="clear: both;"></div>
						</div>
	
						<div id="wizardpanel" class="2">
							<div id="wizardcontent">
								<center>
									<table border="0">
										<tr>
											<td colspan="2" align="center" height="50">
												<h2>
													<@s.text name="usermgr.find.step.two" />
												</h2>
											</td>
										</tr>
										<tr>
											<td align="right" width="39%" height="20">
												<@s.label value="%{getText('usermgr.find.question')}" />
											</td>
											<td>
												<div id="question"></div>
											</td>
										</tr>
										<tr>
											<td align="right" width="39%" height="40">
												<@s.label for="answer" value="%{getText('usermgr.find.answer')}" />
											</td>
											<td>
												<@s.textfield id="answer" onfocus="this.select();" />
												<span class="loadImg"></span>
												<span id="answerTip"></span>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center" height="60">
												<input type="button" class="btn" onClick="loadNext(2, 3, 2);" value="<@s.text name="usermgr.find.step.next" />" />
											</td>
										</tr>
									</table>
								</center>
							</div>
							<ul id="mainNav" class="threeStep">
								<li class="lastDone corner"><em><@s.text name="usermgr.find.step.tip.one" /></span></li>
								<li class="current"><em><@s.text name="usermgr.find.step.tip.two" /></span></li>
								<li class="finalStep"><em><@s.text name="usermgr.find.step.tip.three" /></span></li>
							</ul>
							<div style="clear: both;"></div>
						</div>

						<div id="wizardpanel" class="3">
							<div id="wizardcontent">
								<center>
									<table border="0">
										<tr>
											<td colspan="2" align="center" height="50">
												<h2>
													<@s.text name="usermgr.find.step.three" />
												</h2>
											</td>
										</tr>
										<tr>
											<td align="right" width="39%" height="30">
												<@s.label for="password" value="%{getText('usermgr.find.password')}" />
											</td>
											<td>
												<@s.password id="password" onfocus="this.select();" maxlength="25" />
												<span class="loadImg"></span>
												<span id="passwordTip"></span>
											</td>
										</tr>
										<tr>
											<td align="right" height="30">
												<@s.label for="repassword" value="%{getText('usermgr.find.repassword')}" />
											</td>
											<td>
												<@s.password id="repassword" onfocus="this.select();" />
												<span class="loadImg"></span>
												<span id="repasswordTip"></span>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center" height="60">
												<input type="button" class="btn" onClick="loadNext(3, 1, 3);" value="<@s.text name="usermgr.find.step.over" />" />
											</td>
										</tr>
									</table>
								</center>
							</div>
							<ul id="mainNav" class="threeStep">
								<li class="done corner"><em><@s.text name="usermgr.find.step.tip.one" /></span></li>
								<li class="lastDone"><em><@s.text name="usermgr.find.step.tip.two" /></span></li>
								<li class="finalStep current"><em><@s.text name="usermgr.find.step.tip.three" /></span></li>
							</ul>
							<div style="clear: both;"></div>
						</div>
					</div>
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
        <script language="javaScript" src="./js/jquery.js"></script>
        <script language="javaScript" src="./js/find.js"></script>
	</body>
</html>
