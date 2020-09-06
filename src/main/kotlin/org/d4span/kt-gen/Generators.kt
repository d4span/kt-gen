package org.d4span.ktgen

import kotlin.random.Random

/**
 * Shorthand/alias for the Generators object.
 */
typealias Gen = Generators

/**
 * Generates values of a given type T.
 */
interface Generator<out T> : Iterator<T>

fun Generator<Int>.withMapper(mapper: (Int) -> Long): Generator<Long> = object : Generator<Long> {
    override fun hasNext() = true
    override fun next(): Long = Random(0).nextInt().toLong()
}

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