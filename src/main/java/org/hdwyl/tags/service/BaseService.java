package org.hdwyl.tags.service;

import com.atme8.project.insuser.model.InsuserModel;

public class BaseService {

	protected InsuserModel loginUser;

	public void setLoginUser(InsuserModel loginUser) {
		this.loginUser = loginUser;
	}

	public InsuserModel getLoginUser() {
		return this.loginUser;
	}

}
