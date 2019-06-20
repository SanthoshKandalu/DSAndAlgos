package com.example.ds.arrays

/**
 * @author santhosh.kandalu
 */
fun IntArray?.findSubsetEqualToGivenSum(sum : Int) : Boolean{
    if (sum <= 0 || this == null || this.isEmpty()) {
        return false
    }

    val matrix = Array(this.size) { Array(sum+1) { it == 0 } }

    (0 until this.size).forEach { i ->
        if (this[i] < 0) return false
        (1..sum).forEach { j ->
            if (this[i] > j) {
                matrix[i][j] = if(i == 0) false else matrix[i][j-1]
            } else {
                matrix[i][j] = if(i == 0) this[i] == j else matrix[i-1][j - this[i]]
            }
        }
    }

    return matrix[this.size-1][sum]
}