package com.example.lista1

/**
 * Funkcja zwraca wszystkie podzbiory zbioru.
 * @param x Zbiór wejściowy.
 * @return Lista wszystkich podzbiorów.
 */

// Do rozwiązania zadania posłużyły mi następujące strony:
// - algorytm generowania wszystkich podzbiorów: http://algorytmika.wikidot.com/exponential-subset
// - dyskusja na temat algorytmu znajdywania wszystkich podzbiorów: https://4programmers.net/Forum/Inne/167256-Algorytm_znajdywania_wszystkich_podzbiorow_danego_zbioru


fun <T> podzbiory(x: Set<T>?): List<Set<T>> {
    requireNotNull(x) { "Zbiór wejściowy nie może być pusty." }

    val lista = x.toList()
    val liczbaPodzbiorów = 1 shl lista.size // 2^n
    val wynik = mutableListOf<Set<T>>()

    for (i in 0 until liczbaPodzbiorów) {
        val podzbiór = mutableSetOf<T>()
        for (j in lista.indices) {
            if (i and (1 shl j) != 0) {
                podzbiór.add(lista[j])
            }
        }
        wynik.add(podzbiór)
    }
    return wynik
}

fun main() {
    // Przykład 1: Zbiór pusty
    val zbiór1 = emptySet<Char>()
    val podzbioryZbioru1 = podzbiory(zbiór1)
    println("Podzbiory zbioru $zbiór1 to:")
    for (podzbiór in podzbioryZbioru1) {
        println(podzbiór)
    }

    // Przykład 2: Zbiór z jednym elementem
    val zbiór2 = setOf('a')
    val podzbioryZbioru2 = podzbiory(zbiór2)
    println("\nPodzbiory zbioru $zbiór2 to:")
    for (podzbiór in podzbioryZbioru2) {
        println(podzbiór)
    }

    // Przykład 3: Zbiór z dwoma elementami
    val zbiór3 = setOf('a', 'b')
    val podzbioryZbioru3 = podzbiory(zbiór3)
    println("\nPodzbiory zbioru $zbiór3 to:")
    for (podzbiór in podzbioryZbioru3) {
        println(podzbiór)
    }

    // Przykład 4: Zbiór z trzema elementami
    val zbiór4 = setOf('a', 'b', 'c')
    val podzbioryZbioru4 = podzbiory(zbiór4)
    println("\nPodzbiory zbioru $zbiór4 to:")
    for (podzbiór in podzbioryZbioru4) {
        println(podzbiór)
    }

    // Przykład 5: Zbiór z czterema elementami
    val zbiór5 = setOf('a', 'b', 'c', 'd')
    val podzbioryZbioru5 = podzbiory(zbiór5)
    println("\nPodzbiory zbioru $zbiór5 to:")
    for (podzbiór in podzbioryZbioru5) {
        println(podzbiór)
    }
}
