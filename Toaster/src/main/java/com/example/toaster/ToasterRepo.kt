package com.example.toaster

import android.content.Context

object ToasterRepo {

    fun showToast(context: Context, message: String) {
        val toast = android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT)
        toast.show()
    }
}