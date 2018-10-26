package com.giacomoparisi.kotlin.functional.extensions.core

/**
 * Returns the T object of $ifTrue if the value is true.
 * Otherwise return the the T object of $ifFalse.
 *
 * @author Giacomo Parisi
 * @param ifTrue The object to return when the value is true
 * @param ifFalse The object to return when the value is false
 * @return The correct T object based on the value
 */
fun <T> Boolean.fold(ifFalse: T, ifTrue: T): T =
        if (this) ifTrue else ifFalse

/**
 * Returns the T object from $ifTrue function if the value is true.
 * Otherwise return the the T object from $ifFalse function.
 *
 * @author Giacomo Parisi
 * @param ifTrue The function that return the T object when the value is true
 * @param ifFalse The function that return the T object when the value is false
 * @return The correct T object based on the value
 */
fun <T> Boolean.fold(ifFalse: () -> T, ifTrue: () -> T): T =
        if (this) ifTrue() else ifFalse()

/**
 * Execute the $action function if the value is true.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the value is true
 * @return The source boolean value
 */
fun Boolean.ifTrue(action: () -> Unit): Boolean {
    if (this) action()
    return this
}

/**
 * Execute the $action function if the value is false.
 *
 * @author Giacomo Parisi
 * @param action The function to execute when the value is false
 * @return The source boolean value
 */
fun Boolean.ifFalse(action: () -> Unit): Boolean {
    if (!this) action()
    return this
}
