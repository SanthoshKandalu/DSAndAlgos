package com.example.ds.dataStructures

import java.lang.RuntimeException

/**
 * @author santhosh.kc
 */
class Stack<T> (private val capacity : Int = Int.MAX_VALUE) {

    var top : StackNode<T>? = null
    var count = 0

    fun push(value : T?) {
        if (!ensureCapacity()) {
            throw RuntimeException("Stack is full")
        }

        val newNode = StackNode(value,top)
        top = newNode
        count++
    }

    fun pop() : T? {
        if (count == 0 || top == null) {
            throw RuntimeException("Stack is empty")
        }

        val ret = top?.value
        val newTop = top?.next
        top?.next = null
        top = newTop
        count--
        return ret
    }

    fun isEmpty() : Boolean {
        return count == 0
    }

    private fun ensureCapacity() : Boolean{
        return count + 1 <= capacity
    }

    inner class StackNode<T>(val value : T?, var next : StackNode<T>?)
}