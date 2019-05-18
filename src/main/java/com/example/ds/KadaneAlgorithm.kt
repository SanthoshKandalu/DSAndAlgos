package com.example.ds

/**
 * @author santhosh.kandalu
 */
class KadaneAlgorithm {

    fun findMaxSumSubArrayUsingKadane(array: IntArray?): IntArray? {
        array ?: return null
        if (array.isEmpty()) {
            return null
        }

        var maxStart = 0
        var maxEnd = 0
        var maxSoFar = array[0]
        var start = 0
        var end = 0
        var sum = array[0]

        for (i in 1 until array.size) {
            if (sum + array[i] < array[i]) {
                start = i; end = i
                sum = 0
            } else {
                end = i
            }
            sum += array[i]

            if (sum > maxSoFar) {
                maxSoFar = sum
                maxStart = start
                maxEnd = end
            } else if (sum == maxSoFar && lengthOf(start, end) > lengthOf(maxStart, maxEnd)) {
                maxStart = start
                maxEnd = end
            }
        }

        val maxArray = IntArray(2)
        maxArray[0] = maxStart
        maxArray[1] = maxEnd
        return maxArray
    }

    private fun lengthOf(from: Int, to: Int): Int {
        return if (to < from) -1 else to - from + 1
    }
}

