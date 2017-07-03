/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Events;
import Model.Rooms;
import Model.StatusEvent;
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
        List<Events> events = (List<Events>) getSession().createQuery("from Events").list();
        return events;
    }
    
    public List<Events> findByRoom(Rooms room){
        return (List<Events>) getSession().createQuery("FROM Events WHERE roomid = :room").setParameter("room", room).list();
    }
    
    public List<Events> findByRoomByDate(Rooms room, Date date){
        return (List<Events>) getSession().createQuery("FROM Events WHERE roomid = :room AND :date BETWEEN startdt AND enddt")
                .setParameter("room", room)
                .setParameter("date", date)
                .list();
    }
    
    public List<Events> findWaiting(){
        return (List<Events>) getSession().createQuery("FROM Events WHERE status = :status")
                .setParameter("status", StatusEvent.WAITING)
                .list();
    }
}
