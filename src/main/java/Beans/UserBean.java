/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Users;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

/**
 *
 * @author Thadeu Jose
 */
@Named(value = "userBean")
@ApplicationScoped
public class UserBean {
    
    @Inject
    private MyLoginBean myLoginBean;
        
    private Users users;
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
    
    public Users getUser() {
        return myLoginBean.getUser();
    }
    
    public String getNome(){
        return myLoginBean.getUser().getName();
    }
    
}
