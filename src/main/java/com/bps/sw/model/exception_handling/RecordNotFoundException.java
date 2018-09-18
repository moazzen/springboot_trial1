package com.bps.sw.model.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MOAZEN on 9/15/2018.
 */

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException (String ex) {
        super(ex);
    }
}
