package Data;


import Excepcions.NoHiHaUsuaris;
import domain.Model.Usuari;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class CtrlUsuariDB implements CtrlUsuari{
	
    private SessionFactory factory;
	
    public CtrlUsuariDB() {
		factory = Sessio.getInstance();
	}
	
    public void insert(Usuari usuari) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(usuari);
        session.getTransaction().commit();
    }

    public Usuari get(String username) {
    	Session session = factory.getCurrentSession();
        session.beginTransaction();
        Usuari usuari = (Usuari) session.createCriteria(Usuari.class)
                .add(Restrictions.eq("nom", username)).uniqueResult();
        return usuari;
    }


    public Boolean exists(String userName)throws Exception {
        return null;
    }


    public List<Usuari> getAll() {
    	Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Usuari> usuaris = session.createCriteria(Usuari.class).list();
        if (usuaris.isEmpty()) throw new NoHiHaUsuaris();
        return usuaris;
    }
}
