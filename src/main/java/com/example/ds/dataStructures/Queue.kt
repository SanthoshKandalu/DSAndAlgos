package com.example.ds.dataStructures

import java.lang.RuntimeException

/**
 * @author santhosh.kc
 */
class Queue<T>(private val capacity : Int = Int.MAX_VALUE) {

    private var count = 0

    private var head : QueueNode? = null
    private var tail : QueueNode? = null

    fun enqueue(value : T?) {
        value ?: return

        if (!ensureCapacity()) {
            throw RuntimeException("Queue is full")
        }

        val newNode = QueueNode(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.prev = tail
            tail = newNode
        }
    }

    fun dequeue() : T? {
        if (head == null) {
            throw RuntimeException("Queue is empty")
        }

        val ret = head?.value

        val newHead = head?.next
        head?.next = null
        newHead?.prev = null
        head = newHead

        return ret
    }

    private fun ensureCapacity() : Boolean {
        return count + 1 <= capacity
    }

    inner class QueueNode(val value : T, var next : QueueNode? = null, var prev : QueueNode? = null)
}