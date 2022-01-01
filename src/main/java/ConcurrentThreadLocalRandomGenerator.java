import java.lang.reflect.Proxy;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

public class ConcurrentThreadLocalRandomGenerator {

    private static final RandomGenerator INSTANCE;

    static {
        INSTANCE = (RandomGenerator) Proxy.newProxyInstance(
                ConcurrentThreadLocalRandomGenerator.class.getClassLoader(),
                new Class[]{RandomGenerator.class},
                (proxy, method, args) -> method.invoke(ThreadLocalRandom.current(), args));
    }

    private ConcurrentThreadLocalRandomGenerator() {
    }

    public static RandomGenerator get() {
        return INSTANCE;
    }
}
