package com.giacomoparisi.kotlin.functional.extensions.arrow

import arrow.core.Failure
import arrow.core.Success
import arrow.core.Try
import com.giacomoparisi.kotlin.functional.extensions.core.ifTrue

/**
 * Execute the $action function if the try value is Success.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the try value is Success
 * @return The source try object
 */
fun <T> Try<T>.ifSuccess(action: (T) -> Unit): Try<T> {
    when (this
        ) {
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
fun <T> Try<T>.ifFailure(action: () -> Unit): Try<T> {
    this.isFailure().ifTrue { action() }
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
fun <T> Try<T>.Match(ifSuccess: (T) -> Unit, ifFailure: () -> Unit): Try<T> {
    when (this) {
        is Success -> ifSuccess(this.value)
        is Failure -> ifFailure()
    }
    return this
}

/**
 * Fold the try and return a string, using the $action if the try is Success
 * Or empty string if the try is Failure
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the try value is Success
 * @return Return the string folded value
 */
fun <T> Try<T>.foldToString(action: (T) -> String): String =
        this.fold({ "" }) { action(it) }
