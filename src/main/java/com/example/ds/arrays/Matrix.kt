package com.example.ds.arrays

import com.example.ds.helper.isEmptyArray

fun printMatrixInCyclicManner(array : Array<Array<Int>>?) {
    if (array == null || array.isEmptyArray() || array?.get(0).isEmptyArray()) {
        return
    }

    val directions = arrayOf(intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1), intArrayOf(-1,0))
    var left = 0; var right = array[0].size - 1; var top = 0; var bottom = array.size - 1
    var x = 0; var y = 0; var direction = 0

    while (true) {
        System.out.println(array[x][y])

        if (x + directions[direction][0] !in top..bottom || y + directions[direction][1] !in left..right) {
            direction = (direction + 1)%4

            when(direction) {
                1 -> top += 1 //next direction is vertically down
                2 -> right -= 1 //next direction is horizontally left
                3 -> bottom -= 1 //next direction is vertically up
                0 -> left += 1 //next direction is horizontally right
            }

            if (left > right || top > bottom) {
                break
            }

        }
        x += directions[direction][0]
        y += directions[direction][1]
    }
}