package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvenOdd {


    @Test
    public void testEvenOdd() {

        int even = 0;
        int odd = 1;

        Assertions.assertEquals((10 & 1), even);

        Assertions.assertEquals((9 & 1), odd);

        Assertions.assertEquals((0 & 1), even);

    }

}
