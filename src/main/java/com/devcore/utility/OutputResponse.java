package com.devcore.utility;

/**
 *
 * @author Snailin Inoa
 *
 * OutputResponse Class is used for general Response for all the Service which
 * include the {message} and the {code}
 *
 */
public class OutputResponse {

    String message;
    String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
