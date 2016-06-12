package Data;


import Excepcions.NoHiHaRecursos;
import domain.Model.Recurs;
import domain.Model.ReservaAmbNotificacio;
import domain.Model.Usuari;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class CtrlReservaAmbNotificacioDB implements CtrlReservaAmbNotificacio{
	
    private final SessionFactory factory;
	
    public CtrlReservaAmbNotificacioDB  () {
             factory = HibernateSessionFactory.getInstance();
	}
 
    @Override
    public void insert(ReservaAmbNotificacio ran) {
        Session session = factory.openSession();
        try{session.beginTransaction();
            Usuari u = ran.getUsuari();
            ran.getNotificacions().add(u);
            System.out.println(ran.getNotificacions().size());
            u.getNotificacions().add(ran);
            session.save(ran);
            session.update(u);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e){
           if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
           }
        }
    }
    
    @Override
    public void afegirUsuariANotificacio(ReservaAmbNotificacio r) {
        Session session = factory.openSession();
        try{session.beginTransaction();
            session.update(r);
            session.getTransaction().commit();
            session.close();
        }catch(HibernateException e){
           if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
           }
        }
    }
    
    @Override
    public ReservaAmbNotificacio get(Recurs nomRecurs, Date d, int hi) {
        ReservaAmbNotificacio reserva = new ReservaAmbNotificacio();
        Session session = factory.openSession();
        try{ session.beginTransaction();
            reserva = (ReservaAmbNotificacio) session.createCriteria(ReservaAmbNotificacio.class)
                .add(Restrictions.eq("recurs", nomRecurs)).add(Restrictions.eq("data", d)).add(Restrictions.eq("horainici", hi)).uniqueResult();
            session.close();
        }catch(HibernateException e){
           if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
           }
        }
        return reserva;
    }

    @Override
    public Boolean exists(String nomRecurs, Date d, int hi)throws Exception {
        return null;
    }

    @Override
    public ArrayList<ReservaAmbNotificacio> getAll() {
        ArrayList<ReservaAmbNotificacio> reservas = new ArrayList<ReservaAmbNotificacio>();
        Session session = factory.getCurrentSession();
        try {session.beginTransaction();
            reservas = (ArrayList) session.createCriteria(ReservaAmbNotificacio.class).list();
            if (reservas.isEmpty()) throw new NoHiHaRecursos();
        }catch(HibernateException | NoHiHaRecursos e){
           if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
           }
        }
        return reservas;
    }
}
