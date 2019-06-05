package cn.edustar.usermgr.context.impl;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

import cn.edustar.usermgr.context.UserContext;
import cn.edustar.usermgr.service.ConfigService;
import cn.edustar.usermgr.service.UserService;

/**
 * 系统环境对象的实现
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-25 13:05:27
 */
public class UserContextImpl extends UserContext implements
		ServletContextAware, ApplicationContextAware {

	private static final Logger logger = LoggerFactory
			.getLogger(UserContextImpl.class);
	private ServletContext servletContext;
	private ApplicationContext applicationContext;
	private UserService userService;
	private ConfigService configService;
	private UserContext userContext;
	private Map<String, Object> attribute = new Hashtable<String, Object>();

	public UserContextImpl() {
	}

	public void init() {
		servletContext.setAttribute(USER_CONTEXT_KEY_NAME, this);
	}

	public void destroy() {
		logger.debug("UserContextImpl 成功销毁！");
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return this.applicationContext;
	}

	public UserService getUserService() {
		if (null == userService) {
			this.userService = (UserService) this.applicationContext
					.getBean("userService");
		}
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ConfigService getConfigService() {
		if (null == configService) {
			this.configService = (ConfigService) this.applicationContext
					.getBean("configService");
		}
		return this.configService;
	}

	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	public UserContext getUserContext() {
		if (null == userContext) {
			this.userContext = (UserContext) this.applicationContext
					.getBean("userContext");
		}
		return this.userContext;
	}

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}

	public Object getAttribute(String key) {
		return this.attribute.get(key);
	}

	public void setAttribute(String key, Object value) {
		this.attribute.put(key, value);
	}

}
