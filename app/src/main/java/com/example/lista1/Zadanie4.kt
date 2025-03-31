package com.example.lista1

/**
 * Funkcja zwraca listę n pierwszych liczb ciągu Fibonacciego.
 * @param n liczba określająca, ile elementów ciągu zwrócić.
 * @return lista n pierwszych liczb ciągu Fibonacciego.
 * @throws IllegalArgumentException jeśli n jest mniejsze od 1.
 */

//Kod został napisany z pomocą następujących stron: https://mattomatti.com/pl/a02 oraz https://www.reddit.com/r/Kotlin/comments/sdb2h9/tail_recursion_beats_fibonacci_memoization_kotlin/

fun fibonacciIteracyjnie(n: Int): List<Int> {
    require(n >= 1) { "Liczba elementów musi być większa lub równa 1" } // Sprawdzenie warunku początkowego

    val fibList = mutableListOf(0, 1) // Inicjalizacja listy z pierwszymi dwoma liczbami ciągu
    for (i in 2 until n) { // Pętla iteracyjna od 2 do n-1
        val nextFib = fibList[i - 1] + fibList[i - 2] // Obliczenie kolejnej liczby jako sumy dwóch poprzednich
        fibList.add(nextFib) // Dodanie obliczonej liczby do listy
    }
    return fibList.take(n) // Zwrócenie pierwszych n liczb ciągu
}

/**
 * Funkcja zwraca n-tą liczbę ciągu Fibonacciego.
 * @param n indeks liczby w ciągu Fibonacciego do zwrócenia.
 * @return n-ta liczba ciągu Fibonacciego.
 * @throws IllegalArgumentException jeśli n jest mniejsze od 0.
 */

fun fibonacciRekurencyjnie(n: Int): Int {
    require(n >= 0) { "Indeks musi być liczbą nieujemną" } // Sprawdzenie warunku początkowego

    return when (n) {
        0 -> 0 // Definicja bazowa: F(0) = 0
        1 -> 1 // Definicja bazowa: F(1) = 1
        else -> fibonacciRekurencyjnie(n - 1) + fibonacciRekurencyjnie(n - 2) // Rekurencyjne wywołanie funkcji
    }
}

fun main() {
    // Testy dla funkcji iteracyjnej
    println("Testy dla funkcji iteracyjnej:")
    println(fibonacciIteracyjnie(1)) // Oczekiwane: [0]
    println(fibonacciIteracyjnie(5)) // Oczekiwane: [0, 1, 1, 2, 3]
    println(fibonacciIteracyjnie(10)) // Oczekiwane: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

    // Testy dla funkcji rekurencyjnej
    println("\nTesty dla funkcji rekurencyjnej:")
    println(fibonacciRekurencyjnie(0)) // Oczekiwane: 0
    println(fibonacciRekurencyjnie(1)) // Oczekiwane: 1
    println(fibonacciRekurencyjnie(5)) // Oczekiwane: 5
    println(fibonacciRekurencyjnie(10)) // Oczekiwane: 55
}