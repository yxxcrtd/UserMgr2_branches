package cn.edustar.usermgr;

/**
 * 用户常量
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-09 22:08:19
 */
public interface UserConst {
	
	// 用户状态， 0：正常
	public static final int USER_STATUS_NORMAL = 0;
	
	// 用户状态，1：待审核
	public static final int USER_STATUS_WAIT_AUTID = 1;	

	// 用户状态，2：已删除
	public static final int USER_STATUS_DELETED = 2;
	
	// 用户状态，3：已锁定
	public static final int USER_STATUS_LOCKED = 3;
	
	
}
