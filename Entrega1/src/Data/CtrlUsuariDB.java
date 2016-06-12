package Data;


import Excepcions.NoHiHaUsuaris;
import domain.Model.Usuari;
import java.util.ArrayList;
import org.hibernate.HibernateException;
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
        try{session.beginTransaction();
            session.save(usuari);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Usuari get(String username) {
        Usuari usuari = new Usuari();
    	Session session = factory.openSession();
        try{session.getTransaction().begin();
            usuari = (Usuari) session.createCriteria(Usuari.class)
                    .add(Restrictions.eq("username", username)).uniqueResult();
            session.close();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return usuari;
    }


    @Override
    public Boolean exists(String userName)throws Exception {
        return null;
    }


    @Override
    public ArrayList<Usuari> getAll() {
        ArrayList<Usuari> usuaris = new ArrayList<Usuari>();
    	Session session = factory.openSession();
        try{session.getTransaction().begin();
            usuaris = (ArrayList) session.createCriteria(Usuari.class).list();
            if (usuaris.isEmpty()) throw new NoHiHaUsuaris();
        }catch (HibernateException e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return usuaris;
    }
}
