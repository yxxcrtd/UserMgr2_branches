package cn.edustar.usermgr.action;

import cn.edustar.usermgr.action.base.BaseUserAction;

/**
 * 找回密码
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-22 09:00:01
 */
public class FindAction extends BaseUserAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7732831714564575336L;

	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.action.base.BaseAbstractAction#execute(java.lang.String)
	 */
	@Override
	protected String execute(String cmd) throws Exception {
		if ("verify".equals(cmd)) {
			return verifyUser();
		} else if ("answer".equals(cmd)) {
			return verifyAnswer();
		} else if ("reset".equals(cmd)) {
			return resetPassword();
		}
		return SUCCESS;
	}
	
	private String verifyUser() throws Exception {
		out.print(userService.verifyUser(username));
		out.flush();
		out.close();
		return NONE;
	}
	
	private String verifyAnswer() throws Exception {
		out.print(userService.verifyAnswer(username, answer));
		out.flush();
		out.close();
		return NONE;
	}
	
	private String resetPassword() throws Exception {
		out.print(userService.resetPassword(username, password));
		return NONE;
	}

}
