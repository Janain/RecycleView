package com.click.recyleview;

import java.io.Serializable;

/**
 * Created by S on 2017/11/16.
 */

public class ItemBean implements Serializable{

    private String account;
    private String password;


    public ItemBean(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
