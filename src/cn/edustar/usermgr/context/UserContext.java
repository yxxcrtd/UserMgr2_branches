package cn.edustar.usermgr.context;

import javax.servlet.ServletContext;

import cn.edustar.usermgr.service.ConfigService;
import cn.edustar.usermgr.service.UserService;

/**
 * 系统环境
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-25 12:51:12
 */
public abstract class UserContext {
	public static final String USER_CONTEXT_KEY_NAME = "cn.edustar.usermgr.context.UserContext";
	private static final ThreadLocal<UserContext> user_ctxt = new ThreadLocal<UserContext>();

	public static final UserContext getCurrentUserContext() {
		return user_ctxt.get();
	}

	public static final UserContext setCurrentUserContext(UserContext ctxt) {
		UserContext old = user_ctxt.get();
		user_ctxt.set(ctxt);
		return old;
	}

	public abstract ServletContext getServletContext();

	public abstract Object getAttribute(String key);

	public abstract void setAttribute(String key, Object value);

	public abstract UserService getUserService();

	public abstract ConfigService getConfigService();

}
