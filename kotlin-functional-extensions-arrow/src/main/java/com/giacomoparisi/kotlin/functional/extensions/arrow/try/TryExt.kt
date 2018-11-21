package com.giacomoparisi.kotlin.functional.extensions.arrow.`try`

import arrow.core.Failure
import arrow.core.Success
import arrow.core.Try

/**
 * Execute the $action function if the try value is Success.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the try value is Success
 * @return The source try object
 */
inline fun <T> Try<T>.ifSuccess(action: (T) -> Unit): Try<T> =
        this.also {
            when (it) {
                is Success -> action(it.value)
            }
        }

/**
 * Execute the $action function if the try value is Failure.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the try value is Failure
 * @return The source try object
 */
inline fun <T> Try<T>.ifFailure(action: (throwable: Throwable) -> Unit): Try<T> =
        this.also {
            when (it) {
                is Failure -> action(it.exception)
            }
        }

/**
 * Fold the try and return a string, using the $action if the try is Success
 * Or the message of the throwable if the try is Failure
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the try value is Success
 * @return Return the string folded value
 */
inline fun <T> Try<T>.foldToMessage(action: (T) -> String): String =
        this.fold({ it.message.orEmpty() }) { action(it) }
