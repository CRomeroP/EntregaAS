package Data;


import domain.Model.ReservaSenseNotificacio;
import Excepcions.NoHiHaRecursos;
import domain.Model.Recurs;
import domain.Model.ReservaAmbNotificacio;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class CtrlReservaSenseNotificacioDB implements CtrlReservaSenseNotificacio{
	
    private final SessionFactory factory;
	
    public CtrlReservaSenseNotificacioDB  () {
             factory = HibernateSessionFactory.getInstance();
	}

    @Override
    public void insert(ReservaSenseNotificacio rsn) {
        Session session = factory.openSession();
        try{session.beginTransaction();
            session.save(rsn);
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
    public ReservaSenseNotificacio get(Recurs nomRecurs, Date d, int hi) {
        ReservaSenseNotificacio rsn = new ReservaSenseNotificacio();
        Session session = factory.openSession();
        try {session.beginTransaction();
            rsn = (ReservaSenseNotificacio) session.createCriteria(ReservaSenseNotificacio.class)
                    .add(Restrictions.eq("recurs", nomRecurs)).add(Restrictions.eq("data", d)).add(Restrictions.eq("horainici", hi)).uniqueResult();
            session.close();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return rsn;
    }

    @Override
    public Boolean exists(String nomRecurs, Date d, int hi)throws Exception {
        return null;
    }

    @Override
    public ArrayList<ReservaSenseNotificacio> getAll() {
        ArrayList<ReservaSenseNotificacio> rsn = new ArrayList<ReservaSenseNotificacio>();
        Session session = factory.getCurrentSession();
        try{session.beginTransaction();
            ArrayList<ReservaSenseNotificacio> recursos = (ArrayList) session.createCriteria(ReservaSenseNotificacio.class).list();
            if (recursos.isEmpty()) throw new NoHiHaRecursos("No hi ha recursos");
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return rsn;
    }
}
