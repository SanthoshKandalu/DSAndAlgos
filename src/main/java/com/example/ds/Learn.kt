package com.example.ds

class Learning {

    companion object {
        @JvmStatic
        fun main(array : Array<String>) {
            learnKadaneAlgorithm()
        }
    }
}

fun learnKadaneAlgorithm() {
    KadaneAlgorithm().findMaxSumSubArrayUsingKadane(intArrayOf(1, -1, 2))?.forEach { System.out.println(it) }
}