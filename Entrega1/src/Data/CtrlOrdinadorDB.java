package Data;


import domain.Model.Recurs;
import domain.Model.Ordinador;
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

public class CtrlOrdinadorDB implements CtrlOrdinador{
	
    private SessionFactory factory;
	
    public CtrlOrdinadorDB() {
         factory = HibernateSessionFactory.getInstance();
	}
	

    public void insert(Ordinador ord) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Recurs r = (Recurs) ord;
        session.save(ord);
        session.save(r);
        System.out.println("insert");
        session.getTransaction().commit();
    }
    
    @Override
    public Ordinador get(String nom) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Ordinador representacio = (Ordinador) session.createCriteria(Recurs.class)
                .add(Restrictions.eq("nom", nom)).uniqueResult();
        return representacio;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    public ArrayList<Ordinador> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        ArrayList<Ordinador> recursos = (ArrayList) session.createCriteria(Recurs.class).list();
        if (recursos.isEmpty()) throw new NoHiHaRecursos();
        return recursos;
    }
}
