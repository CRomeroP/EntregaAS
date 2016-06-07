package Data;


import domain.Model.Usuari;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlUsuariDB implements CtrlUsuari{
	
    private SessionFactory factory;
	
    public CtrlUsuariDB() {
		factory = Sessio.getInstance().getFactory();
	}
	
    public void insert(Usuari usuari) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(usuari);
        session.getTransaction().commit();
    }

    public Usuari get(String userName) {
    	Session session = factory.getCurrentSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT u.*, j.email, case when j.username is not null then 1 else 0 end as clazz_ FROM PRACTICA4.USUARIREGISTRAT u left join PRACTICA4.Jugador j on j.username = u.username WHERE u.username = :userName");
        query.addEntity(Usuari.class);
        query.setParameter("userName",userName);
        Usuari usuariRegistrat = (Usuari) query.uniqueResult();
        session.getTransaction().commit();
        return usuariRegistrat;
    }


    public Boolean exists(String userName)throws Exception {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	SQLQuery query = session.createSQLQuery("SELECT u.*, j.email, case when j.username is not null then 1 else 0 end as clazz_ FROM PRACTICA4.USUARIREGISTRAT u left join PRACTICA4.Jugador j on j.username = u.username WHERE u.USERNAME = :userName");
        query.addEntity(Usuari.class);
        query.setParameter("userName",userName);
        Boolean result = !query.list().isEmpty();
        if (!result) throw new Exception("Usuari no existeix");
        session.getTransaction().commit();
        return result;
    }


    public List<Usuari> getAll() {
    	Session session = factory.getCurrentSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT u.*, j.email, case when j.username is not null then 1 else 0 end as clazz_ FROM PRACTICA4.USUARIREGISTRAT u left join PRACTICA4.Jugador j on j.username = u.username");
        query.addEntity(Usuari.class);
        List<Usuari> usuaris = new ArrayList<Usuari>();
        session.getTransaction().commit();
        return usuaris;
    }
}
