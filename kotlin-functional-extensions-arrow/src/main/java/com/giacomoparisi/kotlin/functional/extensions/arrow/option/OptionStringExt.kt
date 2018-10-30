package com.giacomoparisi.kotlin.functional.extensions.arrow.option

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

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