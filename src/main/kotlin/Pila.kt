package org.iesra.revilofe

import org.iesra.revilofe.un4.eje4_4.reverse

class Pila<T> : Iterable<T> {

    private val elementos = mutableListOf<T>()

    fun push(elemento: T) {
        elementos.add(elemento)
    }

    fun pop(): T {
        if (elementos.isEmpty()) {
            throw NoSuchElementException("La pila está vacía")
        }
        return elementos.removeAt(elementos.size - 1)
    }

    fun peek(): T {
        if (elementos.isEmpty()) {
            throw NoSuchElementException("La pila está vacía")
        }
        return elementos[elementos.size - 1]
    }

    fun isEmpty(): Boolean {
        return elementos.isEmpty()
    }

    val size: Int
        get() = elementos.size

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {

            private var indice = elementos.size - 1

            override fun hasNext(): Boolean {
                return indice >= 0
            }

            override fun next(): T {
                return elementos[indice--]
            }
        }
    }
}

fun <T> reverse(lista: List<T>): List<T> {

    val pila = Pila<T>()

    val iterator = lista.iterator()

    while (iterator.hasNext()) {
        pila.push(iterator.next())
    }

    val resultado = mutableListOf<T>()

    while (!pila.isEmpty()) {
        resultado.add(pila.pop())
    }

    return resultado
}

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbersRev = reverse(numbers)

    if (listOf("four", "three", "two", "one") != numbersRev) {
        println("Error")
    } else {
        println("Correcto")
    }

    println(numbersRev)
}
