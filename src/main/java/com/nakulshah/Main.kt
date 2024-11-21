package com.nakulshah

fun main(){
    println("hello main!")

    printfibo()

//    println(exceptionsRequire(9))
//    try {
//        println(exceptionsRequire(-1)) //should throw require exception
//    }
//    catch(e: Exception){
//        println(e.stackTraceToString())
//    }
//
//    try {
//        println(exceptionsRequire(0)) //should throw Illegal Arg exception
//    }
//    catch(e: Exception){
//        println(e)
//    }
//
//    try {
//        println(exceptionsRequire(10)) //should throw check exception
//    }
//    catch(e: Exception){
//        println(e)
//    }
//
//    try {
//        println(exceptionsRequire(7)) //should throw check exception
//    }
//    catch(e: Exception){
//        println(e)
//    }
//
//    lambda()
//
//    extension()
//
//    nullSafety()
}

fun exceptionsRequire(input: Int): Int {
    require(input>-1){"Input needs to be positive"}

    val cause = IllegalStateException("Original Cause: Illegal State")
    if(0 == input) {
        throw IllegalArgumentException("Input cannot be 0", cause)
    }

    check(input != 10) {"Input cannot be 10"}

    if(7 == input)
        error("Oops....Lucky number called!")

    return input
}

fun lambda() {
    val items = listOf(1, 2, 3, 4, 5, 6)

    // Lambdas are code blocks enclosed in curly braces.
    items.fold(100, {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    })

    // Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:", { acc, i -> "$acc $i" })
    println(joinedToString)

    // Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)
    println(product)

    val stringPlus: (String, String) -> String = String::plus

    println(stringPlus("hello, ", "world!"))

    val lambdaSum: (Int, Int) -> Int = {a: Int, b: Int -> a+b}

    println(lambdaSum(1,7))

    val lambdaSquare: (Int) -> Int = {a: Int -> a*a}

    println(lambdaSquare(7))
}

fun extension(){
    open class Shape
    class Rectangle: Shape()

    fun Shape.getName() = "Shape"
    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape){
        println(s.getName())
    }

    println(Rectangle().getName())
    printClassName(Shape())
    printClassName(Rectangle())
}

fun nullSafety() {
    var line: String = "my line"
    println(line)
    //line = null

    var nullLine: String? = "my line"
    println(nullLine)
    println(nullLine?.length)
    nullLine = null
    println(nullLine)
    println(nullLine?.length)
    println(nullLine.toString())

    val listWithNulls = listOf<String?>("NotNullString", null)

    for (item in listWithNulls)
        item?.let{println(it)}
}

fun printfibo(): List<Int> {
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


/**
 * -- Lambda expressions + Inline functions = performant custom control structures
 *
 * -- Extension functions
 *
 * -- Null-safety
 *
 * Smart casts (Java 16: Pattern Matching for instanceof)
 *
 * String templates (Java 21: String Templates (Preview))
 *
 * Properties
 *
 * Primary constructors
 *
 * First-class delegation
 *
 * Type inference for variable and property types (Java 10: Local-Variable Type Inference)
 *
 * Singletons
 *
 * Declaration-site variance & Type projections
 *
 * Range expressions
 *
 * Operator overloading
 *
 * Companion objects
 *
 * Data classes
 *
 * Coroutines
 *
 * Top-level functions
 *
 * Default arguments
 *
 * Named parameters
 *
 * Infix functions
 *
 * Expect and actual declarations
 *
 * Explicit API mode and better control of API surface
 *
 * */