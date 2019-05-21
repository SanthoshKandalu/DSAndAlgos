package com.example.ds.dataStructures.binaryTree

import com.example.ds.dataStructures.Queue

/**
 * @author santhosh.kandalu
 */
class BinaryNode<T : Comparable<T>>(var value: T, var left: BinaryNode<T>? = null, var right: BinaryNode<T>? = null) :
    Comparable<BinaryNode<T>> {
    override fun compareTo(other: BinaryNode<T>): Int {
        return value.compareTo(other.value)
    }

    fun getHeight(): Int {
        return Math.max(left?.getHeight() ?: 0, right?.getHeight() ?: 0) + 1
    }

    fun getBalance(): Int {
        return left?.getHeight() ?: 0 - (right?.getHeight() ?: 0)
    }

    fun getLeftBalance(): Int {
        return left?.getBalance() ?: 0
    }

    fun getRightBalance(): Int {
        return right?.getBalance() ?: 0
    }

    fun binarySearchInsert(toInsert: BinaryNode<T>?) {
        toInsert ?: return

        if (toInsert < this) {
            left = left?.let { it.binarySearchInsert(toInsert) ; it } ?: toInsert
        } else {
            right = right?.let { it.binarySearchInsert(toInsert) ; it } ?: toInsert
        }
    }

    override fun toString(): String {
        val queue = Queue<BinaryNode<T>>()
        queue.enqueue(this)
        queue.enqueue(null)
        val sb = StringBuffer()
        while (!queue.isEmpty()) {
            val deq = queue.dequeue()
            if (deq == null) {
                if (!queue.isEmpty()) {
                    sb.append("\n")
                    queue.enqueue(null)
                }
            } else {
                sb.append("${deq.value} ")
                deq.left?.let { queue.enqueue(it) }
                deq.right?.let { queue.enqueue(it) }
            }
        }
        return sb.toString()
    }

    override fun equals(other: Any?): Boolean {
        return (other as? BinaryNode<*>)?.value == value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}