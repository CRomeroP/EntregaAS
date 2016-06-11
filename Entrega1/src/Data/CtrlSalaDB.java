package Data;


import domain.Model.Recurs;
import Excepcions.NoHiHaRecursos;
import domain.Model.Sala;

import java.util.ArrayList;



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
        session.beginTransaction();
        Recurs r = (Recurs) sala;
        session.save(sala);
        session.save(r);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public Sala get(String nom) {
        Session session = factory.openSession();
        session.beginTransaction();
        Sala representacio = (Sala) session.createCriteria(Recurs.class)
                .add(Restrictions.eq("nom", nom)).uniqueResult();
        session.close();
        return representacio;
    }

    @Override
    public Boolean exists(String nom)throws Exception {
        return null;
    }

    @Override
    public ArrayList<Sala> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        ArrayList<Sala> recursos = (ArrayList) session.createCriteria(Recurs.class).list();
        if (recursos.isEmpty()) throw new NoHiHaRecursos();
        return recursos;
    }
}
