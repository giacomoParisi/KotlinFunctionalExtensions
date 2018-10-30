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
fun <T> Try<T>.ifSuccess(action: (T) -> Unit): Try<T> {
    when (this) {
        is Success -> action(this.value)
    }
    return this
}

/**
 * Execute the $action function if the try value is Failure.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the try value is Failure
 * @return The source try object
 */
fun <T> Try<T>.ifFailure(action: (throwable: Throwable) -> Unit): Try<T> {
    when (this) {
        is Failure -> action(this.exception)
    }
    return this
}

/**
 * Execute the $ifSuccess function if the try value is Success.
 * Otherwise execute the $ifFailure function.
 *
 * @author Giacomo Parisi
 * @param ifSuccess The function to execute when the try value is Success
 * @param ifFailure The function to execute when the try value is Failure
 * @return The source try object
 */
fun <T> Try<T>.Match(ifSuccess: (T) -> Unit, ifFailure: (throwable: Throwable) -> Unit): Try<T> {
    when (this) {
        is Success -> ifSuccess(this.value)
        is Failure -> ifFailure(this.exception)
    }
    return this
}

/**
 * Fold the try and return a string, using the $action if the try is Success
 * Or the message of the throwable if the try is Failure
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the try value is Success
 * @return Return the string folded value
 */
fun <T> Try<T>.foldToMessage(action: (T) -> String): String =
        this.fold({ it.message.orEmpty() }) { action(it) }
