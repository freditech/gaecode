package com.fredi.practice.store.service;

import java.util.HashMap;
import java.util.Map;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.fredi.practice.store.model.PollResult;
import com.google.appengine.api.utils.SystemProperty;

public class PollService {
	private static PersistenceManagerFactory PMF = null;
	private static final long POLL_RESULT_ID = 1L;
	
	static{
	    Map<String, String> properties = new HashMap<String, String>();
	    if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
	      properties.put("javax.jdo.option.ConnectionDriverName",
	    		  			System.getProperty("google.mysql.driver"));
	      properties.put("javax.jdo.option.ConnectionURL",
	    		  			System.getProperty("cloudsql.url"));
	    } else {
	      properties.put("javax.jdo.option.ConnectionDriverName",
	    		  			System.getProperty("mysql.driver"));
	      properties.put("javax.jdo.option.ConnectionURL",
	    		  			System.getProperty("cloudsql.url.dev"));
	    }
	    PMF = JDOHelper.getPersistenceManagerFactory(properties, "Demo");
	    
	    if (ifPollResultExists()){	    	
	    }else{
		    PersistenceManager pm = PMF.getPersistenceManager();
	        PollResult poll = new PollResult(POLL_RESULT_ID);
	        poll.resetAllCounts();
	        try {
	            pm.makePersistent(poll);
	        } finally {
	            pm.close();
	        }
	    }
	}
	
	public static boolean ifPollResultExists(){
		boolean retValue;
		PersistenceManager pm = PMF.getPersistenceManager();
		try{
			PollResult poll = (PollResult)pm.getObjectById(POLL_RESULT_ID);
			retValue = (poll==null);
		}catch(Exception e){
			retValue = false;
		}finally{
			pm.close();
		}
		return retValue;
	}
	
	public PollResult getPollResult(){
		PollResult poll;
		PersistenceManager pm = PMF.getPersistenceManager();
		try{
			poll = (PollResult)pm.getObjectById(POLL_RESULT_ID);
		}catch(Exception e){
			poll = null;
		}finally{
			pm.close();
		}
		return poll;
	}
	
	public void updatePollResult(PollResult pollSrc){
	    PersistenceManager pm = PMF.getPersistenceManager();
	    try {
	        PollResult pollTrgt = (PollResult)pm.getObjectById(POLL_RESULT_ID);
	        
	        pollTrgt.setAdvaniCount(pollSrc.getAdvaniCount());
	        pollTrgt.setAmmaCount(pollSrc.getAmmaCount());
	        pollTrgt.setMamtaCount(pollSrc.getMamtaCount());
	        pollTrgt.setMayaCount(pollSrc.getMayaCount());
	        pollTrgt.setMmsCount(pollSrc.getMmsCount());
	        pollTrgt.setMulayamCount(pollSrc.getMulayamCount());
	        pollTrgt.setNamoCount(pollSrc.getNamoCount());
	        pollTrgt.setRgCount(pollSrc.getRgCount());
	        
	    } finally {
	        pm.close();
	    }
	}
}