package cn.edustar.usermgr.action.base;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action基类
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-01 11:20:10
 */
public abstract class BaseAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, ServletContextAware,
		SessionAware {
	
	private static final long serialVersionUID = 8075758298871530886L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;
	protected ServletContext servletContext;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
