package Data;


import Excepcions.NoHiHaRecursos;
import domain.Model.Recurs;
import domain.Model.ReservaAmbNotificacio;
import domain.Model.Usuari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        session.beginTransaction();
        Usuari u = ran.getUsuari();
        ran.getNotificacions().add(u);
        session.save(ran);
        System.out.println(ran.getNotificacions().size());
        u.getNotificacions().add(ran);
        session.update(u);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void afegirUsuariANotificacio(ReservaAmbNotificacio r) {
        Session session = factory.openSession();
        session.beginTransaction();
        System.out.println("SIZE N USUARIS A AF   " + r.getNotificacions().size());
        session.update(r);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public ReservaAmbNotificacio get(Recurs nomRecurs, Date d, int hi) {
        Session session = factory.openSession();
        session.beginTransaction();
        ReservaAmbNotificacio representacio = (ReservaAmbNotificacio) session.createCriteria(ReservaAmbNotificacio.class)
                .add(Restrictions.eq("recurs", nomRecurs)).add(Restrictions.eq("data", d)).add(Restrictions.eq("horainici", hi)).uniqueResult();
        session.close();
        return representacio;
    }

    @Override
    public Boolean exists(String nomRecurs, Date d, int hi)throws Exception {
        return null;
    }

    @Override
    public ArrayList<ReservaAmbNotificacio> getAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        ArrayList<ReservaAmbNotificacio> recursos = (ArrayList) session.createCriteria(ReservaAmbNotificacio.class).list();
        if (recursos.isEmpty()) throw new NoHiHaRecursos();
        return recursos;
    }
}
