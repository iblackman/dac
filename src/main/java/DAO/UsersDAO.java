/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Events;
import Model.Users;
import Model.Eventguests;
import java.util.ArrayList;
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
    
    /**
     * retorna lista de usuarios que estao inscritos em um evento (Eventguests)
     * @param event
     * @return 
     */
    public List<Users> findByEvent(Events event){
        List<Users> result = new ArrayList<>();
        for (Eventguests evGuest : new EventguestsDAO().findByEvent(event)){
            result.add(
                    findById(
                            evGuest.getUsers().getId()
                    )
            );
        }
        return result;
    }
}
