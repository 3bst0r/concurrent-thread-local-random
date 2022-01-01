import lombok.experimental.Delegate;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ConcurrentThreadLocalRandom extends Random {

    private static final Random INSTANCE = new ConcurrentThreadLocalRandom();
    private final boolean initialized;

    private ConcurrentThreadLocalRandom() {
        this.initialized = true;
    }

    public static Random get() {
        return INSTANCE;
    }

    @Delegate(excludes = ExcludedFromDelegate.class)
    private Random current() {
        return ThreadLocalRandom.current();
    }

    private interface ExcludedFromDelegate {
        void setSeed(long seed);
    }

    @Override
    @SuppressWarnings("UnsynchronizedOverridesSynchronized")
    public void setSeed(long _seed) {
        if (initialized) {
            throw new UnsupportedOperationException("ConcurrentThreadLocalRandom does not support setSeed");
        }
    }
}
