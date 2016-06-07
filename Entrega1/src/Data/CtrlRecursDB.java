package Data;


import domain.Model.Recurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlRecursDB implements CtrlRecurs{
	
    private SessionFactory factory;
	
    public CtrlRecursDB() {
		factory = Sessio.getInstance().getFactory();
	}
	
    public void insert(Recurs recurs) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(recurs);
        session.getTransaction().commit();
    }

    public Recurs get(String nom) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Recurs r = session.get(Recurs.class, nom);
        Sessio sessio = session.get(Sessio.class, tipusSessio);
        Representacio representacio = (Representacio) session.createCriteria(Representacio.class)
                .add(Restrictions.eq("local", local))
                .add(Restrictions.eq("sessio", sessio)).uniqueResult();
        return representacio;
    }


    public Boolean exists(String nom)throws Exception {
        return null;
    }


    public List<Recurs> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Recurs> representacions = session.createCriteria(Recurs.class).list();
        if (representacions.isEmpty()) throw new NoHiHaRecursos();
        return representacions;
    }
}
