package com.nakulshah

class Account (var owner: String, var acccountNumber: String, var balance: Double = 0.00,var limit: Double = 5000.00) {

    fun addExpense(expense: Double): Unit{
        balance -= expense
    }

    fun addPayment(payment: Double): Unit{
        balance -= payment
    }

    fun displayAccountInfo(): Unit{
        println("owner = $owner, account number = $acccountNumber, balance = $balance, limit = $limit")
    }
}