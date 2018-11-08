package com.giacomoparisi.kotlin.functional.extensions.arrow.option

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.some

/**
 * Return the string value if the option is Some
 * Or empty string if the option is None
 *
 * @author Giacomo Parisi
 * @return Return the string folded value
 */
fun Option<String>.getOrEmpty(): String =
        when (this) {
            is Some -> this.t
            is None -> ""
        }

/**
 * Return an Option of the source string if the string is not empty
 * Or None if the source string is empty
 *
 * @author Giacomo Parisi
 * @return Return the Option of the string with None value if the string is empty
 */
fun String.emptyToNone(): Option<String> =
        if(this.isEmpty()) None else this.some()

/**
 * Return an Option of the source string if the string is not blank
 * Or None if the source string is blank
 *
 * @author Giacomo Parisi
 * @return Return the Option of the string with None value if the string is blank
 */
fun String.blankToNone(): Option<String> =
        if(this.isBlank()) None else this.some()

/**
 * Return an Option of the source string if the string is not empty and not blank
 * Or None if the source string is empty or blank
 *
 * @author Giacomo Parisi
 * @return Return the Option of the string with None value if the string is empty or blank
 */
fun String.emptyAndBlankToNone(): Option<String> =
        if(this.isEmpty() || this.isBlank()) None else this.some()