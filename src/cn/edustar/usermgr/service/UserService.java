package cn.edustar.usermgr.service;

import cn.edustar.usermgr.pojos.Ticket;
import cn.edustar.usermgr.pojos.User;

/**
 * 用户服务
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-01 11:00:28
 */
public interface UserService {
	
	public User getUserByQueryString(String queryString);

	public Ticket createUserTicket(String username);

	public void saveOrUpdate(User user);

	public User getUserByUserTicket(String userTicket);

	public Ticket getTicketByUserTicket(String userTicket);

	public String verifyUser(String username);

	public String verifyAnswer(String username, String answer);

	public String resetPassword(String username, String password);

	public void updateStatusByUsername(String username, int status);

	public void updatePasswordByUsername(String username, String password);

	public void updateUserInfoByUsername(String username, String trueName, String email, int role);
	
	public void resetQuestionAndAnswerByUsername(String username, String question, String answer);
	
	public void deleteUser(String username);
	
	public int getUserCounts();
	
}
