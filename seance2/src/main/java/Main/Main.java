package Main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.Club;
import Model.Membre;

public class Main {
	public static void main(String[] args) {
	Club club= new Club();
	club.setName("IEEE");
	club.setDomaine("Technologie");
	
	Membre membre= new Membre();
	membre.setName("Fatma");
	membre.setFamilyName("Guizeni");
	membre.setEmail("fatma@gmail.com");
	membre.setPhone(92587305);
	membre.setClub(club);
	
	//using Session Object (DataAccess instance) to access the DB for CRUD Operations
	SessionFactory sessionFactory= Util.DataAccess.getSessionAnnotationFactory();
	Session session = sessionFactory.getCurrentSession();
	session.beginTransaction();
	//let's try to save our item
	session.save(club); //walla entitymanager.persist(club)?...
	session.save(membre);
	session.getTransaction().commit();
	System.out.println("club ID="+club.getId());
	//end transaction to end program properly
	sessionFactory.close();
}
	
}
