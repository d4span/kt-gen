package org.kcheck.generator

import kotlin.random.Random

/**
 * Shorthand/alias for the Generators object.
 */
typealias Gen = Generators

/**
 * Generates values of a given type T.
 */
interface Generator<out T> : Iterator<T>

/**
 * Provides various utility functions for working with generators.
 */
object Generators {
    /**
     * Returns a generator producing integers.
     */
    fun int(seed: Int = 0): Generator<Int> = object : Generator<Int> {

        val random = Random(seed)

        override fun hasNext(): Boolean = true
        override fun next(): Int = random.nextInt()
    }
}