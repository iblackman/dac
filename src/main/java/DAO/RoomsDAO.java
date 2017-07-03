/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Rooms;
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
}
