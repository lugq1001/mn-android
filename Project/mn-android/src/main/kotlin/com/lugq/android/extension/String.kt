package com.lugq.android.extension

import android.net.Uri
import android.text.TextUtils
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.util.regex.Pattern

val String.isIPv4: Boolean
    get() {
        if (TextUtils.isEmpty(this)) {
            return false
        }
        val rexEx = """(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(\d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])"""
        val pattern = Pattern.compile(rexEx)
        val matcher = pattern.matcher(this)
        return matcher.matches()
    }

val String.md5: String
    get() {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

val String.fileSize: String
    get() {
        var int = 0
        try {
            int = this.toInt()
        } catch (e: Exception) {

        }
        val intVal = kotlin.math.max(int, 0)
        val kb = 1024
        val mb: Int = kb * 1024
        val gb: Int = mb * 1024
        return when {
            intVal >= gb -> {
                val g = intVal / gb
                "$g GB"
            }
            intVal >= mb -> {
                val m = intVal / mb
                "$m M"
            }
            intVal >= kb -> {
                val k = intVal / kb
                "$k KB"
            }
            else -> "$intVal B"
        }
    }

fun String.getQueryParameter(name: String): String? {
    try {
        val uri = Uri.parse(this)
        return uri.getQueryParameter(name)
    } catch (e: Exception) {

    }
    return null

}

