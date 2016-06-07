/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import domain.Model.Usuari;
import org.hibernate.SessionFactory;

/**
 *
 * @author carlos
 */
@SuppressWarnings("deprecation")
public class Sessio {
	private SessionFactory factory;
	
	private static Sessio instance = new Sessio();
	
	private Sessio (){
		AnnotationConfiguration config = new AnnotationConfiguration();
    	config.addAnnotatedClass(Usuari.class);
    	config.configure("hibernate.cfg.xml");
    	new SchemaExport(config).create(true, true);
    	factory = config.buildSessionFactory();
    }	
	
    public static Sessio getIstance(){ return instance;}
    
    public SessionFactory getFactory(){
    	return factory;
    }
    	
}