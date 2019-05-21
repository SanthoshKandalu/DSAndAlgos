package com.example.ds

import com.example.ds.dataStructures.binaryTree.BinaryNode
import com.example.ds.dataStructures.binaryTree.findFirstCommonParent
import com.example.ds.dataStructures.binaryTree.formABinarySearchTreeFrom
import com.example.ds.knapSacks.findMaximumValueFromWeights

class Learning {

    companion object {
        @JvmStatic
        fun main(array : Array<String>?) {
            //learnKadaneAlgorithm()
            /*val intArray = arrayOf(1,2,3,4,5)
            com.example.ds.helper.quickSort(array = intArray)
            intArray.forEach { System.out.print("$it ") }*/
            //System.out.println(findMaximumValueFromWeights(intArrayOf(10,20,30), intArrayOf(60,100,120),50))
            val tree = formABinarySearchTreeFrom(arrayOf(7,4,10,3,6,1,2,5,9,12,8,11,13))
            System.out.println(findFirstCommonParent(tree, BinaryNode(6), BinaryNode(6)))
        }
    }
}

