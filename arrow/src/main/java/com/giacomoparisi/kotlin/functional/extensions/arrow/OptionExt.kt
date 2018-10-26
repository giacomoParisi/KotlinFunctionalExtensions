package com.giacomoparisi.kotlin.functional.extensions.arrow

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import com.giacomoparisi.kotlin.functional.extensions.core.ifTrue

/**
 * Execute the $action function if the option value is Some.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the option value is Some
 */
fun <T> Option<T>.ifSome(action: (T) -> Unit) {
    when (this) {
        is Some -> action(this.t)
    }
}

/**
 * Execute the $action function if the option value is None.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the option value is None
 */
fun <T> Option<T>.ifNone(action: () -> Unit) {
    this.isEmpty().ifTrue { action() }
}

/**
 * Execute the $ifSome function if the option value is Some.
 * Otherwise execute the $ifNone function.
 *
 * @author Giacomo Parisi
 * @param ifSome The function to execute when the option value is Some
 * @param ifNone The function to execute when the option value is None
 */
fun <T> Option<T>.Match(ifSome: (T) -> Unit, ifNone: () -> Unit) {
    when (this) {
        is Some -> ifSome(this.t)
        is None -> ifNone()
    }
}

/**
 * Fold the option and return a string, using the $action if the option is Some
 * Or empty string if the option is None
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the option value is Some
 * @return Return the string folded value
 */
fun <T> Option<T>.foldToString(action: (T) -> String): String =
        this.fold({ "" }) { action(it) }
