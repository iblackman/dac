/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Eventtypes;
import java.util.List;

/**
 *
 * @author Igor
 */
public class EventtypesDAO extends GenericDAO<Eventtypes, Integer>{
    public EventtypesDAO(){
        super(Eventtypes.class);
    }
    /**
     * retorna todos os Eventtypes
     * @return 
     */
    public List<Eventtypes> findAll(){
        List<Eventtypes> eventtypes = (List<Eventtypes>) getSession().createQuery("FROM Eventtypes").list();
        return eventtypes;
    }
}
