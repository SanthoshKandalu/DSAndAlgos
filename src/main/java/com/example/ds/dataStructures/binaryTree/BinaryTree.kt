package com.example.ds.dataStructures.binaryTree

/**
 * @author santhosh.kandalu
 */

fun <T : Comparable<T>> formABinarySearchTreeFrom(array : Array<T>?) : BinaryNode<T>? {
    array ?: return null
    if (array.isEmpty())
        return null

    val root = BinaryNode(array[0])

    for (i in 1 until array.size) {
        root.binarySearchInsert(BinaryNode(array[i]))
    }
    return root
}

fun <T : Comparable<T>> findFirstCommonParent(from : BinaryNode<T>?, node1 : BinaryNode<T>?, node2 : BinaryNode<T>?) : BinaryNode<T>? {
    val found = Found()

    val commonParent = findFirstCommonParentInternal(from, node1, node2, found)
    return if (found.allFound()) commonParent else null
}

private fun <T : Comparable<T>> findFirstCommonParentInternal(from : BinaryNode<T>?, node1 : BinaryNode<T>?, node2 : BinaryNode<T>?,
                                              found : Found = Found()) : BinaryNode<T>? {
    node1 ?: return null
    node2 ?: return null
    from ?: return null

    val lParent = from.left?.let { findFirstCommonParentInternal(it,node1, node2, found) }
    if (found.allFound()) {
        return lParent
    }

    val oneFoundFromLeft = lParent != null

    val rParent = from.right?.let { findFirstCommonParentInternal(it, node1, node2, found) }

    if (found.allFound()) {
        return if (oneFoundFromLeft) from else rParent
    }

    if (node1 == from) {
        found.firstFound = true
    }

    if (node2 == from) {
        found.secondFound = true
    }

    return if (found.atLeastOneFound()) from else null
}

class Found(var firstFound : Boolean = false, var secondFound : Boolean = false) {

    fun allFound() : Boolean{
        return firstFound && secondFound
    }

    fun atLeastOneFound() : Boolean {
        return firstFound || secondFound
    }
}