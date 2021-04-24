package Main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.Club;

public class Main {
	public static void main(String[] args) {
	Club club= new Club();
	club.setName("IEEE");
	club.setDomaine("Technologie");
	
	//using Session Object (DataAccess instance) to access the DB for CRUD Operations
	SessionFactory sessionFactory= Util.DataAccess.getSessionAnnotationFactory();
	Session session = sessionFactory.getCurrentSession();
	session.beginTransaction();
	//let's try to save our item
	session.save(club);
	session.getTransaction().commit();
	System.out.println("club ID="+club.getId());
	//end transaction to end program properly
	sessionFactory.close();
}
	
}
