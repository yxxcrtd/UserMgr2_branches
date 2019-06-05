package cn.edustar.usermgr.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edustar.usermgr.dao.UserDao;
import cn.edustar.usermgr.pojos.User;

/**
 * 用户DAO的实现
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-01 11:03:22
 */
@SuppressWarnings("unchecked")
public class UserDaoHibernate extends HibernateDaoSupport implements UserDao {
	
	/**
	 * 根据用户名修改密码
	 */
	private static final String LOAD_UPDATE_PASSWORD_BY_USERNAME = "UPDATE User SET password = ? WHERE username = ?";
	
	/**
	 * 根据用户名重置问题和答案
	 */
	private static final String LOAD_RESET_QUESTION_AND_ANSWER_BY_USERNAME = "UPDATE User SET question = ?, answer = ? WHERE username = ?";
	
	/**
	 * 根据用户名修改用户状态
	 */
	private static final String LOAD_UPDATE_STATUS_BY_USERNAME = "UPDATE User SET status = ? WHERE username = ?";
	
	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.dao.UserDao#getUserByQueryString(java.lang.String, java.lang.String)
	 */
	public User getUserByQueryString(String queryString, String value) {
		List<User> list = this.getHibernateTemplate().find("FROM User WHERE (" + queryString + " = ?)", value);
		return (null != list && list.size() > 0) ? (User) list.get(0) : null;
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.dao.UserDao#getUserCounts()
	 */
	public int getUserCounts() {
		List<User> list = this.getHibernateTemplate().find("FROM User");
		return list.size();
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.dao.UserDao#saveOrUpdate(cn.edustar.usermgr.pojos.User)
	 */
	public void saveOrUpdate(User user) {
		this.getHibernateTemplate().saveOrUpdate(user);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.dao.UserDao#updatePasswordByUsername(java.lang.String, java.lang.String)
	 */
	public void updatePasswordByUsername(String username, String password) {
		this.getHibernateTemplate().bulkUpdate(LOAD_UPDATE_PASSWORD_BY_USERNAME, new String[] { password, username });
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.dao.UserDao#updateUserInfoByUsername(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	public void updateUserInfoByUsername(String username, String trueName, String email, int role) {
		this.getHibernateTemplate().bulkUpdate("UPDATE User SET trueName = '" + trueName + "', email = '" + email + "', role = '" + role + "' WHERE username = '" + username + "'");
	}

	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.dao.UserDao#resetQuestionAndAnswerByUsername(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void resetQuestionAndAnswerByUsername(String username, String question, String answer) {
		this.getHibernateTemplate().bulkUpdate(LOAD_RESET_QUESTION_AND_ANSWER_BY_USERNAME, new String[] { question, answer, username });
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.dao.UserDao#updateStatusByUsername(java.lang.String, int)
	 */
	public void updateStatusByUsername(String username, int status) {
		this.getHibernateTemplate().bulkUpdate(LOAD_UPDATE_STATUS_BY_USERNAME, new Object[] { status, username });
	}
	
	/* (non-Javadoc)
	 * 
	 * @see cn.edustar.usermgr.dao.UserDao#deleteUser(cn.edustar.usermgr.pojos.User)
	 */
	public void deleteUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

}
