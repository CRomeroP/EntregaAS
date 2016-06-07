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
import org.hibernate.criterion.Restrictions;

public class CtrlReservaAmbNotificacioDB implements CtrlReservaAmbNotificacio{
	
    private SessionFactory factory;
	
    public CtrlReservaAmbNotificacioDB  () {
		factory = Sessio.getInstance();
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
