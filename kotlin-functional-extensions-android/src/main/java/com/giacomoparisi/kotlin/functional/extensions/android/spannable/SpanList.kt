package com.giacomoparisi.kotlin.functional.extensions.android.spannable

import android.content.Context
import android.text.TextPaint
import android.text.style.*
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat

/**
 * Class that represent a list of spans
 */
class SpanList(private val context: Context) : Iterable<Any> {

    private val spans = ArrayList<Any>()

    override fun iterator() = spans.iterator()

    /**
     * Add a TextAppearanceSpan to this SpanList instance
     * @param id The id of the style to apply
     */
    fun appearance(@StyleRes id: Int) =
            spans.add(TextAppearanceSpan(context, id))

    /**
     * Add a AbsoluteSizeSpan to this SpanList instance
     * @param id The id of the dimen resource to apply
     */
    fun size(@DimenRes id: Int) =
            spans.add(AbsoluteSizeSpan(context.resources.getDimension(id).toInt()))

    /**
     * Add a ForegroundColorSpan to this SpanList instance
     * @param id The id of the color to apply
     */
    fun color(@ColorRes id: Int) =
            spans.add(ForegroundColorSpan(ContextCompat.getColor(context, id)))

    /**
     * Add a ImageSpan to this SpanList instance
     * @param id The resource id of the icon
     * @param size The desired size of the icon
     */
    fun icon(@DrawableRes id: Int, size: Int) =
            spans.add(
                    ImageSpan(AppCompatResources.getDrawable(context, id)!!
                            .also {
                                it.setBounds(0, 0, size, size)
                            }))

    /**
     * Add a TypefaceSpan with sans-serif-medium family to this SpanList instance
     */
    fun sansSerifMedium() = typeface("sans-serif-medium")

    /**
     * Add a TypefaceSpan with sans-serif-regular family to this SpanList instance
     */
    fun sansSerifRegular() = typeface("sans-serif-regular")

    /**
     * Add a TypefaceSpan to this SpanList instance
     * @param family The family string of the typeface to apply
     */
    fun typeface(family: String) = spans.add(TypefaceSpan(family))

    /**
     * Add a StyleSpan to this SpanList instance
     * @param style The text style to apply
     */
    fun typeface(style: Int) = spans.add(StyleSpan(style))

    /**
     * Add a ClickableSpan to this SpanList instance
     * that execute the action method when the span is clicked
     * @param action The action to be performed when the user click on the span
     */
    fun click(action: () -> Unit) = spans.add(clickableSpan(action))

    /**
     * Add a custom span to this SpanList instance
     * @param span The custom span instance to add
     */
    fun custom(span: Any) = spans.add(span)
}

/**
 * Builder method for ClickableSpan class
 * @param action The action to be performed when the user click on the span
 * @return The ClickableSpan with the action function mapped to the onClick method
 */
fun clickableSpan(action: () -> Unit) = object : ClickableSpan() {

    override fun onClick(view: View) = action()

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.isUnderlineText = false
    }
}

/**
 * Builder method for SpanList class
 * @param builder Lambda function for the SpanList instance
 * @return The Span instance
 */
fun spanList(context: Context, builder: SpanList.() -> Unit) =
        SpanList(context).apply(builder)