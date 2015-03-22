package com.kmangutov.crowdsolve.singletons;

/**
 * Created by kmangutov on 3/21/15.
 */

public class LoggedInUser {

    protected int id;

    protected static LoggedInUser mInstance;
    public static LoggedInUser getInstance() {

        if(mInstance == null)
            mInstance = new LoggedInUser();
        return mInstance;
    }

    protected LoggedInUser() {

    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {

        return id;
    }
}
