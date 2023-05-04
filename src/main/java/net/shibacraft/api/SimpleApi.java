package net.shibacraft.api;

import com.google.inject.Inject;
import org.checkerframework.checker.nullness.qual.Nullable;

public class SimpleApi {

    @Inject
    private static SimpleCore simpleCore;

    public SimpleApi() {

    }

    private static <T> T check(@Nullable T instance) {
        if (instance == null) {
            throw new IllegalStateException("SimplePlugin has not been initialized!");
        }
        return instance;
    }


    public static SimpleCore getSimpleCore() {
        return check(simpleCore);
    }

}
