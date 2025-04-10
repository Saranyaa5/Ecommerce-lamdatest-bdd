package com.actions;

import com.pages.LoginPageLocator;
import com.pages.MyAccountPageLocator;

public class MyAccountAction {
    
    MyAccountPageLocator ma = new MyAccountPageLocator();
    LoginPageLocator lp=new LoginPageLocator();
    
    public String getMyAccountPageHeading() {
        return ma.titleMyAccount.getText();
    }
}
