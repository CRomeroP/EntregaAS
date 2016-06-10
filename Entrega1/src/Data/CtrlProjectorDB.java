/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Excepcions.NoHiHaRecursos;
import domain.Model.Projector;
import domain.Model.Recurs;
import java.util.ArrayList;
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
        session.beginTransaction();
        Recurs r = (Recurs) proj;
        session.save(proj);
        session.save(r);
        System.out.println("insert");
        session.getTransaction().commit();
    }
    
    @Override
    public Projector get(String nom) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Projector proj = (Projector) session.createCriteria(Recurs.class)
                .add(Restrictions.eq("nom", nom)).uniqueResult();
        return proj;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    @Override
    public ArrayList<Projector> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        ArrayList<Projector> recursos = (ArrayList) session.createCriteria(Recurs.class).list();
        if (recursos.isEmpty()) throw new NoHiHaRecursos();
        return recursos;
    }
}
