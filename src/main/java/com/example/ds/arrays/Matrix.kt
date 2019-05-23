package com.example.ds.arrays

import com.example.ds.helper.ensureBounds
import com.example.ds.helper.isEmptyArray
import com.example.ds.helper.swap

/**
 * @author santhosh.kandalu
 */

fun printMatrixInCyclicManner(array : Array<Array<Int>>?, antiClockWise : Boolean = false) {
    if (array == null || array.isEmptyArray() || array[0].isEmptyArray()) {
        return
    }

    val directions = if (antiClockWise)
        arrayOf(intArrayOf(1,0), intArrayOf(0,1), intArrayOf(-1,0), intArrayOf(0,-1))
    else
        arrayOf(intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1), intArrayOf(-1,0))

    var left = 0; var right = array[0].size - 1; var top = 0; var bottom = array.size - 1
    var x = 0; var y = 0; var direction = 0

    while (true) {
        System.out.println(array[x][y])

        if (x + directions[direction][0] !in top..bottom || y + directions[direction][1] !in left..right) {
            direction = (direction + 1) % 4

            when (direction) {
                1 -> if (antiClockWise) left += 1 //next direction is horizontally right
                else top += 1 //next direction is vertically down
                2 -> if (antiClockWise) bottom -=1 //next direction is vertically up
                else right -= 1 //next direction is horizontally left
                3 -> if (antiClockWise) right -= 1 //next direction is horizontally left
                else bottom -= 1 //next direction is vertically up
                0 -> if (antiClockWise) top += 1 //next direction is vertically down
                else left += 1 //next direction is horizontally right
            }

            if (left > right || top > bottom) {
                break
            }

        }
        x += directions[direction][0]
        y += directions[direction][1]
    }
}

fun rotateMatrixInCyclicManner(array: Array<Array<Int>>?, antiClockWise: Boolean = false) {
    array ?: return

    if (array.isEmptyArray() || array[0].isEmptyArray()) {
        return
    }

    val directions = if (!antiClockWise)
        arrayOf(intArrayOf(1,0), intArrayOf(0,1), intArrayOf(-1,0), intArrayOf(0,-1))
    else
        arrayOf(intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1), intArrayOf(-1,0))

    var left = 0; var right = array[0].size - 1; var top = 0; var bottom = array.size - 1
    var startX = -1; var startY = -1

    do {
        startX += 1; startY += 1; var x = startX; var y = startY
        var direction = 0
        do {
            if (x + directions[direction][0] !in top..bottom || y + directions[direction][1] !in left..right) {
                direction = (direction + 1) % 4

                if (x + directions[direction][0] == startX && y + directions[direction][1] == startY) {
                    break
                }
            }
            if (!array.ensureBounds(x + directions[direction][0], y + directions[direction][1])) {
                break
            }
            array.swap(Pair(x, y), Pair(x + directions[direction][0], y + directions[direction][1]))
            x += directions[direction][0]; y += directions[direction][1]
        } while (!(x + directions[direction][0] == startX && y + directions[direction][1] == startY))

        left += 1; right -= 1; top += 1; bottom -= 1

    } while(left <= right && top <= bottom)
}