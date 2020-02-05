package com.byteslabs.formatik.utils

import android.util.Patterns

object Tools {
    fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isLenthValid(text: String, l: Int = 8): Boolean {
        return text.length >= l
    }
}