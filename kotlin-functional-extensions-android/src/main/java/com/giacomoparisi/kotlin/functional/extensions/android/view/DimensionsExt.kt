package com.giacomoparisi.kotlin.functional.extensions.android.view

import android.content.res.Resources
import android.util.DisplayMetrics


/**
 * This method converts dp unit to equivalent pixels, depending on device density.
 * @author Giacomo Parisi
 * @return A float value to represent px equivalent to dp depending on device density
 */
fun Float.dpToPx(): Float = this * (
        Resources.getSystem()
                .displayMetrics
                .densityDpi
                .toFloat()
                / DisplayMetrics.DENSITY_DEFAULT)

/**
 * This method converts device specific pixels to density independent pixels.
 * @author Giacomo Parisi
 * @return A float value to represent dp equivalent to px value
 */
fun Float.pxToDp(): Float = this / (
        Resources.getSystem()
                .displayMetrics
                .densityDpi
                .toFloat()
                / DisplayMetrics.DENSITY_DEFAULT)