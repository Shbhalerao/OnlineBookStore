package com.onlinebookstore.dao;

public interface LoginDao 
{
    public boolean customerLogin(String emailId,String password);
    public boolean adminLogin(String emailId,String password);
    public boolean changePassword(String emailId,String newpassword);
}
