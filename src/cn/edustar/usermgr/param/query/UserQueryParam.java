package cn.edustar.usermgr.param.query;

import cn.edustar.usermgr.param.base.BaseQueryParam;
import cn.edustar.usermgr.util.QueryHelper;

/**
 * 用户查询参数
 * 
 * @author Yang XinXin
 * @version 2.0.0, 2010-10-12 15:30:19
 */
public class UserQueryParam extends BaseQueryParam implements QueryParam {
	
	public QueryHelper createQuery() {		
		QueryHelper query = new QueryHelper();
		query.fromClause = "FROM User u";
		query.orderClause = "ORDER BY userId DESC";
		return query;
	}
	
}
