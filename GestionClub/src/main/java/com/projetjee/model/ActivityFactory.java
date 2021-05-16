package com.projetjee.model;

public class ActivityFactory {

	
	 public Activity getActivity(String activityType){
	      if(activityType == null){
	         return null;
	      }		
	      if(activityType.equalsIgnoreCase("EVENT")){
	         return new Event();
	         
	      } else if(activityType.equalsIgnoreCase("WORKSHOP")){
	         return new Workshop();
	         
	      } else if(activityType.equalsIgnoreCase("Meeting")){
	         return new Meeting();
	      }
	      
	      return null;
	   }
	 
	 
}
