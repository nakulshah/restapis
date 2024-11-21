package com.nakulshah

public class fibo {
    public fun printfibo(): List<Int> {
        var now: Int = 0
        var next: Int = 1
        var fiboList = mutableListOf<Int>()

        fiboList.add(now)
        fiboList.add(next)

        while (next<100) {
            val interim: Int = next
            next = next + now
            now = interim

            fiboList.add(next)
        }

        println(fiboList)

        return fiboList
    }
}