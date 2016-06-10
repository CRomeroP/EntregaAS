package Data;


import domain.Model.Recurs;
import Excepcions.NoHiHaRecursos;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class CtrlRecursDB implements CtrlRecurs{
	
    private final SessionFactory factory;
	
    public CtrlRecursDB() {
         factory = HibernateSessionFactory.getInstance();
	}
	
    @Override
    public void insert(Recurs recurs) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(recurs);
        System.out.println("insert");
        session.getTransaction().commit();
    }
    
    @Override
    public Recurs get(String nom) {
        Session session = factory.openSession();
        session.beginTransaction();
        Recurs representacio = (Recurs) session.createCriteria(Recurs.class)
                .add(Restrictions.eq("nom", nom)).uniqueResult();
        session.getTransaction().rollback();
        session.close();
        return representacio;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    @Override
    public ArrayList<Recurs> getAll() {
        Session session = factory.openSession();
        session.getTransaction().begin();
        ArrayList<Recurs> recursos = (ArrayList) session.createCriteria(Recurs.class).list();
        if (recursos.isEmpty()) throw new NoHiHaRecursos();
        return recursos;
    }
}
