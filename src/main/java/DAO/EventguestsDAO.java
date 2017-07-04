/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Eventguests;
import Model.Users;
import java.util.List;
/**
 *
 * @author Igor
 */
public class EventguestsDAO extends GenericDAO<Eventguests, Integer>{
    public EventguestsDAO(){
        super(Eventguests.class);
    }
    /**
     * retorna todos os Eventguests
     * @return 
     */
    public List<Eventguests> findAll(){
        List<Eventguests> eventguests = (List<Eventguests>) getSession().createQuery("FROM EVENTGUESTS").list();
        return eventguests;
    }
    
    public List<Eventguests> findByUser(Users user){
        return (List<Eventguests>) getSession().createQuery("FROM EVENTGUESTS WHERE users = :user")
                .setParameter("user", user)
                .list();
    }
}
