import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ConcurrentThreadLocalRandomTest {

    Random concurrentThreadLocalRandom = ConcurrentThreadLocalRandom.get();

    @Test
    void nextInt() {
        assertDoesNotThrow(() -> concurrentThreadLocalRandom.nextInt());
    }
}