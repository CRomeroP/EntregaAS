package Data;


import Excepcions.NoHiHaUsuaris;
import domain.Model.Usuari;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class CtrlUsuariDB implements CtrlUsuari{
	
    private SessionFactory factory;
	
    public CtrlUsuariDB() {
                AnnotationConfiguration config = new AnnotationConfiguration();
                config.addAnnotatedClass(Usuari.class);
		factory = config.buildSessionFactory();
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


    public ArrayList<Usuari> getAll() {
    	Session session = factory.getCurrentSession();
        session.beginTransaction();
        ArrayList<Usuari> usuaris = (ArrayList) session.createCriteria(Usuari.class).list();
        if (usuaris.isEmpty()) throw new NoHiHaUsuaris();
        return usuaris;
    }
}
