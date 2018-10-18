package com.lugq.android.extension

import android.text.TextUtils
import java.math.BigInteger
import java.security.MessageDigest
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

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}


fun String.getUrlParameter(name: String): String? {
    var result: String? = null
    val index = this.indexOf("?")
    val temp = this.substring(index + 1)
    val keyValue = temp.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (str in keyValue) {
        if (str.startsWith(name)) {
            result = str.replace("$name=", "")
        }
    }
    return result
}