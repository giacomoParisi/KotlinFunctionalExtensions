package com.giacomoparisi.kotlin.functional.extensions.arrow.either

import arrow.core.*

/**
 * Execute the $action function if the either value is Left.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the either value is Left
 * @return The source either object
 */
inline fun <T, A> Either<T, A>.ifLeft(action: (T) -> Unit): Either<T, A> =
        this.also {
            when (it) {
                is Either.Left -> action(it.a)
            }
        }


/**
 * Execute the $action function if the either value is Right.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the either value is Right
 * @return The source either object
 */
inline fun <T, A> Either<T, A>.ifRight(action: (value: A) -> Unit): Either<T, A> =
        this.also {
            when (it) {
                is Either.Right -> action(it.b)
            }
        }

/**
 * Mapping the either value to option:
 * - Failure to None
 * - Success to Some
 *
 * @author Giacomo Parisi
 * @return The option value
 */
fun <T, A> Either<T, A>.failureToNone(): Option<A> = this.orNull().toOption()

/**
 * Execute the f function and return a Left value if f throw an exception
 * or Right if f return without errors
 *
 * @author Giacomo Parisi
 * @return The either value that wrap the return type of f
 */
inline fun <T> catch(f: () -> T): Either<Throwable, T> =
        try {
            f().right()
        } catch (throwable: Throwable) {
            throwable.left()
        }
