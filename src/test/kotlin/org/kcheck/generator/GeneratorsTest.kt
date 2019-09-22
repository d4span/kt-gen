package org.kcheck.generator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class GeneratorsTest {
    @Test
    fun generateIntegerGenerator() {
        Generators.int()
    }

    @Test
    fun generateMultipleIntegerGenerator() {
        val firstList: Generator<Int> = Gen.int()
        val secondList: Generator<Int> = Gen.int()

        assertNotEquals(firstList, secondList)
    }

    @Test
    fun generateIntegers() {
        val firstInt: Int = Gen.int().next()
        val secondInt: Int = Gen.int().next()

        assertEquals(firstInt, secondInt)
    }
}