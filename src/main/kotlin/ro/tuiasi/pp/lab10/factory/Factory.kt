package ro.tuiasi.pp.lab10.factory

import ro.tuiasi.pp.lab10.chain.Handler

/**
 * Interfață Abstract Factory pentru crearea handler-elor din lanț.
 *
 * Respectă principiul deschis/închis (OCP): noi tipuri de handler-e
 * se adaugă prin noi implementări ale acestei interfețe.
 */
interface Factory {
    /**
     * Creează și returnează un handler corespunzător tipului de factory.
     *
     * @return Un handler nou, configurat conform tipului factory
     */
    fun createHandler(): Handler
}
