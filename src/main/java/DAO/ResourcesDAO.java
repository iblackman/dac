/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Resources;
import java.util.List;

/**
 *
 * @author Igor
 */
public class ResourcesDAO extends GenericDAO<Resources, Integer>{
    public ResourcesDAO(){
        super(Resources.class);
    }
    /**
     * retorna todos os Resources
     * @return 
     */
    public List<Resources> findAll(){
        List<Resources> resources = (List<Resources>) getSession().createQuery("FROM RESOURCES").list();
        return resources;
    }
}
