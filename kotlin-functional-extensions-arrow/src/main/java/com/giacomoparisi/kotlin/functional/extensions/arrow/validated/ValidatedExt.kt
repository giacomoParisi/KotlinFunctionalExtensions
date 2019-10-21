package com.giacomoparisi.kotlin.functional.extensions.arrow.validated

import arrow.core.Validated

/**
 * Execute the $action function if the validated object is Valid.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the validated object is Valid
 * @return The source validated object
 */
inline fun <E, T> Validated<E, T>.ifValid(action: (T) -> Unit): Validated<E, T> =
        this.also {
            when (it) {
                is Validated.Valid -> action(it.a)
            }
        }

/**
 * Execute the $action function if the validated object is Valid.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the validated object is Valid
 * @return The source validated object
 */
inline fun <E, T> Validated<E, T>.ifInvalid(action: (E) -> Unit): Validated<E, T> =
        this.also {
            when (it) {
                is Validated.Invalid -> action(it.e)
            }
        }
