package com.lugq.android.extension

import android.text.TextUtils
import java.util.regex.Pattern

fun String.isIp(): Boolean {
    if (TextUtils.isEmpty(this)) {
        return false
    }
    val rexEx = """(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(\d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])"""
    val pattern = Pattern.compile(rexEx)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}