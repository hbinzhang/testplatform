package com.cpit.testplatform.modules.display.entity;

import java.util.Date;

public class TicketTrackKey {
    private String ticketId;

    private Date recordTime;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}