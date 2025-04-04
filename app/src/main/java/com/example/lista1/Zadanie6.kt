package com.example.lista1

fun komplement(dna: String) = dna.map {
    when (it) {
        'A' -> 'T'
        'T' -> 'A'
        'C' -> 'G'
        'G' -> 'C'
        else -> throw IllegalArgumentException("Nieprawidłowy znak: $it")
    }
}.joinToString("")

fun transkrybuj(dna: String) = dna.map {
    when (it) {
        'A' -> 'U'
        'T' -> 'A'
        'C' -> 'G'
        'G' -> 'C'
        else -> throw IllegalArgumentException("Nieprawidłowy znak: $it")
    }
}.joinToString("")

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