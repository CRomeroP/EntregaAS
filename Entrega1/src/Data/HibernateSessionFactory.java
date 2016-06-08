/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;

/**
 * Utility class per tenir SessionFactory de Hibernate singleton.
 */
public class HibernateSessionFactory {

    // CtrlHibernateSessionFactory singleton management
    private static SessionFactory instance = null;

    public static SessionFactory getInstance() {
        if (instance == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try {
                instance = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(registry);
                System.err.println("Hi ha hagut un error configurant la SessionFactory de Hibernate.");
                System.err.println("L'error ha sigut: " + e.toString());
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return instance;
    }

}