package cn.edustar.usermgr.service.impl;

import cn.edustar.usermgr.pojos.Config;
import cn.edustar.usermgr.service.ConfigService;
import cn.edustar.usermgr.service.impl.base.BaseServiceImpl;

public class ConfigServiceImpl extends BaseServiceImpl implements ConfigService {

	public Config getConfigByKey(String key) {
		return configDao.getConfigByKey(key);
	}

	public void updateValueByKey(String key, String value) {
		configDao.updateValueByKey(key, value);
	}

}
