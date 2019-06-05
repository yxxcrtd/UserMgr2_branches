package cn.edustar.usermgr.xmlrpc.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edustar.usermgr.BaseUser;
import cn.edustar.usermgr.context.UserContext;
import cn.edustar.usermgr.pojos.User;
import cn.edustar.usermgr.util.CommonUtil;

/**
 * XML-RPC
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-26 09:01:08
 */
public class XmlRpcUserServiceImpl {
	private static final Logger logger = LoggerFactory
			.getLogger(XmlRpcUserServiceImpl.class);
	UserContext userContext = UserContext.getCurrentUserContext();
	User user = null;

	public BaseUser getUserByUserTicket(String ticket) throws IOException {
		user = userContext.getUserService().getUserByUserTicket(ticket);
		BaseUser baseUser = new BaseUser();
		if (null == user) {
			return null;
		} else {
			copyBaseUser(baseUser, user);
			logger.info("(验证成功)用户票证：" + ticket + "，用户Id：" + user.getId()
					+ "，用户名：" + user.getUsername());
			return baseUser;
		}
	}

	public BaseUser updatePasswordByUsername(String username, String password,
			String newPassword) throws IOException {
		user = userContext.getUserService().getUserByQueryString(username);
		BaseUser baseUser = new BaseUser();
		if (null != user) {
			if (CommonUtil.equalPassword(user.getPassword(), password)) {
				userContext.getUserService().updatePasswordByUsername(username,
						newPassword);
				copyBaseUser(baseUser, user);
				return baseUser;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public BaseUser resetPasswordByUsername(String username, String password)
			throws IOException {
		user = userContext.getUserService().getUserByQueryString(username);
		BaseUser baseUser = new BaseUser();
		if (null != user) {
			userContext.getUserService().updatePasswordByUsername(username,
					password);
			copyBaseUser(baseUser, user);
			return baseUser;
		}
		return null;
	}

	public BaseUser updateUserInfoByUsername(String username, String trueName,
			String email, int role) throws IOException {
		user = userContext.getUserService().getUserByQueryString(username);
		BaseUser baseUser = new BaseUser();
		if (null != user) {
			userContext.getUserService().updateUserInfoByUsername(username,
					trueName, email, role);
			copyBaseUser(baseUser, user);
			return baseUser;
		}
		return null;
	}

	public int getUserCounts() throws IOException {
		return userContext.getUserService().getUserCounts();
	}

	public BaseUser getUserByUsername(String username) throws IOException {
		user = userContext.getUserService().getUserByQueryString(username);
		if (null != user) {
			BaseUser baseUser = new BaseUser();
			copyBaseUser(baseUser, user);
			return baseUser;
		} else {
			return null;
		}
	}

	public BaseUser resetQuestionAndAnswerByUsername(String username,
			String question, String answer) throws IOException {
		user = userContext.getUserService().getUserByQueryString(username);
		userContext.getUserService().resetQuestionAndAnswerByUsername(username,
				question, answer);
		if (null != user) {
			BaseUser baseUser = new BaseUser();
			copyBaseUser(baseUser, user);
			return baseUser;
		} else {
			return null;
		}
	}

	public BaseUser saveNewBaseUser(BaseUser baseUser) throws IOException {
		user = userContext.getUserService().getUserByQueryString(
				baseUser.getUsername());
		if (null != user) {
			return null;
		} else {
			User u = new User();
			u = copyFromBaseUser(baseUser, u);
			userContext.getUserService().saveOrUpdate(u);
			return baseUser;
		}
	}

	public BaseUser deleteUser(String username) throws IOException {
		user = userContext.getUserService().getUserByQueryString(username);
		if (null != user) {
			userContext.getUserService().deleteUser(username);
		}
		return null;
	}

	public BaseUser updateStatusByUsername(String username, int status)
			throws IOException {
		user = userContext.getUserService().getUserByQueryString(username);
		BaseUser baseUser = new BaseUser();
		if (null != user) {
			userContext.getUserService().updateStatusByUsername(username,
					status);
			copyBaseUser(baseUser, user);
			return baseUser;
		}
		return null;
	}

	public String updateValueByKey(String key, String value) throws IOException {
		userContext.getConfigService().updateValueByKey(key, value);
		return "";
	}

	private User copyFromBaseUser(BaseUser baseUser, User user) {
		user.setGuid(baseUser.getGuid());
		user.setUsername(baseUser.getUsername());
		user.setTrueName(baseUser.getTrueName());
		user.setPassword(baseUser.getPassword());
		user.setEmail(baseUser.getEmail());
		user.setCreateDate(baseUser.getCreateDate());
		user.setStatus(baseUser.getStatus());
		user.setLastLoginIp(baseUser.getLastLoginIp());
		user.setLastLoginTime(baseUser.getLastLoginTime());
		user.setCurrentLoginIp(baseUser.getCurrentLoginIp());
		user.setLoginTimes(0);
		user.setQuestion(baseUser.getQuestion());
		user.setAnswer(baseUser.getAnswer());
		user.setUsn(baseUser.getUsn());
		user.setRole(baseUser.getRole());
		user.setRoleName(baseUser.getRoleName());
		return user;
	}

	private void copyBaseUser(BaseUser baseUser, User user) {
		baseUser.setId(user.getId());
		baseUser.setGuid(user.getGuid());
		baseUser.setUsername(user.getUsername());
		baseUser.setTrueName(user.getTrueName());
		baseUser.setPassword(user.getPassword());
		baseUser.setEmail(user.getEmail());
		baseUser.setCreateDate(user.getCreateDate());
		baseUser.setStatus(user.getStatus());
		baseUser.setLastLoginIp(user.getLastLoginIp());
		baseUser.setLastLoginTime(user.getLastLoginTime());
		baseUser.setCurrentLoginIp(user.getCurrentLoginIp());
		baseUser.setCurrentLoginTime(user.getCurrentLoginTime());
		baseUser.setLoginTimes(user.getLoginTimes());
		baseUser.setQuestion(user.getQuestion());
		baseUser.setAnswer(user.getAnswer());
		baseUser.setUsn(user.getUsn());
		baseUser.setRole(user.getRole());
		baseUser.setRoleName(user.getRoleName());
	}

}