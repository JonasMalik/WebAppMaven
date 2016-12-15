package Database;

import org.hibernate.SessionFactory;

/**
 * Created by jonas on 2016-12-07.
 */
public class MyFactories {

    private static MyFactories instance = null;
    protected MyFactories() {}
    public static MyFactories getInstance() {
        if(instance == null) {
            instance = new MyFactories();
        }
        return instance;
    }

    // All factories
    private SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();

    // All getters and setters
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
