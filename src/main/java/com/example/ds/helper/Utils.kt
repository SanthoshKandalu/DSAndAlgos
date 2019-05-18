package com.example.ds.helper

/**
 * @author santhosh.kc
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

        swap(array, left, right)
    }

    swap(array,left, end)
    quickSort(array, start, left-1)
    quickSort(array, left + 1, end)
}

fun <T> swap(array : Array<T>?, pos1 : Int, pos2 : Int) {
    array ?: return
    if (!ensureBounds(array, pos1)) return
    if (!ensureBounds(array, pos2)) return

    val temp = array[pos1]
    array[pos1] = array[pos2]
    array[pos2] = temp
}

fun <T> ensureBounds(array : Array<T>?, pos : Int) : Boolean{
    array ?: return false
    return pos >= 0 && pos < array.size
}