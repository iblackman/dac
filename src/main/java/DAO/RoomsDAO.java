/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Events;
import Model.Rooms;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Igor
 */
public class RoomsDAO extends GenericDAO<Rooms, Integer>{
    public RoomsDAO(){
        super(Rooms.class);
    }
    /**
     * retorna todos os Rooms
     * @return 
     */
    public List<Rooms> findAll(){
        List<Rooms> rooms = (List<Rooms>) getSession().createQuery("from Rooms").list();
        return rooms;
    }
    
    public List<Rooms> findAvailableByDate(Date dateStart, Date dateEnd ){
        List<Rooms> rooms = findAll();
        List<Rooms> result = new ArrayList<>();
        for (Rooms room : rooms){
            //busca por evento naquela sala e naquela data
            List<Events> events = new EventsDAO().findByRoomByDate(dateStart, dateEnd);
            //se nao existir e' prq esta vazia, entao inclui na resposta
            if (events.isEmpty()){
                result.add(room);
            }
        }
        return result;
    }
}
