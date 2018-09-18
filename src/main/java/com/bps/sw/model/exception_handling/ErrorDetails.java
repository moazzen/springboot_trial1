package com.bps.sw.model.exception_handling;

import java.util.Date;

/**
 * Created by MOAZEN on 9/15/2018.
 */
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    private int status;

    public ErrorDetails(Date timestamp, String message, String details, int status) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public int getStatus() {
        return status;
    }
}
