package com.giacomoparisi.kotlin.functional.extensions.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

inline fun postOnUI(crossinline action: () -> Unit) {
    CoroutineScope(Dispatchers.Main).launch { action() }
}