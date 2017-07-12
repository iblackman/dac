/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Eventguests;
import Model.Events;
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
        List<Eventguests> eventguests = (List<Eventguests>) getSession().createQuery("FROM Eventguests").list();
        return eventguests;
    }
    /**
     * retorna lista de Eventguests de um usuario
     * @param user
     * @return 
     */
    public List<Eventguests> findByUser(Users user){
        return (List<Eventguests>) getSession().createQuery("FROM Eventguests WHERE users = :user")
                .setParameter("user", user)
                .list();
    }
    /**
     * retorna lista de Eventguests que tem o evento passado como parametro
     * @param event
     * @return 
     */
    public List<Eventguests> findByEvent(Events event){
        return (List<Eventguests>) getSession().createQuery("FROM Eventguests WHERE events = :event")
                .setParameter("event", event)
                .list();
    }
    
        public List<Eventguests> findByEventUser(int event,int user ){
        return (List<Eventguests>) getSession().createQuery("FROM Eventguests WHERE EVENTID = :event and USERID = :user ")
                .setParameter("event", event)
                .setParameter("user", user)
                .list();
    }
}
