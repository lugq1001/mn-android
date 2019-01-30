package com.lugq.android.extension

import java.text.DecimalFormat

val Long.readableFileSize: String
    get() {
        if (this <= 0) return "0"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (Math.log10(this.toDouble()) / Math.log10(1024.0)).toInt()
        return DecimalFormat("#,##0.#").format(this / Math.pow(1024.0, digitGroups.toDouble())) + " " + units[digitGroups]
    }
