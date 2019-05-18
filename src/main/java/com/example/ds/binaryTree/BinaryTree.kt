package com.example.ds.binaryTree

class BinaryNode<T : Comparable<T>>(var value: T, var left: BinaryNode<T>? = null, var right: BinaryNode<T>? = null) :
    Comparable<BinaryNode<T>> {
    override fun compareTo(other: BinaryNode<T>): Int {
        return value.compareTo(other.value)
    }
}