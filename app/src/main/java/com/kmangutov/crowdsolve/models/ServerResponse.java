package com.kmangutov.crowdsolve.models;

/**
 * Created by kmangutov on 3/21/15.
 */
public class ServerResponse {

    public String message;

    public boolean isSuccess() {

        return message.equals("success");
    }
}
