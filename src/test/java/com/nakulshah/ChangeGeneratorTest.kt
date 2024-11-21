package com.nakulshah

import org.junit.jupiter.api.Test

class ChangeGeneratorTest {
    @Test
    fun  testChangeGenerator(): Unit{
        var changeGenerator = ChangeGenerator()
        var changeDenomination = changeGenerator.getChange(17.56, 20)

        println(changeDenomination.twentyFive.toString() + ", " +
                changeDenomination.ten + ", " +
                changeDenomination.five + ", " +
                changeDenomination.one + ", " )

        val expectedCD = ChangeDenomination(9, 1, 1, 4)
        val notExpectedCD = ChangeDenomination(1, 2, 3, 4)

        assert(expectedCD == changeDenomination)
        assert(notExpectedCD != changeDenomination)
    }
}