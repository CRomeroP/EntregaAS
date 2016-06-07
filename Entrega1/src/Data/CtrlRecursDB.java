package Data;


import domain.Model.Recurs;
import Excepcions.NoHiHaRecursos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class CtrlRecursDB implements CtrlRecurs{
	
    private SessionFactory factory;
	
    public CtrlRecursDB() {
		factory = Sessio.getInstance();
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
        Recurs representacio = (Recurs) session.createCriteria(Recurs.class)
                .add(Restrictions.eq("nom", nom)).uniqueResult();
        return representacio;
    }


    public Boolean exists(String nom)throws Exception {
        return null;
    }


    public List<Recurs> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Recurs> recursos = session.createCriteria(Recurs.class).list();
        if (recursos.isEmpty()) throw new NoHiHaRecursos();
        return recursos;
    }
}
