package Data;


import domain.Model.Recurs;
import Excepcions.NoHiHaRecursos;
import domain.Model.Sala;

import java.util.ArrayList;
import org.hibernate.HibernateException;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;

public class CtrlSalaDB implements CtrlSala{
	
    private final SessionFactory factory;
	
    public CtrlSalaDB() {
         factory = HibernateSessionFactory.getInstance();
	}
	

    @Override
    public void insert(Sala sala) {
        Session session = factory.openSession();
        try{session.beginTransaction();
            Recurs r = (Recurs) sala;
            session.save(sala);
            session.save(r);
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
    public Sala get(String nom) {
        Sala sal = new Sala();
        Session session = factory.openSession();
        try{session.beginTransaction();
            sal = (Sala) session.createCriteria(Recurs.class)
                    .add(Restrictions.eq("nom", nom)).uniqueResult();
            session.close();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return sal;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    @Override
    public ArrayList<Sala> getAll() {
        ArrayList<Sala> salas = new ArrayList<Sala>();
        Session session = factory.getCurrentSession();
        try{session.beginTransaction();
            salas = (ArrayList) session.createCriteria(Recurs.class).list();
            if (salas.isEmpty()) throw new NoHiHaRecursos();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return salas;
    }
}
