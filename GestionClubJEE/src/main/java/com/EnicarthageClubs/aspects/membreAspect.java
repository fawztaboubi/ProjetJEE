package com.EnicarthageClubs.aspects;

import java.util.logging.Logger;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.EnicarthageClubs.service.membreService;

@Aspect
@Component
//this aspect is tracking changes in membre class
public class membreAspect {
	
	private Logger logger= Logger.getLogger(membreService.class.getName());
	@Before("execution(:com.projetjee.service*membreService.add*(.)")
	public void trackAdd(JoinPoint point){
		String methodName = point.getSignature().getName();
		Object newValue = point.getArgs()[0];
		logger.info(methodName+"One member about to be added"+newValue+"on"+point.getTarget());
	}
	
	
	//Poincut:defining join points
	@Before("execution(:com.projetjee.service*membreService.update*(.)")
	//Advice
	public void trackChange(JoinPoint point){
		String methodName = point.getSignature().getName();
		Object newValue = point.getArgs()[0];
		logger.info(methodName+"This member has been updated"+newValue+"on"+point.getTarget());
	}

}
