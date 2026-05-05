package ro.tuiasi.pp.lab10.chain

import kotlinx.coroutines.delay

/**
 * Handler de nivel manager — intermediar între Executive și HappyWorker.
 *
 * Primește cererea de la Executive, o procesează asincron și o transmite
 * mai departe spre HappyWorker.
 */
class ManagerHandler : Handler {

    override var next: Handler? = null
    override var previous: Handler? = null

    /**
     * Procesează cererea și o pasează mai departe în lanț.
     *
     * @param message Mesajul primit de la Executive
     * @return Răspunsul primit de la HappyWorker
     */
    override suspend fun handleRequest(message: String): String {
        delay(100)
        val cerere = "Request - $message"
        println("[Manager] Trimit cererea: $cerere")
        val raspuns = next?.handleRequest(cerere) ?: "Response - $message"
        println("[Manager] Am primit răspunsul: $raspuns")
        return raspuns
    }
}
