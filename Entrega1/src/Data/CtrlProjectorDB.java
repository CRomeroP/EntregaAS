/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Excepcions.NoHiHaRecursos;
import domain.Model.Projector;
import domain.Model.Recurs;
import domain.Model.Types;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author carlos
 */
public class CtrlProjectorDB implements CtrlProjector {
    
    private final SessionFactory factory;
	
    public CtrlProjectorDB() {
         factory = HibernateSessionFactory.getInstance();
	}
	

    @Override
    public void insert(Projector proj) {
        Session session = factory.getCurrentSession();
        try {session.beginTransaction();
            proj.setType(Types.Projector);
            session.save(proj);
            session.getTransaction().commit();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }
    
    @Override
    public Projector get(String nom) {
        Projector proj = new Projector();
        Session session = factory.getCurrentSession();
        try{session.beginTransaction();
            proj = (Projector) session.createCriteria(Recurs.class)
                .add(Restrictions.eq("nom", nom)).uniqueResult();
            session.close();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return proj;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    @Override
    public ArrayList<Projector> getAll() {
        ArrayList<Projector> projectors = new ArrayList<Projector>();
        Session session = factory.getCurrentSession();
        try{session.beginTransaction();
            projectors = (ArrayList) session.createCriteria(Recurs.class).list();
            if (projectors.isEmpty()) throw new NoHiHaRecursos("No hi ha recursos");
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return projectors;
    }
}
