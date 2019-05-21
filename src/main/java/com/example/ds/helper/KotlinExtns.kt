package com.example.ds.helper

fun <T> Array<T>?.isEmptyArray() = this?.isEmpty() ?: false

fun IntArray?.isEmptyArray() = this?.isEmpty() ?: false