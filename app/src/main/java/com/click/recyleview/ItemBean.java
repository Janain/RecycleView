package com.click.recyleview;

import java.io.Serializable;

/**
 * Created by S on 2017/11/16.
 */

public class ItemBean implements Serializable{

    private String contacts;
    private String phone;


    public ItemBean(String contacts, String phone) {
        this.contacts = contacts;
        this.phone = phone;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
