package Data;


import domain.Model.ReservaSenseNotificacio;
import Excepcions.NoHiHaRecursos;
import domain.Model.Recurs;

import java.util.ArrayList;
import java.util.Date;
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
        session.beginTransaction();
        session.save(rsn);
        System.out.println("insert");
        session.getTransaction().commit();
    }
    
    @Override
    public ReservaSenseNotificacio get(Recurs nomRecurs, Date d, int hi) {
        Session session = factory.openSession();
        session.beginTransaction();
        ReservaSenseNotificacio representacio = (ReservaSenseNotificacio) session.createCriteria(ReservaSenseNotificacio.class)
                .add(Restrictions.eq("recurs", nomRecurs)).add(Restrictions.eq("data", d)).add(Restrictions.eq("horainici", hi)).uniqueResult();
        return representacio;
    }

    @Override
    public Boolean exists(String nomRecurs, Date d, int hi)throws Exception {
        return null;
    }

    @Override
    public ArrayList<ReservaSenseNotificacio> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        ArrayList<ReservaSenseNotificacio> recursos = (ArrayList) session.createCriteria(ReservaSenseNotificacio.class).list();
        if (recursos.isEmpty()) throw new NoHiHaRecursos();
        return recursos;
    }
}
