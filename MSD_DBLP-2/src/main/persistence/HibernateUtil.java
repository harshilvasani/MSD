package persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import queryengine.miscellaneous.ResponseMessage;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

    public static ResponseMessage buildSessionFactory(String newUserName, String newPassword, String ipAddress) {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration cfg = new Configuration();
        	
        	cfg.configure("/hibernateXml/hibernate.cfg.xml");
        	
        	if(ipAddress == null || ipAddress.isEmpty())
        		ipAddress = "localhost";
        	
        	
        	String conUrl = "jdbc:mysql://" + ipAddress +":3306/dblp?createDatabaseIfNotExist=true";
        	cfg.getProperties().setProperty("hibernate.connection.password",newPassword);
        	cfg.getProperties().setProperty("hibernate.connection.username",newUserName);
        	cfg.getProperties().setProperty("hibernate.connection.url",conUrl);
        	
        	setSessionFactory(cfg.buildSessionFactory());
        	return new ResponseMessage(true, "");
        
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
        	return new ResponseMessage(false, ex.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
    	if(sessionFactory == null)
    		buildSessionFactory("MSD_TEAM10", "MSD_TEAM10", "mysql-server.cyiy68i5rl4p.us-west-2.rds.amazonaws.com");
        return sessionFactory;
    }
    
    private static void setSessionFactory(SessionFactory sessionfactory) {
    	if(sessionFactory == null)
        sessionFactory = sessionfactory;
    }

    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }
}
