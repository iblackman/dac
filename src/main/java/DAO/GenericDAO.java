/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Igor
 */
public abstract class GenericDAO<T, I extends Serializable> {
    
    @Inject
    protected EntityManager entityManager;

    private Class<T> persistedClass;
    
    static private Session session = HibernateSessionFactory.getSession();
    private Transaction transaction;

    protected GenericDAO() {
    }

    protected GenericDAO(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }
    
    /**
     * pega a session do banco
     * @return 
     */
    public Session getSession(){
        //session = HibernateSessionFactory.getSession();
        return session;
    }
    /**
     * pega a session com transaction do banco
     * @return 
     */
    public Session getSessionTransaction(){
        //session = HibernateSessionFactory.getSession();
        transaction = session.beginTransaction();
        return session;
    }
    /**
     * fecha session banco
     */
    public void closeSession(){
        session.close();
    }
    /**
     * fecha session com commit de trasaction
     */
    public void closeSessionTransaction(){
        transaction.commit();
        //session.close();
    }
    /**
     * create ou update do objeto
     * @param entity
     * @return 
     */
    public T save(@Valid T entity) {
        getSessionTransaction().saveOrUpdate(entity);
        //getSessionTransaction().flush();
        closeSessionTransaction();
        return entity;
    }
    /**
     * deleta objeto
     * @param id 
     */
    public void delete(I id){
        T entity = findById(id);
        getSessionTransaction().delete(entity);
        closeSessionTransaction();
    }
    /**
     * retorna objeto por id
     * @param id
     * @return 
     */
    public T findById(I id){
        return (T) getSession().get(persistedClass, id);
    }
}
