package com.fredi.practice.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="pollBean")
@SessionScoped
public class PollBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{namoCount}")
	private static long namoCount = 0L;

	public long getNamoCount() {
		return namoCount;
	}

	public void setNamoCount(long namoCount) {
		this.namoCount = namoCount;
	}
	
	public void voteNamo(){
		setNamoCount(getNamoCount() + 1);
		System.out.println("Namo Count: "+getNamoCount());
	}
	

}
