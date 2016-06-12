package Data;


import domain.Model.Recurs;
import Excepcions.NoHiHaRecursos;

import java.util.ArrayList;
import org.hibernate.HibernateException;

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
        try{session.beginTransaction();
            session.save(recurs);
            System.out.println("insert");
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }
    
    @Override
    public Recurs get(String nom) {
        Recurs rec = new Recurs();
        Session session = factory.openSession();
        try{ session.beginTransaction();
            rec = (Recurs) session.createCriteria(Recurs.class)
                    .add(Restrictions.eq("nom", nom)).uniqueResult();
            session.getTransaction().rollback();
            session.close();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return rec;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    @Override
    public ArrayList<Recurs> getAll() {
        ArrayList<Recurs> recursos = new ArrayList<Recurs>();
        Session session = factory.openSession();
        try{session.getTransaction().begin();
            recursos = (ArrayList) session.createCriteria(Recurs.class).list();
            if (recursos.isEmpty()) throw new NoHiHaRecursos();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return recursos;
    }
}
