package com.example.ds

import com.example.ds.knapSacks.findMinimumNumberOfDenominationsRequired

class Learning {

    companion object {
        @JvmStatic
        fun main(array : Array<String>) {
            //learnKadaneAlgorithm()
            /*val intArray = arrayOf(1,2,3,4,5)
            com.example.ds.helper.quickSort(array = intArray)
            intArray.forEach { System.out.print("$it ") }*/
            System.out.println(findMinimumNumberOfDenominationsRequired(intArrayOf(1,5,6,8),11))
        }
    }
}

fun learnKadaneAlgorithm() {
    KadaneAlgorithm().findMaxSumSubArrayUsingKadane(intArrayOf(1, -1, 2))?.forEach { System.out.println(it) }
}