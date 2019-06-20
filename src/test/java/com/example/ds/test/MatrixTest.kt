package com.example.ds.test

import com.example.ds.arrays.printMatrixInCyclicManner
import com.example.ds.arrays.rotateMatrixInCyclicManner
import com.example.ds.helper.print
import org.junit.Test

class MatrixTest {

    @Test
    fun testPrintArrayInCyclicMannerAntiClockwise() {
        printMatrixInCyclicManner(arrayOf(arrayOf(1,10,9),arrayOf(2,11,8), arrayOf(3,12,7), arrayOf(4,5,6)), true)
    }

    @Test
    fun testPrintArrayInCyclicMannerClockwise() {
        printMatrixInCyclicManner(arrayOf(arrayOf(1,2,3,4),arrayOf(12,13,14,5), arrayOf(11,16,15,6), arrayOf(10,9,8,7)))
    }

    @Test
    fun testPrintEmptyArrayInCyclicManner() {
        printMatrixInCyclicManner(arrayOf(arrayOf()))
    }

    @Test
    fun testRotatingArrayClockwise() {
        rotateArray(arrayOf(arrayOf(1, 2, 3, 4), arrayOf(12, 13, 14, 5), arrayOf(11, 16, 15, 6), arrayOf(10, 9, 8, 7)))
    }

    @Test
    fun testRotatingArrayAntiClockwise() {
        rotateArray(arrayOf(arrayOf(1, 2, 3, 4), arrayOf(12, 13, 14, 5), arrayOf(11, 16, 15, 6), arrayOf(10, 9, 8, 7)), true)
    }

    @Test
    fun testRotatingSingleRowArray() {
        rotateArray(arrayOf(arrayOf(1,2,3,4)))
    }

    @Test
    fun testRotatingSingleColumnArray() {
        rotateArray(arrayOf(arrayOf(1), arrayOf(2), arrayOf(3), arrayOf(4)))
    }

    @Test
    fun testRotatingEmptyArray() {
        rotateMatrixInCyclicManner(arrayOf(arrayOf<Int>()), true)
    }

    private fun rotateArray(array : Array<Array<Int>>, antiClockwise : Boolean = false) {
        array.print()
        println("-----------------")
        rotateMatrixInCyclicManner(array, antiClockwise)
        array.print()
    }
}