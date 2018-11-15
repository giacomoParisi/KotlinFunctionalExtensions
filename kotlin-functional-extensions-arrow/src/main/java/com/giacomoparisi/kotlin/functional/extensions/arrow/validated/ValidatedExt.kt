package com.giacomoparisi.kotlin.functional.extensions.arrow.validated

import arrow.data.Validated

/**
 * Execute the $action function if the validated object is Valid.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the validated object is Valid
 * @return The source validated object
 */
inline fun <E, T> Validated<E, T>.ifValid(action: (T) -> Unit): Validated<E, T> {
    when (this) {
        is Validated.Valid -> action(this.a)
    }
    return this
}

/**
 * Execute the $action function if the validated object is Valid.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the validated object is Valid
 * @return The source validated object
 */
inline fun <E, T> Validated<E, T>.ifInvalid(action: (E) -> Unit): Validated<E, T> {
    when (this) {
        is Validated.Invalid -> action(this.e)
    }
    return this
}
