package Data;


import domain.Model.Recurs;
import domain.Model.Ordinador;
import Excepcions.NoHiHaRecursos;
import domain.Factories.CtrlDataFactoria;
import domain.Model.Types;

import java.util.ArrayList;
import org.hibernate.HibernateException;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;

public class CtrlOrdinadorDB implements CtrlOrdinador{
	
    private final SessionFactory factory;
	
    public CtrlOrdinadorDB() {
         factory = HibernateSessionFactory.getInstance();
	}
	

    @Override
    public void insert(Ordinador ord) {
        Session session = factory.openSession();
        try{session.beginTransaction();
            ord.setType(Types.Ordinador);
            session.save(ord);
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
    public Ordinador get(String nom) {
        Ordinador ord = new Ordinador();
        Session session = factory.openSession();
        try{session.beginTransaction();
            ord = (Ordinador) session.createCriteria(Recurs.class)
                .add(Restrictions.eq("nom", nom)).uniqueResult();
            session.close();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return ord;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    @Override
    public ArrayList<Ordinador> getAll() {
        ArrayList<Ordinador> ordinadors = new ArrayList<Ordinador>();
        Session session = factory.getCurrentSession();
        try{session.beginTransaction();
            ArrayList<Ordinador> orinaors = (ArrayList) session.createCriteria(Recurs.class).list();
            if (ordinadors.isEmpty()) throw new NoHiHaRecursos("No hi ha recursos");
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return ordinadors;
    }
}
