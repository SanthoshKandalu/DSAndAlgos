package com.example.ds.knapSacks

import java.lang.RuntimeException

fun findMinimumNumberOfDenominationsRequired(denominations : IntArray?, value : Int) : Int {
    denominations ?: return 0
    denominations.forEach { if (it <= 0)
        throw RuntimeException("Invalid arguments, as denominations cannot be negative or zero") }

    if (value <= 0) {
        return 0
    }

    val min = Array(denominations.size) { IntArray(value+1) }

    for (i in 0 until denominations.size) {
        for ( j in 1..value) {
            if (denominations[i] > j) {
                min[i][j] = if (i > 0) min[i-1][j] else 0
            } else {
                min[i][j] = Math.min(min[i][j - denominations[i]] + 1, if (i > 0) min[i-1][j] else Int.MAX_VALUE)
            }
        }
    }

    return min[denominations.size-1][value]
}