package com.nakulshah

import org.junit.jupiter.api.Test

class freqTest {

    @Test
    fun testFreqStatusCode(): Unit{
        var freqObj : twentiethField = twentiethField()

        val receivedFreqMap = freqObj.findStatusCodeFreq("/Users/shipshah/IdeaProjects/restapis/src/main/java/com/nakulshah/testStatusCodeFile.log", 11)

        val correctFreqMap = mapOf<String, Int>("1xx" to 1, "9xx" to 1, "2xx" to 2, "3xx" to 3)
        assert(receivedFreqMap == correctFreqMap)
    }
}