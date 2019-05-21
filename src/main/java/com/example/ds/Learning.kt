package com.example.ds

import com.example.ds.knapSacks.findMaximumValueFromWeights

class Learning {

    companion object {
        @JvmStatic
        fun main(array : Array<String>) {
            //learnKadaneAlgorithm()
            /*val intArray = arrayOf(1,2,3,4,5)
            com.example.ds.helper.quickSort(array = intArray)
            intArray.forEach { System.out.print("$it ") }*/
            System.out.println(findMaximumValueFromWeights(intArrayOf(10,20,30), intArrayOf(60,100,120),50))
        }
    }
}

