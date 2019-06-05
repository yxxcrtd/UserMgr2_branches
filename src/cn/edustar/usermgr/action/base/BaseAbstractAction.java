package cn.edustar.usermgr.action.base;

import java.io.PrintWriter;

import cn.edustar.usermgr.util.ParamUtil;

/**
 * Action基类
 *
 * @author Yang XinXin
 * @version 2.0.0, 2010-09-01 11:02:53
 */
public abstract class BaseAbstractAction extends BaseConstantAction {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 722861995671381801L;
	
	protected PrintWriter out;

	/* (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public final String execute() throws Exception {
		out = response.getWriter();
		String result = NONE;
		try {
			this.session = getActionContext().getSession();
			this.sessionVerifyCode = (String) session.get("random");
			session.put("random", null);
			this.paramUtil = new ParamUtil(getActionContext().getParameters());
			this.cmd = paramUtil.safeGetStringParam("cmd");
			this.k = paramUtil.safeGetStringParam("k");
			redUrl = paramUtil.safeGetStringParam("redUrl");
			
			pager = paramUtil.createPager();
			if (null == p || "".equals(p) || p.length() == 0) {
				pager.setPageSize(20);
			} else {
				pager.setPageSize(Integer.valueOf(p));
			}
			result = beforeExecute();
			if (null != result) {
				return result;
			}
			return execute(cmd);
		} catch (Exception e) {
			throw e;
		}
	}

	protected String beforeExecute() throws Exception {
		return null;
	}

	protected abstract String execute(String cmd) throws Exception;

}
