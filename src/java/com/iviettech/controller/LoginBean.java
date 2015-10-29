/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AnhNN
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
    private String username, password, message;
    private boolean validLogin;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String checkLogin(){
        if (username != null && username.equals("admin")){
            validLogin = true;
            HttpSession session = (HttpSession) 
                    FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            session.setAttribute("username", username);
            return "admin";
        }
        validLogin = false;
        message = "Invalid username or password";
        return null;
    }

    public String logout(){
        validLogin = false;
        message = "";
        username = password = "";
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("username");
        return "login";
    }
    
    public boolean isValidLogin() {
        return validLogin;
    }

    public void setValidLogin(boolean validLogin) {
        this.validLogin = validLogin;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
