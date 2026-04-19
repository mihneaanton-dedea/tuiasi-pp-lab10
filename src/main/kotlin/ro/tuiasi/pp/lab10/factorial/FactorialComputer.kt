package ro.tuiasi.pp.lab10.factorial

import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * Modul de calcul factorial paralel folosind corutine și canale.
 *
 * Arhitectura:
 * - Un `Channel<Int>` produs cu toate valorile din input
 * - 4 corutine consumatoare care calculează factorial în paralel
 * - Rezultatele sunt colectate într-un `Map<Int, Long>`
 */

/**
 * Calculează factorial pentru fiecare valoare din [values] folosind 4 corutine paralele.
 *
 * Fiecare valoare este preluată dintr-un canal de lucru de una dintre cele 4 corutine,
 * calculul este efectuat și rezultatul este stocat în map-ul final.
 *
 * @param values Lista de valori pentru care se calculează factorial
 * @return Map cu perechile n → n!
 */
suspend fun computeFactorials(values: List<Int>): Map<Int, Long> = coroutineScope {
    // TODO("De implementat")
    // Pași de urmat:
    //
    // 1. Creați un canal de lucru: val canal = Channel<Int>(capacity = values.size)
    //
    // 2. Trimiteți toate valorile în canal și închideți-l:
    //    launch {
    //        for (v in values) canal.send(v)
    //        canal.close()
    //    }
    //
    // 3. Creați un map thread-safe pentru rezultate:
    //    val rezultate = java.util.concurrent.ConcurrentHashMap<Int, Long>()
    //
    // 4. Lansați 4 corutine consumatoare:
    //    val joburi = (1..4).map {
    //        async {
    //            for (n in canal) {
    //                rezultate[n] = factorial(n)
    //            }
    //        }
    //    }
    //
    // 5. Așteptați terminarea tuturor corutinelor:
    //    joburi.forEach { it.await() }
    //
    // 6. Returnați rezultatele:
    //    rezultate
    TODO("De implementat: 4 corutine consumatoare calculează factorial din canal de lucru")
}

/**
 * Calculează n! (factorial) pentru un număr natural n.
 *
 * @param n Numărul pentru care se calculează factorial (n >= 0)
 * @return Valoarea n! ca Long
 */
fun factorial(n: Int): Long {
    // TODO("De implementat")
    // Indiciu: folosiți fold sau o buclă for
    // factorial(0) = 1
    // factorial(n) = n * factorial(n-1)
    TODO("De implementat: calculează n! iterativ sau recursiv")
}
