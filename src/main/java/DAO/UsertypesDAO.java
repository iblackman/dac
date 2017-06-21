/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usertypes;
import java.util.List;

/**
 *
 * @author Igor
 */
public class UsertypesDAO extends GenericDAO<Usertypes, Integer>{
    public UsertypesDAO(){
        super(Usertypes.class);
    }
    /**
     * retorna todos os Usertypes
     * @return 
     */
    public List<Usertypes> findAll(){
        List<Usertypes> usertypes = (List<Usertypes>) getSession().createQuery("FROM USERTYPES").list();
        return usertypes;
    }
}
