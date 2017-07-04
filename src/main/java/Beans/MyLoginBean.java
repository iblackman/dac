/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.LoginDAO;
import Model.Users;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Thadeu Jose
 */
@Named(value = "myLoginBean")
@ManagedBean
@ApplicationScoped
public class MyLoginBean {

    private String login;
    private String password;
    static private Users user;

    /**
     * Creates a new instance of LoginBean
     */
    public MyLoginBean() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    static public Users getUser() {
        return user;
    }

    public String executeLogin() {
        this.user = LoginDAO.getLogin(this.login, this.password);
        if (this.user != null) {
            return "event.xhtml";
        }
        return "index.xhtml";
    }
}
