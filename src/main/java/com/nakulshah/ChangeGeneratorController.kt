package com.nakulshah

import com.apple.eawt.Application
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChangeGeneratorController {

    @GetMapping("/getchange")
    fun getChange(@RequestParam price: Double, @RequestParam payment: Int): ChangeDenomination {
        val changeGenerator = ChangeGenerator()
        return changeGenerator.getChange(price, payment)
    }

    @PostMapping("/transaction", consumes = ["application/json"])
    fun saveTransaction(@RequestBody transact: Transact): ChangeDenomination {
        val changeGenerator = ChangeGenerator()
        //save transaction to data store
        return changeGenerator.getChange(transact.price, transact.payment)
    }

}

data class Transact(val price: Double, val payment: Int){}