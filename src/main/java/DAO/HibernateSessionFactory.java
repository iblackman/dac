package DAO;

import Model.Events;
import Model.Eventtypes;
import Model.Resources;
import Model.Rooms;
import Model.StatusEvent;
import Model.Users;
import Model.Usertypes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;
    
    public static Session getSession(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            fillDB();
        }
        return sessionFactory.openSession();
    }    
    
    private static void fillDB(){
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        
        //tipos de usuario
        Usertypes utAdm = new Usertypes();
        utAdm.setName("Administrator");
        utAdm.setPermission(1);
        s.save(utAdm);
        
        Usertypes utHost = new Usertypes();
        utHost.setName("Host");
        utHost.setPermission(2);
        s.save(utHost);
        
        Usertypes utGuest = new Usertypes();
        utGuest.setName("Guest");
        utGuest.setPermission(3);
        s.save(utGuest);        
    		
        //usuario
        Users uAdm = new Users();
        uAdm.setName("ADM");
        uAdm.setEmail("adm@email.com");
        uAdm.setLogin("adm");        
        uAdm.setPassword("adm");
        uAdm.setUsertypeid(utAdm);
        s.save(uAdm);
        
        Users uTest1 = new Users();
        uTest1.setName("Caio");
        uTest1.setEmail("Caiok@v.com.br");
        uTest1.setLogin("guest");
        uTest1.setPassword("guest");
        uTest1.setUsertypeid(utGuest);
        s.save(uTest1);
        
        Users uTest2 = new Users();
        uTest2.setName("Blackman");
        uTest2.setEmail("Black@v.com.br");
        uTest2.setLogin("host");
        uTest2.setPassword("host");
        uTest2.setUsertypeid(utHost);
        s.save(uTest2); 
		
        //resource
        Resources resAr = new Resources();
        resAr.setName("Ar condicionado");
        s.save(resAr);
        
        Resources resQuadro = new Resources();
        resQuadro.setName("Quadro");
        s.save(resQuadro);
        
        //room
        Rooms room201 = new Rooms();
        room201.setName("Sala 201");
        List<Resources> lisResor = new ArrayList<>();
        lisResor.add(resAr);
        lisResor.add(resQuadro);
        room201.setResourcesCollection(lisResor);
        s.save(room201);
        
         //Tipo de evento
        Eventtypes evtReuniao = new Eventtypes();
        evtReuniao.setName("Reunião");
        s.save(evtReuniao);
        
                
        //Mes são indexados com zeros
        Calendar c = Calendar.getInstance();
               
        //exemplo de evento
        Events ev = new Events();
        ev.setName("Evento");
        ev.setDescription("Descricao");
        ev.setMaxguests(10);
        c.set(2017, 7, 31, 10, 0, 0);
        ev.setStartdt(c.getTime());
        c.set(2017, 7, 31, 16, 0, 0);
        ev.setEnddt(c.getTime());
        ev.setEventtypeid(evtReuniao);
        ev.setRoomid(room201);
        List<Resources> lisResorEv = new ArrayList<>();
        lisResorEv.add(resQuadro);
        ev.setResourcesCollection(lisResorEv);
        ev.setUserid(uAdm);
        ev.setStatus(StatusEvent.CREATED);// (1-criado, 2-Aguardando aprovacao, 3-Cancelado) 
        s.save(ev);
        
        
        s.getTransaction().commit();
        s.close();
    }

}
