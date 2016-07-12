package net.d4rkfly3r.veairbus;

import javax.annotation.Nonnull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Joshua Freedman on 7/5/2016.
 * Project: project-veairbus
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Destination {

    @Nonnull
    String path();

    @Nonnull
    RequestType[] requestType();

    boolean authenticate() default false;

    enum RequestType {
        POST, GET, UPDATE, DELETE
    }
}
