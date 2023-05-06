package net.shibacraft.api;

import com.google.inject.Inject;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class SimpleApi {

    private static SimpleCore simpleCore;
    private static SimpleRegion simpleRegion;

    private SimpleApi() {

    }

    private static <T> T check(@Nullable T instance) {
        if (instance == null) {
            throw new IllegalStateException("SimplePlugin has not been initialized!");
        }
        return instance;
    }

    @Inject
    private static void setSimpleCore(SimpleCore core) {
        simpleCore = core;
    }

    public static SimpleCore getSimpleCore() {
        return check(simpleCore);
    }


    @Inject
    private static void setSimpleRegion(SimpleRegion region) {
        simpleRegion = region;
    }

    public static SimpleRegion getSimpleRegion() {
        return check(simpleRegion);
    }

}
