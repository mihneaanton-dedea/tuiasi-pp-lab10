package ro.tuiasi.pp.lab10

import kotlinx.coroutines.runBlocking
import ro.tuiasi.pp.lab10.factorial.computeFactorials
import ro.tuiasi.pp.lab10.factorial.factorial
import kotlin.test.Test
import kotlin.test.assertEquals

class FactorialTest {

    @Test
    fun `factorial de 0 este 1`() {
        assertEquals(1L, factorial(0))
    }

    @Test
    fun `factorial de 1 este 1`() {
        assertEquals(1L, factorial(1))
    }

    @Test
    fun `factorial de 5 este 120`() {
        assertEquals(120L, factorial(5))
    }

    @Test
    fun `factorial de 10 este 3628800`() {
        assertEquals(3_628_800L, factorial(10))
    }

    @Test
    fun `computeFactorials calculeaza corect pentru 5 6 7 8`() = runBlocking {
        val rezultate = computeFactorials(listOf(5, 6, 7, 8))

        assertEquals(120L, rezultate[5], "5! ar trebui să fie 120")
        assertEquals(720L, rezultate[6], "6! ar trebui să fie 720")
        assertEquals(5040L, rezultate[7], "7! ar trebui să fie 5040")
        assertEquals(40320L, rezultate[8], "8! ar trebui să fie 40320")
    }

    @Test
    fun `computeFactorials returneaza mapa cu toate valorile`() = runBlocking {
        val valori = listOf(1, 2, 3, 4)
        val rezultate = computeFactorials(valori)

        assertEquals(valori.size, rezultate.size, "Map-ul trebuie să conțină toate valorile")
    }

    @Test
    fun `computeFactorials calculeaza corect pentru o singura valoare`() = runBlocking {
        val rezultate = computeFactorials(listOf(6))
        assertEquals(720L, rezultate[6])
    }

    @Test
    fun `computeFactorials returneaza mapa goala pentru input gol`() = runBlocking {
        val rezultate = computeFactorials(emptyList())
        assertEquals(0, rezultate.size)
    }

    @Test
    fun `computeFactorials cu valori mici`() = runBlocking {
        val rezultate = computeFactorials(listOf(0, 1, 2, 3))
        assertEquals(1L, rezultate[0])
        assertEquals(1L, rezultate[1])
        assertEquals(2L, rezultate[2])
        assertEquals(6L, rezultate[3])
    }
}
