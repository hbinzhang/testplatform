package com.cpit.testplatform.modules.display.entity;

import java.util.Date;

public class TicketProcessKey {
    private String ticketId;

    private Date processTime;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }
}