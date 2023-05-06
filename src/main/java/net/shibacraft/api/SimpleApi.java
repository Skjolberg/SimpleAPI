package net.shibacraft.api;

import com.google.inject.Inject;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class SimpleApi {

    @Inject
    private static SimpleCore simpleCore;
    @Inject
    private static SimpleRegion simpleRegion;

    private SimpleApi() {

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

    public static SimpleRegion getSimpleRegion() {
        return check(simpleRegion);
    }

    /*@Inject
    public static void setSimpleCore(SimpleCore core) {
        simpleCore = core;
    }

    public static SimpleCore getSimpleCore() {
        return check(simpleCore);
    }


    @Inject
    public static void setSimpleRegion(SimpleRegion region) {
        simpleRegion = region;
    }

    public static SimpleRegion getSimpleRegion() {
        return check(simpleRegion);
    }*/

}
