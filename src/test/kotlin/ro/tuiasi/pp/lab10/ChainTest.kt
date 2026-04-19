package ro.tuiasi.pp.lab10

import kotlinx.coroutines.runBlocking
import ro.tuiasi.pp.lab10.chain.*
import ro.tuiasi.pp.lab10.factory.FactoryProducer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ChainTest {

    /**
     * Construiește lanțul complet: CEO → Executive → Manager → HappyWorker
     * cu legăturile next și previous configurate.
     */
    private fun construiesteeLant(): CEOHandler {
        val ceo = CEOHandler()
        val executive = ExecutiveHandler()
        val manager = ManagerHandler()
        val worker = HappyWorkerHandler()

        // Configurare lanț descendent (next)
        ceo.next = executive
        executive.next = manager
        manager.next = worker

        // Configurare lanț ascendent (previous)
        executive.previous = ceo
        manager.previous = executive
        worker.previous = manager

        return ceo
    }

    @Test
    fun `handleRequest returneaza un sir nevid`() = runBlocking {
        val ceo = construiesteeLant()
        val rezultat = ceo.handleRequest("mesaj test")
        assertTrue(rezultat.isNotBlank(), "handleRequest() nu ar trebui să returneze un șir gol")
    }

    @Test
    fun `handleRequest raspunsul contine Response`() = runBlocking {
        val ceo = construiesteeLant()
        val rezultat = ceo.handleRequest("test")
        assertTrue(rezultat.contains("Response"),
            "Răspunsul final ar trebui să conțină 'Response', dar a primit: $rezultat")
    }

    @Test
    fun `handleRequest raspunsul contine mesajul original`() = runBlocking {
        val ceo = construiesteeLant()
        val rezultat = ceo.handleRequest("comanda-importanta")
        assertTrue(rezultat.contains("comanda-importanta"),
            "Răspunsul ar trebui să conțină mesajul original, dar a primit: $rezultat")
    }

    @Test
    fun `handleRequest format Request in mesaj catre worker`() = runBlocking {
        // Verificăm că HappyWorkerHandler primește un mesaj cu "Request - "
        val workerPrins = object : Handler {
            override var next: Handler? = null
            override var previous: Handler? = null
            var mesajPrimit: String = ""
            override suspend fun handleRequest(message: String): String {
                mesajPrimit = message
                return "Response - $message"
            }
        }

        val ceo = CEOHandler()
        ceo.next = workerPrins

        ceo.handleRequest("test")

        assertTrue(workerPrins.mesajPrimit.startsWith("Request - "),
            "Handler-ul următor ar trebui să primească un mesaj care începe cu 'Request - '")
    }

    // ----- FactoryProducer -----

    @Test
    fun `FactoryProducer returneaza EliteFactory pentru ELITE`() {
        val factory = FactoryProducer.getFactory("ELITE")
        val handler = factory.createHandler()
        assertNotNull(handler)
        assertTrue(handler is CEOHandler,
            "EliteFactory ar trebui să creeze un CEOHandler")
    }

    @Test
    fun `FactoryProducer returneaza HappyWorkerFactory pentru HAPPY_WORKER`() {
        val factory = FactoryProducer.getFactory("HAPPY_WORKER")
        val handler = factory.createHandler()
        assertNotNull(handler)
        assertTrue(handler is HappyWorkerHandler,
            "HappyWorkerFactory ar trebui să creeze un HappyWorkerHandler")
    }

    @Test
    fun `FactoryProducer accepta tipul in lowercase`() {
        val factory = FactoryProducer.getFactory("elite")
        assertNotNull(factory)
    }
}
