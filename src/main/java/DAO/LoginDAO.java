/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Users;
import javax.validation.constraints.Past.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Thadeu Jose
 */
public class LoginDAO {
    
    //Returna o usuario ou null se nao tem
    public static Users getLogin(String user, String password){
        Session session = HibernateSessionFactory.getSession();
        Criteria crit = session.createCriteria(Users.class);
        crit.add(Restrictions.eq("login",user));
        crit.add(Restrictions.eq("password",password));
        return (Users)crit.uniqueResult();
        
    }
    
}
