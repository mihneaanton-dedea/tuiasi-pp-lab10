package ro.tuiasi.pp.lab10.chain

/**
 * Interfață de bază pentru handler-ele din lanțul dublu de responsabilitate.
 *
 * Fiecare handler poate delega cererea mai departe (`next`) și poate primi
 * răspunsul înapoi de la handler-ul anterior (`previous`).
 *
 * `handleRequest` este `suspend fun` — execuția este asincronă cu corutine.
 */
interface Handler {
    /** Handler-ul următor din lanț (spre HappyWorker) */
    var next: Handler?

    /** Handler-ul anterior din lanț (spre CEO) */
    var previous: Handler?

    /**
     * Procesează mesajul și returnează răspunsul.
     *
     * @param message Mesajul de procesat
     * @return Răspunsul după procesare
     */
    suspend fun handleRequest(message: String): String
}
