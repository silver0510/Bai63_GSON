package com.example.sinki.model;

/**
 * Created by Sinki on 9/9/2017.
 */

public class Phone {
    private String mobile;
    private String home;

    public Phone(String mobile, String home) {
        this.mobile = mobile;
        this.home = home;
    }

    public Phone() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return this.mobile + "\n" + this.home ;
    }
}
