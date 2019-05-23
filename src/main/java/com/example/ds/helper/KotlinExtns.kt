package com.example.ds.helper

/**
 * @author santhosh.kandalu
 */

fun <T> Array<T>?.isEmptyArray() = this?.isEmpty() ?: false

fun IntArray?.isEmptyArray() = this?.isEmpty() ?: false

fun <T> Array<T>?.swap(pos1: Int?, pos2: Int?) =
    this?.let {
        pos1 ?: return@let; pos2 ?: return@let
        if (it.ensureBounds(pos1) && it.ensureBounds(pos2)) {
            val temp = this[pos1]
            this[pos1] = this[pos2]
            this[pos2] = temp
        }
    }

fun <T> Array<Array<T>>?.swap(pos1: Pair<Int, Int>?, pos2: Pair<Int, Int>?) =
    this?.let {
        pos1 ?: return@let; pos2 ?: return@let
        if (it.ensureBounds(pos1.first, pos1.second) && it.ensureBounds(pos2.first, pos2.second)) {
            val temp = this[pos1.first][pos1.second]
            this[pos1.first][pos1.second] = this[pos2.first][pos2.second]
            this[pos2.first][pos2.second] = temp
        }
    }

fun <T> Array<Array<T>>?.print() =
    this?.let {
        if (this[0].isEmptyArray()) return@let

        for (i in 0 until this.size) {
            for (j in 0 until this[0].size) {
                System.out.print("${this[i][j].toString()}    ")
            }
            System.out.println()
        }
    }

fun <T> Array<T>?.ensureBounds(pos: Int?) = this != null && pos != null && pos in 0 until this.size

fun <T> Array<Array<T>>?.ensureBounds(x: Int?, y: Int?) =
    this != null && x != null && y != null && this.isNotEmpty() && this[0].isNotEmpty() &&
            x in 0 until this.size && y in 0 until this[0].size