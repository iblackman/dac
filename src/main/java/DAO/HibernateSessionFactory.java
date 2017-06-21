package DAO;

import Model.Events;
import Model.Eventtypes;
import Model.Resources;
import Model.Rooms;
import Model.Users;
import Model.Usertypes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;
    
    public static Session getSession() throws ParseException {
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            FillDB();
        }
        return sessionFactory.openSession();
    }
    
    private static void FillDB() throws ParseException{
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
        uAdm.setEmail("adm@email.com");
        uAdm.setLogin("adm");
        uAdm.setName("ADM");
        uAdm.setPassword("adm");
        uAdm.setUsertypeid(utAdm);
        s.save(uAdm);
        
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
        
        //para gerar a data
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString1 = "31-08-2017 10:00:00";
        String dateInString2 = "31-08-2017 16:00:00";
        //Date date = sdf.parse(dateInString1);
        
        //exemplo de evento
        Events ev = new Events(1, "name", "description", sdf.parse(dateInString1), sdf.parse(dateInString2), 10);
        ev.setName("Evento");
        ev.setDescription("Descricao");
        ev.setMaxguests(10);
        ev.setStartdt(sdf.parse(dateInString1));
        ev.setEnddt(sdf.parse(dateInString2));
        ev.setEventtypeid(evtReuniao);
        ev.setRoomid(room201);
        List<Resources> lisResorEv = new ArrayList<>();
        lisResorEv.add(resQuadro);
        ev.setResourcesCollection(lisResorEv);
        ev.setUserid(uAdm);
        ev.setStatus(1);// (1-criado, 2-Aguardando aprovacao, 3-Cancelado) 
        s.save(ev);
        
        
        s.getTransaction().commit();
	s.close();
    }
}
