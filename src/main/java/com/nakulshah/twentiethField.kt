package com.nakulshah
import java.io.File

//Jul 28 17:21:32 gatewayproxyapi01 gatewayproxy[15630]: 172.0.133.172:48352 [01-1438104092.181-172.0.133.172-35408032 28/Jul/2021:17:21:32.181] http-in~ primary_backend/gatewayapp02 86/0/1/316/403 200 2040 - - ---- 9/9/5/0/0 0/0 {0.312730} /merchants/f11fae8c66117db1/transactions/6pqz2t/submit_for_settlement TLSv1 ECDHE-RSA-AES128-SHA
//abc.java proxy.log
//200 count

class twentiethField {

    fun findStatusCodeFreq(fileName: String, itemLocation: Int): Map<String, Int>{
        val freqMap = mutableMapOf<String, Int>()

        val fileName = fileName

        File(fileName).forEachLine { line ->
            println(line)
            val tokens = line.split(" ")
            val httpCode: String = tokens[itemLocation]
            println(httpCode)

            val httpGeneric = httpCode.toCharArray()[0] + "xx"

            var freq: Int? = freqMap[httpGeneric] ?: 0

            freqMap[httpGeneric] = freq?.plus(1) as Int

        }

        val sortedMap = freqMap.toList()
            .sortedBy { it.second } // Sort by value (the second element of the Pair)
            .toMap()// Convert back to a Map

        println(sortedMap)
        return sortedMap
    }
}