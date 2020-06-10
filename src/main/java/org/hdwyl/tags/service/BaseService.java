package org.hdwyl.tags.service;

import org.hdwyl.tags.model.InsuserModel;

public class BaseService {

    protected InsuserModel loginUser;

    public void setLoginUser(InsuserModel loginUser) {
        this.loginUser = loginUser;
    }

    public InsuserModel getLoginUser() {
        return this.loginUser;
    }

}
