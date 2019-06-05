package cn.edustar.usermgr.action.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;

import cn.edustar.usermgr.pojos.Ticket;
import cn.edustar.usermgr.pojos.User;
import cn.edustar.usermgr.service.ConfigService;
import cn.edustar.usermgr.service.UserService;
import cn.edustar.usermgr.util.CommonUtil;

/**
 * 基类Action
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-01 10:00:01
 */
public abstract class BaseUserAction extends BaseAbstractAction {
	private static final long serialVersionUID = -60900938115778303L;
	private static final int INT_SESSION_ABATE_TIME_NEGATIVE = -1;
	private static final int INT_SESSION_ABATE_TIME_ZERO = 0;
	protected String username;
	protected String password;
	protected String vercode;
	protected Integer status;
	protected User user;
	protected List<User> userList = new ArrayList<User>();
	protected UserService userService;
	protected ConfigService configService;
	private Ticket ticket;
	protected String userTicket;
	protected String answer;

	protected Boolean isValidVerifyCode(String sessionVerifyCode,
			String verifyCode) {
		if (CommonUtil.stringEqualsIgnoreCase(sessionVerifyCode, verifyCode)) {
			return true;
		} else {
			this.addActionError(this
					.getText("usermgr.validation.verifyCode.invalid"));
			return false;
		}
	}

	protected User getUserByUsernameOrEmail(String queryString) {
		user = userService.getUserByQueryString(queryString);
		if (null == user) {
			this.addActionError(this.getText("usermgr.validation.error"));
		}
		return user;
	}

	protected String verifyUserStatus(Integer status) {
		switch (status) {
		case 0:
			break;
		case 1:
			this.addActionError(this.getText("usermgr.user.status.audit"));
			return INPUT;
		case 2:
			this.addActionError(this.getText("usermgr.user.status.locked"));
			return INPUT;
		case 3:
			this.addActionError(this.getText("usermgr.user.status.deleted"));
			return INPUT;
		default:
			this.addActionError(this.getText("usermgr.user.status.unknown"));
			return INPUT;
		}
		return "";
	}
	
	protected Boolean equalPassword(String dbPassword, String inputPassword) {
		if (CommonUtil.equalPassword(user.getPassword(), inputPassword)) {
			return true;
		} else {
			this.addActionError(this.getText("usermgr.validation.error"));
			return false;
		}
	}

	protected void updateUserLoginInfo() {
		user.setLastLoginIp(user.getCurrentLoginIp());
		user.setLastLoginTime(user.getCurrentLoginTime());
		user.setCurrentLoginIp(request.getRemoteAddr());
		user.setCurrentLoginTime(new Date());
		int oldLoginTime = user.getLoginTimes();
		int newLoginTime = oldLoginTime + 1;
		user.setLoginTimes(newLoginTime);
		userService.saveOrUpdate(user);
	}

	protected void writeCookieToClient() {
		ticket = userService.createUserTicket(username);
		Cookie cookie = new Cookie("UserTicket", ticket.getTicket());
		cookie.setMaxAge(INT_SESSION_ABATE_TIME_NEGATIVE);
		String domain = getDomain(request.getServerName());
		if (!"".equals(domain) && !Character.isDigit(domain.charAt(0))) {
			cookie.setDomain("." + domain);
		}
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	private String getDomain(String url) {
		String returnDomain = "";
		Boolean isIP = true;
		if (url.contains(".")) {
			String[] tempArray = url.split("\\.");
			for (int i = 0; i < tempArray.length; i++) {
				try {
					Integer.parseInt(tempArray[i]);
				} catch (NumberFormatException e) {
					isIP = false;
					break;
				}
			}
			if (isIP) {
				returnDomain = "";
			} else {
				switch (tempArray.length) {
				case 2:
					returnDomain = url;
					logger.debug(returnDomain);
					break;
				default:
					returnDomain = url.substring(url.indexOf(".") + 1);
					break;
				}
			}
		} else {
			returnDomain = "";
		}
		return returnDomain;
	}

	protected void writeSessionInServer() {
		session.put(User.SESSION_LOGIN_USERID_KEY, user.getId());
		session.put(User.SESSION_LOGIN_NAME_KEY, username);
		session.put("username", user.getTrueName());
	}

	protected void destroyCookies() {
		Cookie[] cookies = request.getCookies();
		try {
			if (null != cookies) {
				for (Cookie cookie : cookies) {
					if ("UserTicket".equals(cookie.getName())) {
						setTicketLastAccessed(cookie.getValue());
						cookie.setMaxAge(INT_SESSION_ABATE_TIME_ZERO);
						cookie.setPath("/");
						String domain = getDomain(request.getServerName());
						if (!"".equals(domain)
								&& !Character.isDigit(domain.charAt(0))) {
							cookie.setDomain("." + domain);
						}
						response.addCookie(cookie);
					}
				}
			}
		} catch (Exception e) {
		}
	}

	private void setTicketLastAccessed(String userTicket) {
		if (!"".equals(userTicket) || userTicket.length() > 0
				|| null != userTicket) {
			Ticket ticket = userService.getTicketByUserTicket(userTicket);
			if (null != ticket) {
				ticket.setLastAccessed(null);
			}
		}
	}

	protected void cleanSession() {
		session.put(User.SESSION_LOGIN_USERID_KEY, null);
		session.put(User.SESSION_LOGIN_NAME_KEY, null);
		session.put("username", null);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	public String getUserTicket() {
		return userTicket;
	}

	public void setUserTicket(String userTicket) {
		this.userTicket = userTicket;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
