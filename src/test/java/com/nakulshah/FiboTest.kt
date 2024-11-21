package com.nakulshah

import org.junit.jupiter.api.Test


class FiboTest {
    @Test
    public fun testFibo(): Unit{
        var fiboObj = fibo()
        var fiboList: List<Int> = fiboObj.printfibo()

        val correctList: List<Int> = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144)

        assert(correctList==fiboList)
    }
}
