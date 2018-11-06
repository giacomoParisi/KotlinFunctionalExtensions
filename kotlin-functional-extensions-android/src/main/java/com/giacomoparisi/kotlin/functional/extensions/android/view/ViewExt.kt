package com.giacomoparisi.kotlin.functional.extensions.android.view

import android.view.View

/**
 * Set the view visibility to VISIBLE if the $visible param is true
 * Else set the view visibility to GONE
 * @author Giacomo Parisi
 * @return The updated view reference
 */
fun View.visibleOrGone(visible: Boolean): View {
    this.visibility = if(visible) View.VISIBLE else View.GONE
    return this
}

/**
 * Set the view visibility to VISIBLE if the $visible param is true
 * Else set the view visibility to INVISIBLE
 * @author Giacomo Parisi
 * @return The updated view reference
 */
fun View.visibleOrInvisible(visible: Boolean): View {
    this.visibility = if(visible) View.VISIBLE else View.INVISIBLE
    return this
}