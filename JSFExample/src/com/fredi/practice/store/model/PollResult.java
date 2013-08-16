package com.fredi.practice.store.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class PollResult {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long id;
	
	@Persistent
	private long namoCount;
	@Persistent
	private long rgCount;
	@Persistent
	private long mulayamCount;
	@Persistent
	private long advaniCount;
	@Persistent
	private long mmsCount;
	@Persistent
	private long ammaCount;
	@Persistent
	private long mayaCount;
	@Persistent
	private long mamtaCount;
	
	public long getNamoCount() {
		return namoCount;
	}
	public void setNamoCount(long namoCount) {
		this.namoCount = namoCount;
	}
	public long getRgCount() {
		return rgCount;
	}
	public void setRgCount(long rgCount) {
		this.rgCount = rgCount;
	}
	public long getMulayamCount() {
		return mulayamCount;
	}
	public void setMulayamCount(long mulayamCount) {
		this.mulayamCount = mulayamCount;
	}
	public long getAdvaniCount() {
		return advaniCount;
	}
	public void setAdvaniCount(long advaniCount) {
		this.advaniCount = advaniCount;
	}
	public long getMmsCount() {
		return mmsCount;
	}
	public void setMmsCount(long mmsCount) {
		this.mmsCount = mmsCount;
	}
	public long getAmmaCount() {
		return ammaCount;
	}
	public void setAmmaCount(long ammaCount) {
		this.ammaCount = ammaCount;
	}
	public long getMayaCount() {
		return mayaCount;
	}
	public void setMayaCount(long mayaCount) {
		this.mayaCount = mayaCount;
	}
	public long getMamtaCount() {
		return mamtaCount;
	}
	public void setMamtaCount(long mamtaCount) {
		this.mamtaCount = mamtaCount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public PollResult(long Id){
		setId(Id);
	}
	
	public void resetAllCounts(){
		setAdvaniCount(0L);
		setAmmaCount(0L);		
		setMamtaCount(0L);
		setMayaCount(0L);
		setMmsCount(0L);
		setMulayamCount(0L);
		setNamoCount(0L);
		setRgCount(0L);
	}

	
}
