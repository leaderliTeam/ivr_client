package com.pccc.sip.ivrclient.exception;

import com.pccc.sip.ivrclient.bean.ivr.EventProtocol;

public class EventException extends RuntimeException{

    private EventProtocol eventProtocol;

    public EventProtocol getEventProtocol() {
        return eventProtocol;
    }

    public void setEventProtocol(EventProtocol eventProtocol) {
        this.eventProtocol = eventProtocol;
    }

    public EventException() {
    }

    public EventException(String message) {
        super(message);
    }

    public EventException(EventProtocol eventProtocol) {
        this.eventProtocol = eventProtocol;
    }
}
