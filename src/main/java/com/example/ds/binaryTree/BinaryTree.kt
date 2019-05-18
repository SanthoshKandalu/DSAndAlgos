package com.example.ds.binaryTree

/**
 * @author santhosh.kc
 */
class BinaryNode<T : Comparable<T>>(var value: T, var left: BinaryNode<T>? = null, var right: BinaryNode<T>? = null) :
    Comparable<BinaryNode<T>> {
    override fun compareTo(other: BinaryNode<T>): Int {
        return value.compareTo(other.value)
    }

    fun getHeight() : Int{
        return Math.max(left?.getHeight() ?:0, right?.getHeight() ?: 0) + 1
    }

    fun getBalance() : Int {
        return left?.getHeight() ?: 0 - (right?.getHeight() ?: 0)
    }

    override fun toString(): String {
        return super.toString()
    }
}