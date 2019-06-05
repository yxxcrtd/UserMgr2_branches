package cn.edustar.usermgr.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.XmlRpcServletServer;
import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.edustar.usermgr.xmlrpc.service.impl.XmlRpcUserServiceImpl;

public class VerUser extends HttpServlet {
	private static final long serialVersionUID = 2141694812159507780L;
	private String beanName = "verUser";
	private XmlRpcServletServer server;

	public VerUser() {
		super();
	}

	public void init(ServletConfig pConfig) throws ServletException {
		super.init(pConfig);
		try {
			server = new XmlRpcServletServer();
			PropertyHandlerMapping phm = new PropertyHandlerMapping();			
			phm.addHandler("UserService", XmlRpcUserServiceImpl.class);			
			server.setHandlerMapping(phm);
			XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) server.getConfig();
			serverConfig.setEnabledForExtensions(true);
			serverConfig.setContentLengthOptional(false);
		} catch (XmlRpcException e) {
			try {
			} catch (Throwable ignore) {
			}
			throw new ServletException(e);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		WebApplicationContext app_ctxt = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		try {
			ServletHandler handler = (ServletHandler) app_ctxt.getBean(beanName);
			handler.handleRequest(request, response);
		} catch (BeansException ex) {
			throw new ServletException(ex);
		}
	}
	
	public void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws IOException, ServletException {
		server.execute(pRequest,pResponse);
	}

	public void destroy() {
		super.destroy();
	}
	
}
