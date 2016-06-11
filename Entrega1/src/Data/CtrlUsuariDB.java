package Data;


import Excepcions.NoHiHaUsuaris;
import domain.Model.Usuari;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class CtrlUsuariDB implements CtrlUsuari{
	
    private final SessionFactory factory;
	
    public CtrlUsuariDB() {
            factory = HibernateSessionFactory.getInstance();
	}
	
    @Override
    public void insert(Usuari usuari) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(usuari);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Usuari get(String username) {
    	Session session = factory.openSession();
        session.getTransaction().begin();
        Usuari usuari = (Usuari) session.createCriteria(Usuari.class)
                .add(Restrictions.eq("username", username)).uniqueResult();
        if (usuari == null) System.out.println("mobiiiiil");
        session.close();
        return usuari;
    }


    @Override
    public Boolean exists(String userName)throws Exception {
        return null;
    }


    @Override
    public ArrayList<Usuari> getAll() {
    	Session session = factory.openSession();
        session.getTransaction().begin();
        ArrayList<Usuari> usuaris = (ArrayList) session.createCriteria(Usuari.class).list();
        if (usuaris.isEmpty()) throw new NoHiHaUsuaris();
        return usuaris;
    }
}
