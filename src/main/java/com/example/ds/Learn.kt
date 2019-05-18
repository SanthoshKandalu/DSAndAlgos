package com.example.ds

class Learning {

    companion object {
        @JvmStatic
        fun main(array : Array<String>) {
            //learnKadaneAlgorithm()
            val intArray = arrayOf(9,8,7,6,5)
            com.example.ds.helper.quickSort(array = intArray)
            intArray.forEach { System.out.print("$it ") }
        }
    }
}

fun learnKadaneAlgorithm() {
    KadaneAlgorithm().findMaxSumSubArrayUsingKadane(intArrayOf(1, -1, 2))?.forEach { System.out.println(it) }
}