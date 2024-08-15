package com.dorjear.training.fundamental.kotlin

import kotlin.math.pow

object DescendingOrder {
    private fun descendingOrderByNumber(input: Long): Long {
        var input = input
        val theIntegerList: MutableList<Long> = ArrayList()
        while (input > 0) {
            theIntegerList.add(input % 10)
            input /= 10
        }
        theIntegerList.sortWith(Comparator.naturalOrder())
        var output = 0.0
        for ((n, l) in theIntegerList.withIndex()) output += l * 10.0.pow(n)
        return output.toLong()
    }

    private fun descendingOrderByString(input: Long): Long {
        return String(input.toString().toCharArray().sortedDescending().toCharArray()).toLong()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(descendingOrderByNumber(57875568))
        println(descendingOrderByString(57875568));
    }
}