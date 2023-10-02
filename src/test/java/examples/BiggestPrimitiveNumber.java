package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BiggestPrimitiveNumber {


    private byte findBiggestLong() {

        byte biggest = 0;

        for (; biggest > -1; biggest++);

        return --biggest;

    }

    @Test
    public void testFindBiggestLong() {

        Assertions.assertEquals(Byte.MAX_VALUE, findBiggestLong());

    }
}
