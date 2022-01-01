import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;


class ConcurrentThreadLocalRandomGeneratorTest {

    RandomGenerator concurrentThreadLocalRandomGenerator = ConcurrentThreadLocalRandomGenerator.get();

    @Test
    void nextInt() {
        assertThat(concurrentThreadLocalRandomGenerator.nextInt())
                .isInstanceOf(Integer.class);
    }
}