package com.nakulshah

class ChangeGenerator {
    fun getChange(price: Double, payment: Int): ChangeDenomination {

        var changeDenomination = ChangeDenomination()

        val change: Int = ((payment - price) * 100).toInt()
        var newChange: Int = change

        if(0 == newChange) return changeDenomination

        changeDenomination.twentyFive = change / 25
        newChange = newChange - changeDenomination.twentyFive * 25

        if(0 == newChange) return changeDenomination
        else {
            changeDenomination.ten = newChange / 10
            newChange = newChange - changeDenomination.ten * 10
        }

        if(0 == newChange) return changeDenomination
        else {
            changeDenomination.five = newChange / 5
            newChange = newChange - changeDenomination.five * 5
        }

        if(0 == newChange) return changeDenomination
        else changeDenomination.one = newChange

        return changeDenomination
    }
}

class ChangeDenomination(var twentyFive: Int = 0, var ten: Int = 0, var five: Int = 0, var one: Int = 0) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChangeDenomination) return false

        return twentyFive == other.twentyFive
                && ten == other.ten
                && five == other.five
                && one == other.one
    }

    override fun hashCode(): Int {
        var result = twentyFive
        result = 31 * result + ten
        result = 31 * result + five
        result = 31 * result + one
        return result
    }
}