package com.nakulshah

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LetsKotlinController {

    @GetMapping("/letskotlin")
    public fun letsKotlin(@RequestParam name: String): String {
        var greet = LetsKotlin(name)
        return greet.lets()
    }
}