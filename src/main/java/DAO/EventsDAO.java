/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Events;
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
        List<Events> events = (List<Events>) getSession().createQuery("FROM EVENTS").list();
        return events;
    }
}
