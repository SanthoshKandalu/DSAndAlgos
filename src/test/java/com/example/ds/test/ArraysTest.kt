package com.example.ds.test

import com.example.ds.arrays.findSubsetEqualToGivenSum
import org.junit.Test

/**
 * @author santhosh.kandalu
 */
class ArraysTest {

    @Test
    fun testFindSubsetEqualToSum() {
        println(intArrayOf(2,3,8,6).findSubsetEqualToGivenSum(9))
    }
}