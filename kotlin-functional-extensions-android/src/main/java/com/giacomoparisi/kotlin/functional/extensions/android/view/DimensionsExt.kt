package com.giacomoparisi.kotlin.functional.extensions.android.view

import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.roundToInt


/**
 * This method converts dp unit to equivalent pixels, depending on device density.
 * @author Giacomo Parisi
 * @return A int value to represent px equivalent to dp depending on device density
 */
fun Float.dpToPx(): Int =
        (this * (
                Resources.getSystem()
                        .displayMetrics
                        .densityDpi
                        .toFloat()
                        / DisplayMetrics.DENSITY_DEFAULT))
                .roundToInt()

fun Int.dpToPx(): Int =
        (this * (
                Resources.getSystem()
                        .displayMetrics
                        .densityDpi
                        .toFloat()
                        / DisplayMetrics.DENSITY_DEFAULT))
                .roundToInt()

/**
 * This method converts device specific pixels to density independent pixels.
 * @author Giacomo Parisi
 * @return A int value to represent dp equivalent to px value
 */
fun Float.pxToDp(): Int =
        (this / (
                Resources.getSystem()
                        .displayMetrics
                        .densityDpi
                        .toFloat()
                        / DisplayMetrics.DENSITY_DEFAULT))
                .roundToInt()

fun Int.pxToDp(): Int =
        (this / (
                Resources.getSystem()
                        .displayMetrics
                        .densityDpi
                        .toFloat()
                        / DisplayMetrics.DENSITY_DEFAULT))
                .roundToInt()