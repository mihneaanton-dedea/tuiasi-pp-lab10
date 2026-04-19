package ro.tuiasi.pp.lab10

import ro.tuiasi.pp.lab10.pipeline.PipelineProcessor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PipelineTest {

    private val procesor = PipelineProcessor()

    @Test
    fun `process inmulteste si sorteaza corect exemplul din enunt`() {
        // process(listOf(3, 1, 2), alpha=2) → [2, 4, 6]
        val rezultat = procesor.process(listOf(3, 1, 2), alpha = 2)
        assertEquals(listOf(2, 4, 6), rezultat)
    }

    @Test
    fun `process returneaza lista goala pentru input gol`() {
        val rezultat = procesor.process(emptyList(), alpha = 5)
        assertTrue(rezultat.isEmpty())
    }

    @Test
    fun `process cu alpha 1 pastreaza valorile sortate`() {
        val rezultat = procesor.process(listOf(5, 3, 1, 4, 2), alpha = 1)
        assertEquals(listOf(1, 2, 3, 4, 5), rezultat)
    }

    @Test
    fun `process cu alpha 3`() {
        // [4, 2, 1] × 3 = [12, 6, 3] → sortat: [3, 6, 12]
        val rezultat = procesor.process(listOf(4, 2, 1), alpha = 3)
        assertEquals(listOf(3, 6, 12), rezultat)
    }

    @Test
    fun `process un singur element`() {
        val rezultat = procesor.process(listOf(7), alpha = 4)
        assertEquals(listOf(28), rezultat)
    }

    @Test
    fun `process pastreaza dimensiunea listei`() {
        val input = listOf(10, 5, 8, 2, 7)
        val rezultat = procesor.process(input, alpha = 2)
        assertEquals(input.size, rezultat.size)
    }

    @Test
    fun `process produce lista sortata crescator`() {
        val rezultat = procesor.process(listOf(9, 1, 5, 3, 7), alpha = 1)
        assertEquals(rezultat.sorted(), rezultat)
    }
}
