package cn.edustar.usermgr.action;

import cn.edustar.usermgr.action.base.BaseUserAction;

/**
 * 验证
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-29 15:29:22
 */
public class VerifyAction extends BaseUserAction {
	private static final long serialVersionUID = -3327299724153901940L;

	@Override
	protected String execute(String cmd) throws Exception {
		out.print(configService.getConfigByKey(vercode).getValue());
		out.flush();
		out.close();
		return NONE;
	}

}
