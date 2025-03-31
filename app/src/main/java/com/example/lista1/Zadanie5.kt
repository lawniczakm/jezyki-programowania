package com.example.lista1

/**
 * Funkcja oblicza kolejne elementy ciągu Collatza dla zadanej liczby naturalnej c0.
 * @param c0 Liczba naturalna, od której rozpoczynamy ciąg.
 * @return Lista kolejnych elementów ciągu Collatza.
 * @throws IllegalArgumentException Jeśli c0 jest liczbą mniejszą niż 1.
 */

//Kod napisany przy pomocy stron: https://pl.wikipedia.org/wiki/Problem_Collatza?utm_source=chatgpt.com,
fun collatz(c0: Int): List<Int> {
    require(c0 >= 1) { "Liczba początkowa musi być większa lub równa 1." }

    val sequence = mutableListOf(c0)
    var current = c0

    while (current != 1) {
        current = if (current % 2 == 0) {
            current / 2
        } else {
            3 * current + 1
        }
        sequence.add(current)
    }  // fragment kodu zaczerpnięty z: https://exercism.org/tracks/kotlin/exercises/collatz-conjecture/solutions/JEphron

    return sequence
}

/**
 * Funkcja testująca poprawność działania funkcji collatz.
 * Dla kilku wartości początkowych c0 wyświetla wygenerowany ciąg Collatza.
 */

fun testCollatz() {
    val testValues = listOf(6, 11, 15, 27)

    for (value in testValues) {
        println("Ciąg Collatza dla c0 = $value:")
        val sequence = collatz(value)
        println(sequence.joinToString(" -> "))
        println("Długość ciągu: ${sequence.size}")
        println("Maksymalna wartość w ciągu: ${sequence.maxOrNull()}")
        println()
    }
}

fun main() {
    testCollatz()
}