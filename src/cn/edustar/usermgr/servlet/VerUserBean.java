package cn.edustar.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edustar.usermgr.pojos.User;
import cn.edustar.usermgr.service.UserService;

/**
 * @author Yang XinXin
 * @version 3.0.0, 2011-01-05 17:57:31
 */
public class VerUserBean extends ServletBeanBase {
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ticket = request.getParameter("UserTicket");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		User user = userService.getUserByUserTicket(ticket);
		if (null != user) {
			System.out.println("验证成功！");
			out.println(user.getId() + "," 
					+ user.getUsername() + ","
					+ user.getPassword() + "," 
					+ user.getGuid() + ","
					+ URLEncoder.encode(user.getTrueName(), "UTF-8") + ","
					+ user.getRole() + ","
					+ user.getUsn());
			System.out.println("统一用户输出的信息：" 
					+ user.getId() + "," 
					+ user.getUsername() + "," 
					+ user.getPassword() + "," 
					+ user.getGuid() + "," 
					+ URLEncoder.encode(user.getTrueName(), "UTF-8") + "," 
					+ user.getRole() + "," 
					+ user.getUsn());
		} else {
			out.println("<script>alert('error');</script>");
			System.out.println("验证出错！");
		}
		out.flush();
		out.close();
	}
	
}
