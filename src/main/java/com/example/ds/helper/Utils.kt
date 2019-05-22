package com.example.ds.helper

/**
 * @author santhosh.kandalu
 */
fun <T : Comparable<T>>quickSort(array : Array<T>?, start : Int = 0, end : Int = array?.size?.minus(1) ?: 0) {
    array ?: return

    if (start >= end) {
        return
    }

    var left = start
    var right = end - 1

    while (true) {
        while (left < end && array[left] < array[end]) {left++}
        while (right >= start && array[right] >= array[end]) {right--}

        if (left > right) {
            break
        }

        array.swap(left,right)
    }

    array.swap(left,end)
    quickSort(array, start, left-1)
    quickSort(array, left + 1, end)
}