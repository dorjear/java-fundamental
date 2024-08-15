package com.dorjear.training.fundamental.kotlin

import java.util.*
import java.util.function.BinaryOperator
import java.util.function.Function
import java.util.stream.Collectors

object Duplicates {
    private fun duplicateCount(input: String): Int {
        return input
                .lowercase()
                .chars()
                .mapToObj { c: Int -> c.toChar() }
                .collect(
                        Collectors.toMap({ c: Char? -> c }, { 1 }, { a: Int, b: Int -> Integer.sum(a, b) })
                )
                .values.count { it > 1 }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(duplicateCount("abcde"))
        println(duplicateCount("aabbcde"))
        println(duplicateCount("aabBcde"))
        println(duplicateCount("indivisibility"))
        println(duplicateCount("Indivisibilities"))
    }
}