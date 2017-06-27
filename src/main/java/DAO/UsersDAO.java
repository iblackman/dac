/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Users;
import Model.Usertypes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
