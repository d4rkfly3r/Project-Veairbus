package net.d4rkfly3r.veairbus;

/**
 * Created by Joshua Freedman on 7/5/2016.
 * Project: project-veairbus
 */
public class DefaultDestination {

    @Destination(path = "/", requestType = {Destination.RequestType.GET})
    public void unAuthSlash() {

    }

    @Destination(path = "/", requestType = {Destination.RequestType.UPDATE, Destination.RequestType.DELETE, Destination.RequestType.POST})
    public void authSlash() {

    }
}
