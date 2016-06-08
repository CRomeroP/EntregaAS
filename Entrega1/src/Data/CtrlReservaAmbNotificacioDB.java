package Data;


import domain.Model.ReservaAmbNotificacio;
import Excepcions.NoHiHaRecursos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

public class CtrlReservaAmbNotificacioDB implements CtrlReservaAmbNotificacio{
	
    private SessionFactory factory;
	
    public CtrlReservaAmbNotificacioDB  () {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(serviceRegistry);
	}
	
    public void insert(ReservaAmbNotificacio reserva) {

    }

    public ReservaAmbNotificacio get(String nomRecurs, Date d, int hi) {
        return null;
    }


    public Boolean exists(String nomRecurs, Date d, int hi) throws Exception {
        return null;
    }


    public List<ReservaAmbNotificacio> getAll() {
        return null;
    }
}
