package com.example.ds.knapSacks

import java.lang.RuntimeException

fun findMinimumNumberOfDenominationsRequired(denominations: IntArray?, value: Int): Int {
    denominations ?: return 0
    denominations.forEach {
        if (it <= 0)
            throw RuntimeException("Invalid arguments, as denominations cannot be negative or zero")
    }

    if (value <= 0) {
        return 0
    }

    val min = Array(denominations.size) { IntArray(value + 1) }

    for (i in 0 until denominations.size) {
        for (j in 1..value) {
            if (denominations[i] > j) {
                min[i][j] = if (i > 0) min[i - 1][j] else 0
            } else {
                min[i][j] = Math.min(min[i][j - denominations[i]] + 1, if (i > 0) min[i - 1][j] else Int.MAX_VALUE)
            }
        }
    }

    return min[denominations.size - 1][value]
}

fun findMaximumValueFromWeights(
    weights: IntArray?, value: IntArray?, maxWeight: Int,
    curr: Int = weights?.size?.minus(1) ?: 0, soFar: Array<HashMap<Int, Int>>? = emptyListOfHashMaps(weights)
): Int {

    weights ?: return 0
    value ?: return 0

    if (maxWeight <= 0 || weights.size != value.size) {
        return 0
    }

    if (curr < 0) {
        return 0
    }

    soFar?.let {
        if (it[curr].containsKey(maxWeight)) {
            return it[curr].getValue(maxWeight)
        }
    }

    val without = findMaximumValueFromWeights(weights, value, maxWeight, curr - 1)
    val with = if (weights[curr] > maxWeight) without
    else value[curr] + findMaximumValueFromWeights(weights, value, maxWeight - weights[curr], curr - 1)

    val ret = Math.max(with, without)

    soFar?.let {
        it[curr].put(maxWeight, ret)
    }

    return ret
}

private fun emptyListOfHashMaps(weights: IntArray?): Array<HashMap<Int, Int>>? {
    weights ?: return null
    if (weights.isEmpty()) {
        return null
    }

    return Array(weights.size) { HashMap<Int, Int>() }
}