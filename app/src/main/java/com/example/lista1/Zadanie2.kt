package com.example.lista1

/**
 * Funkcja zwraca część wspólną dwóch multizbiorów.
 * @param x Pierwszy multizbiór.
 * @param y Drugi multizbiór.
 * @throws IllegalArgumentException Rzuca wyjątek, gdy argumenty są puste.
 * @return Lista wspólnych elementów.
 */

//Kod został napisany za pomocą dokumentacji języka Kotlin: https://kotlinlang.org/docs/collections-overview.html#collection
//oraz strony https://medium.com/@nachare.reena8/mastering-collections-operations-in-kotlin-a-comprehensive-guide-714447d68abc

fun wspolne(x: List<Int>, y: List<Int>): List<Int> {
    if (x.isEmpty() || y.isEmpty()) {
        throw IllegalArgumentException("Listy nie mogą być puste.")
    }
    return x.filter { it in y }
}

fun testWspolne() {
    println("Testy funkcji wspolne:")
    try {
        println("Przykład 1: " + wspolne(listOf(1, 2, 3, 4), listOf(3, 4, 5, 6))) // [3, 4]
        println("Przykład 2: " + wspolne(listOf(7, 8, 9), listOf(1, 2, 3))) // []
        println("Przykład 3: " + wspolne(listOf(1, 1, 2, 2), listOf(2, 2, 3, 3))) // [2, 2]
        println("Przykład 4: " + wspolne(listOf(), listOf(1, 2, 3))) // Powinien wystąpić błąd
    } catch (e: IllegalArgumentException) {
        println("Błąd: ${e.message}")
    }
}