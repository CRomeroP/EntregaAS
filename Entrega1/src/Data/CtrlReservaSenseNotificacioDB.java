package Data;


import domain.Model.ReservaSenseNotificacio;
import Excepcions.NoHiHaRecursos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class CtrlReservaSenseNotificacioDB implements CtrlReservaSenseNotificacio{
	
    private SessionFactory factory;
	
    public CtrlReservaSenseNotificacioDB  () {
		factory = Sessio.getInstance();
	}
	
    public void insert(ReservaSenseNotificacio reserva) {

    }

    public ReservaSenseNotificacio get(String username, String nomRecurs, Date d, int hi) {
        return null;
    }


    public Boolean exists(String username, String nomRecurs, Date d, int hi) throws Exception {
        return null;
    }


    public List<ReservaSenseNotificacio> getAll() {
        return null;
    }
}
