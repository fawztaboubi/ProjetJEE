import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import Model.Club;
import Service.clubService;

@ComponentScan(basePackages = { "Service", "Repositories" })
public class Test {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("Service");
		appContext.scan("Repositories");
		appContext.scan("Model");
		appContext.scan("Configurations");
		appContext.refresh();
		Club club= new Club("JokerInfo","Technologie");
		clubService clubService =(clubService)appContext.getBean("clubService");
		clubService.saveClub(club);
		appContext.close();
	}

}
