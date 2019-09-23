package org.kcheck.generator

import kotlin.random.Random
import kotlin.test.*

class GeneratorsTest {
    @Test
    fun generateIntegerGenerator() {
        Generators.int()
    }

    @Test
    fun generateMultipleIntegerGenerator() {
        val first: Generator<Int> = Gen.int()
        val second: Generator<Int> = Gen.int()

        assertNotEquals(first, second)
    }

    @Test
    fun generateInteger() {
        val firstInt: Int = Gen.int().next()
        val secondInt: Int = Gen.int().next()

        assertEquals(firstInt, secondInt)
    }

    @Test
    fun generatorsAreIterators() {
        val generator: Iterator<Int> = Gen.int()

        assertTrue(generator.hasNext())
    }

    @Test
    fun generatorsTakeSeed() {
        for (seed in 0..1000) {
            val first = Gen.int(seed).next()
            val second = Gen.int(seed).next()

            assertEquals(first, second)
        }
    }

    @Test
    fun sameSeedsGenerateSameNumbers() {
        val seed = 71

        val firstGen = Gen.int(seed)
        val secondGen = Gen.int(seed)

        for (x in 0..1000) {
            val first = firstGen.next()
            val second = secondGen.next()

            assertEquals(first, second)
        }
    }

    @Test
    fun generatorsUseRandom() {
        for (seed in 0..100) {
            val firstGen = Gen.int(seed)
            val random = Random(seed)

            for (i in 0..10) {
                val first = firstGen.next()
                val second = random.nextInt()

                assertEquals(first, second)
            }
        }
    }

    @Test
    fun generatorsAndRandomGenerateTheSameNumbers() {
        val seed = 63

        val firstGen = Gen.int(seed)
        val random = Random(seed)

        for (x in 0..1000) {
            val first = firstGen.next()
            val second = random.nextInt()

            assertEquals(first, second)
        }
    }

    @Test
    @Ignore
    fun generatorsAcceptMapperFunction() {
        val mapper: (Int) -> Long = Int::toLong

        //Gen.int(mapper)
    }
}