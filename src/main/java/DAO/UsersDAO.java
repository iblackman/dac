/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Users;
import java.util.List;

/**
 *
 * @author Igor
 */
public class UsersDAO extends GenericDAO<Users, Integer>{
    public UsersDAO(){
        super(Users.class);
    }
    /**
     * retorna todos os Users
     * @return 
     */
    public List<Users> findAll(){
        List<Users> users = (List<Users>) getSession().createQuery("FROM USERS").list();
        return users;
    }
}
