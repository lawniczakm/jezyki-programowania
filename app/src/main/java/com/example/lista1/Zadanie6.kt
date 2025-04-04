package com.example.lista1

/**
 * Funkcja zwraca komplementarną nić DNA.
 * Zasady komplementarności:
 * - 'A' (adenina) łączy się z 'T' (tymina)
 * - 'T' (tymina) łączy się z 'A' (adenina)
 * - 'C' (cytozyna) łączy się z 'G' (guanina)
 * - 'G' (guanina) łączy się z 'C' (cytozyna)
 *
 * @param dna Ciąg znaków reprezentujący nić DNA.
 * @return Komplementarna nić DNA.
 * @throws IllegalArgumentException Jeśli sekwencja zawiera nieprawidłowy znak.
 */

//Do napisania kodu posługiwałam się następującymi źródłami:
//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/
//https://kotlinlang.org/docs/control-flow.html#for-loops
//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/
//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/uppercase/

fun komplement(dna: String) = dna.map {
    when (it) {
        'A' -> 'T'
        'T' -> 'A'
        'C' -> 'G'
        'G' -> 'C'
        else -> throw IllegalArgumentException("Nieprawidłowy znak: $it")
    } // fragment kodu zaczerpnięty z : https://exercism.org/tracks/kotlin/exercises/rna-transcription/solutions/BrianLusina
}.joinToString("")

/**
 * Funkcja transkrybuje nić DNA na odpowiadającą jej sekwencję RNA.
 * Zasady transkrypcji:
 * - 'A' (adenina) transkrybuje na 'U' (uracyl)
 * - 'T' (tymina) transkrybuje na 'A' (adenina)
 * - 'C' (cytozyna) transkrybuje na 'G' (guanina)
 * - 'G' (guanina) transkrybuje na 'C' (cytozyna)
 *
 * @param dna Ciąg znaków reprezentujący nić DNA.
 * @return Sekwencja RNA odpowiadająca podanej nici DNA.
 * @throws IllegalArgumentException Jeśli sekwencja zawiera nieprawidłowy znak.
 */
fun transkrybuj(dna: String) = dna.map {
    when (it) {
        'A' -> 'U'
        'T' -> 'A'
        'C' -> 'G'
        'G' -> 'C'
        else -> throw IllegalArgumentException("Nieprawidłowy znak: $it")
    }
}.joinToString("")

/**
 * Funkcja pobiera od użytkownika sekwencję DNA, oblicza jej nić matrycową oraz transkrybuje ją na RNA
 */
fun main() {
    println("Podaj nić DNA:")
    val kodujaca = readLine()?.uppercase() ?: ""

    if (kodujaca.isEmpty()) {
        println("Nie podano żadnej sekwencji.")
        return
    }

    val matrycowa = komplement(kodujaca)
    val rna = transkrybuj(matrycowa)

    println("Nić matrycowa DNA: $matrycowa")
    println("Sekwencja RNA: $rna")
}