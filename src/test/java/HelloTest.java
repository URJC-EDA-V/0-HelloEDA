import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    void helloEDA() {
        Hello hello = new Hello();
        assertEquals("Hello EDA", hello.HelloEDA());
    }
}
