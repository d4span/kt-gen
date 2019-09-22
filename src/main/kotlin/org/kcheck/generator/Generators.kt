package org.kcheck.generator

/**
 * Shorthand/alias for the Generators object.
 */
typealias Gen = Generators

/**
 * Generates values of a given type T.
 */
interface Generator<out T> {
    /**
     * Produces the next value.
     */
    operator fun next(): T
}

/**
 * Provides various utility functions for working with generators.
 */
object Generators {
    /**
     * Returns a generator producing integers.
     */
    fun int(): Generator<Int> = object : Generator<Int> {
        override fun next(): Int = 0
    }
}