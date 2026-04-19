package ro.tuiasi.pp.lab10.factory

/**
 * Factory producer — returnează factory-ul potrivit în funcție de tipul cerut.
 *
 * Tipuri acceptate:
 * - `"ELITE"` → [EliteFactory]
 * - `"HAPPY_WORKER"` → [HappyWorkerFactory]
 */
object FactoryProducer {

    /**
     * Returnează factory-ul corespunzător tipului specificat.
     *
     * @param type Tipul factory-ului: `"ELITE"` sau `"HAPPY_WORKER"`
     * @return Factory-ul corespunzător
     * @throws IllegalArgumentException dacă tipul nu este recunoscut
     */
    fun getFactory(type: String): Factory {
        // TODO("De implementat")
        // Folosiți when(type.uppercase()) pentru a returna factory-ul corespunzător:
        // "ELITE" → EliteFactory()
        // "HAPPY_WORKER" → HappyWorkerFactory()
        // else → throw IllegalArgumentException("Tip factory necunoscut: $type")
        TODO("De implementat: returnează factory-ul corespunzător tipului 'ELITE' sau 'HAPPY_WORKER'")
    }
}
