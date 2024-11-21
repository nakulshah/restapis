package com.nakulshah

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ChangeGeneratorController {

    @GetMapping("/getchange")
    fun getChange(@RequestParam price: Double, @RequestParam payment: Int): ChangeDenomination {
        val changeGenerator = ChangeGenerator()
        return changeGenerator.getChange(price, payment)
    }

}