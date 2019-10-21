package com.giacomoparisi.kotlin.functional.extensions.arrow.option

import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse
import com.giacomoparisi.kotlin.functional.extensions.core.ifTrue

/**
 * Execute the $action function if the option value is Some.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the option value is Some
 * @return The source option object
 */
inline fun <T> Option<T>.ifSome(action: (T) -> Unit): Option<T> =
        this.also {
            when (it) {
                is Some -> action(it.t)
            }
        }

/**
 * Execute the $action function if the option value is None.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the option value is None
 * @return The source option object
 */
inline fun <T> Option<T>.ifNone(action: () -> Unit): Option<T> =
        this.also { it.isEmpty().ifTrue { action() } }

/**
 * Fold the option and return a string, using the $action if the option is Some
 * Or empty string if the option is None
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the option value is Some
 * @return Return the string folded value
 */
inline fun <T> Option<T>.foldToString(action: (T) -> String): String =
        this.fold({ "" }) { action(it) }

/**
 * Fold the option to a value, using the value if the option is Some
 * Or empty value if the option is None
 *
 * @author Giacomo Parisi
 * @param value The function to execute when the option value is Some
 * @return Return the folded value
 */
inline fun <A, T> Option<T>.fold(empty: A, value: (T) -> A): A =
        this.fold({ empty }) { value(it) }

/**
 * Get the value if the option is Some
 * Or throw the standard exception if is None
 *
 * @author Giacomo Parisi
 * @return Return the some value of the option
 */
fun <T> Option<T>.getOrException(): T =
        this.getOrElse { throw Throwable("The option value is empty") }

/**
 * Get the value if the option is Some
 * Or throw a custom exception if is None
 *
 * @author Giacomo Parisi
 * @return Return the some value of the option
 */
fun <T> Option<T>.getOrException(throwable: Throwable): T =
        this.getOrElse { throw throwable }
