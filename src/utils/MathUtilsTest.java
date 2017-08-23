package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathUtilsTest
{
    @Test
    void getMiddleIndexTest()
    {
        Assertions.assertEquals(5, MathUtils.getMiddleIndex(0, 10));
    }
}
