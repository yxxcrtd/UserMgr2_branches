package cn.edustar.usermgr.action.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edustar.usermgr.util.Pager;
import cn.edustar.usermgr.util.ParamUtil;

import com.opensymphony.xwork2.ActionContext;

/**
 * 常量基类
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-01 11:08:22
 */
public abstract class BaseConstantAction extends BaseAction {
	private static final long serialVersionUID = 2288656390381196921L;
	protected static final Logger logger = LoggerFactory
			.getLogger(BaseConstantAction.class);
	protected String sessionVerifyCode;
	protected ParamUtil paramUtil;
	protected Pager pager = null;
	protected String redUrl;
	protected Integer userId;
	protected String cmd;
	protected String k;
	protected String p;

	public String getRedUrl() {
		return redUrl;
	}

	public String getK() {
		return k;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public Pager getPager() {
		return pager;
	}

	protected String unknownCommand(String cmd) {
		super.addActionError("不支持的命令：" + cmd);
		return ERROR;
	}

	public ActionContext getActionContext() {
		return ActionContext.getContext();
	}

}
