package com.cpit.testplatform.modules.display.entity;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;

public class TicketTrack extends TicketTrackKey {
    private Double longtitude;

    private Double latitude;

    private Double altitude;

	/**
	 * 当前实体分页对象
	 */
	protected Page<TicketTrack> page;

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }
    
	@JsonIgnore
	@XmlTransient
	public Page<TicketTrack> getPage() {
		if (page == null){
			page = new Page<TicketTrack>();
		}
		return page;
	}
	
	public Page<TicketTrack> setPage(Page<TicketTrack> page) {
		this.page = page;
		return page;
	}

}