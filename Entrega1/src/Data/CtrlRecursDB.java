package Data;


import domain.Model.Recurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CtrlRecursDB implements CtrlRecurs{
	
    private SessionFactory factory;
	
    public CtrlRecursDB() {
		factory = Sessio.getInstance().getFactory();
	}
	
    public void insert(Recurs recurs) {
    }

    public Recurs get(Recurs nom) {
        return null;
    }


    public Boolean exists(String nom)throws Exception {
        return null;
    }


    public List<Recurs> getAll() {
    	return null;
    }
}
