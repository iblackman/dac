/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Eventguests;
import Model.Events;
import Model.Rooms;
import Model.StatusEvent;
import Model.Users;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Igor
 */
public class EventsDAO extends GenericDAO<Events, Integer>{
    public EventsDAO(){
        super(Events.class);
    }
    /**
     * retorna todos os eventos
     * @return 
     */
    public List<Events> findAll(){
        List<Events> events = (List<Events>) getSession().createQuery("from Events WHERE status = :status")
                .setParameter("status", StatusEvent.CREATED)
                .list();
        
        return events;
    }
    
    public List<Events> findByRoom(Rooms room){
        return (List<Events>) getSession().createQuery("FROM Events WHERE roomid = :room").setParameter("room", room).list();
    }
    
    public List<Events> findByDate(Date dateStart, Date dateEnd){
        return (List<Events>) getSession().createQuery("FROM Events WHERE ((:dateStart BETWEEN startdt AND enddt) OR (:dateEnd BETWEEN startdt AND enddt))")  
                .setParameter("dateStart", dateStart)
                .setParameter("dateEnd", dateEnd)
                .list();
    }
    
    public List<Events> findByRoomByDate(Rooms room, Date dateStart, Date dateEnd){
        return (List<Events>) getSession().createQuery("FROM Events WHERE roomid = :room AND ((:dateStart BETWEEN startdt AND enddt) OR (:dateEnd BETWEEN startdt AND enddt))")  
                .setParameter("room", room)
                .setParameter("dateStart", dateStart)
                .setParameter("dateEnd", dateEnd)
                .list();
    }
    
    public List<Events> findPossibleToUser(Users user){
        List<Eventguests> eventGuests = new EventguestsDAO().findByUser(user);
        List<Events> events = findAll();
        
        
        
        
        for(Eventguests evg : eventGuests){
            events.remove(evg.getEvents());
        }
        return events;
    }
    
    public List<Events> findWaiting(){
        return (List<Events>) getSession().createQuery("FROM Events WHERE status = :status")
                .setParameter("status", StatusEvent.WAITING)
                .list();
    }
    
    public List<Events> findByUser(Users user){
        return (List<Events>) getSession().createQuery("FROM Events WHERE userid = :user and status = :status")
                .setParameter("user", user)
                .setParameter("status", StatusEvent.CREATED)
                .list();
    }
    /**
     * Retorna lista de eventos que possuem o usuario passado como inscrito
     * @param user
     * @return 
     */
    public List<Events> findByEventguestUser(Users user){
        List<Events> result = new ArrayList<>();
        for (Eventguests evGuest : new EventguestsDAO().findByUser(user)){
            result.add(
                    findById(
                            evGuest.getEvents().getId()
                    )
            );
        }
        return result;
    }
    

}
