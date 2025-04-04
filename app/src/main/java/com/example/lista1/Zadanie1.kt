package com.example.lista1

/**
 * Funkcja oblicza pole trójkąta za pomocą wzoru Herona.
 * @param a bok 1 trójkąta.
 * @param b bok 2 trójkąta.
 * @param c bok 3 trójkąta.
 * @throws IllegalArgumentException Rzuca wyjątek, gdy boki nie tworzą trójkąta.
 * @return Pole trójkąta.
 */

 //Kod napisany wzorując się na rozwiązaniu ze strony: https://eduinf.waw.pl/inf/utils/010_2010/0106.php
 //oraz dokumentacji języka Kotlin: https://kotlinlang.org/docs/idioms.html

fun heron(a: Double, b: Double, c: Double): Double {
    if (a <= 0 || b <= 0 || c <= 0) {
        throw IllegalArgumentException("Boki muszą być dodatnie.")
    }

    // Sprawdzenie, czy boki tworzą trójkąt
    if (a + b <= c || a + c <= b || b + c <= a) {
        throw IllegalArgumentException("Boki nie tworzą trójkąta.")
    }

    val s = (a + b + c) / 2  // Półobwód trójkąta
    return Math.sqrt(s * (s - a) * (s - b) * (s - c))  // Wzór Herona
}

fun testHeron() {
    try {
        println(heron(3.0, 4.0, 5.0))  // Prawidłowy trójkąt
        println(heron(1.0, 1.0, 2.0))  // Nieprawidłowy trójkąt
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}