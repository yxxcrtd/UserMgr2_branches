package cn.edustar.usermgr.action;

import cn.edustar.usermgr.action.base.BaseUserAction;

/**
 * 登录
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-01 09:39:36
 */
public class LoginAction extends BaseUserAction {
	private static final long serialVersionUID = 2939658770748232529L;

	@Override
	protected String execute(String cmd) throws Exception {
		if ("true".equals(configService.getConfigByKey("isShowVerifyCode")
				.getValue())) {
			if (!isValidVerifyCode(sessionVerifyCode, vercode)) {
				return INPUT;
			}
		}
		if (null == this.getUserByUsernameOrEmail(username)) {
			return INPUT;
		}
		if ("input".equals(verifyUserStatus(user.getStatus()))) {
			return INPUT;
		}
		if (!equalPassword(user.getPassword(), password)) {
			return INPUT;
		}
		updateUserLoginInfo();
		writeCookieToClient();
		writeSessionInServer();
		return SUCCESS;
	}

}
