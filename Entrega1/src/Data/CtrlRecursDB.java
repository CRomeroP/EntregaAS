package Data;


import domain.Model.Recurs;
import Excepcions.NoHiHaRecursos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

public class CtrlRecursDB implements CtrlRecurs{
	
    private SessionFactory factory =  HibernateSessionFactory.getInstance();
	
    public CtrlRecursDB() {
	}
	
    @Override
    public void insert(Recurs recurs) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(recurs);
        System.out.println("insert");
        session.getTransaction().commit();
    }
    
    @Override
    public Recurs get(String nom) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Recurs representacio = (Recurs) session.createCriteria(Recurs.class)
                .add(Restrictions.eq("nom", nom)).uniqueResult();
        return representacio;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    @Override
    public ArrayList<Recurs> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        ArrayList<Recurs> recursos = (ArrayList) session.createCriteria(Recurs.class).list();
        if (recursos.isEmpty()) throw new NoHiHaRecursos();
        return recursos;
    }
}
