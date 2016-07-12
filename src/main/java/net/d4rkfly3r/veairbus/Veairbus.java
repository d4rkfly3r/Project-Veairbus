package net.d4rkfly3r.veairbus;

import eu.infomas.annotation.AnnotationDetector;
import eu.infomas.annotation.Cursor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Joshua Freedman on 7/5/2016.
 * Project: project-veairbus
 */
class Veairbus {

    private static final boolean caseSensitive = false;
    private final Logger logger = LogManager.getLogger("Veairbus");
    private final List<Method> methodsWithDest;
    private final HashMap<String, Method> destinationMethodByDest;

    Veairbus() {
        // INITIALIZE VARIABLES
        methodsWithDest = new ArrayList<>();
        destinationMethodByDest = new HashMap<>();

        // SETUP CONFIGURATION STUFF
        configure();

        // SCAN CLASSPATH
        cacheClasses();

        // START WEB SERVER
        lockResources();
        setupServer();
        startServer();

        // BLOCK TILL DEATH COMMAND
        consumeUIUDC();

        // KILL SERVER
        stopServer();
        unlockResources();
    }

    private void configure() {
        logger.info("Configuring...");
    }

    private void cacheClasses() {
        logger.info("Scanning classes...");

        try {
            methodsWithDest.clear();
            methodsWithDest.addAll(AnnotationDetector.scanClassPath()
                    .forAnnotations(new Class[]{Destination.class})
                    .on(ElementType.METHOD)
                    .collect(Cursor::getMethod));
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Caching classes...");
        logger.debug("\tMethods With @Destination");
        methodsWithDest.forEach(method -> {
            final Destination annotation = method.getAnnotation(Destination.class);
            logger.debug("\t\tPath: {} | Method: {}",annotation.path(), method.toGenericString());
            destinationMethodByDest.put(Veairbus.caseSensitive ? annotation.path() : annotation.path().toLowerCase(), method);
        });
    }

    private void lockResources() {
        logger.info("Locking resources...");
    }

    private void setupServer() {
        logger.info("Setting up server...");
    }

    private void startServer() {
        logger.info("Starting server...");
    }

    private void consumeUIUDC() {
        logger.info("Starting to consume user input...");
    }

    private void stopServer() {
        logger.info("Stopping server...");
    }

    private void unlockResources() {
        logger.info("Unlocking resources...");
    }
}
