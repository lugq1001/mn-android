package com.lugq.android.extension

import android.util.Base64
import java.lang.Exception
import java.nio.ByteBuffer
import java.nio.ByteOrder

private val HEX_CHARS = "0123456789ABCDEF".toCharArray()

fun ByteArray.toHexString(): String {
    val result = StringBuffer()
    forEach {
        val octet = it.toInt()
        val firstIndex = (octet and 0xF0).ushr(4)
        val secondIndex = octet and 0x0F
        result.append(HEX_CHARS[firstIndex])
        result.append(HEX_CHARS[secondIndex])
    }
    return result.toString()
}

fun ByteArray.read(pos: Int, length: Int): ByteArray {
    val newBytes = ByteArray(length)
    for ((j, i) in (pos until size).withIndex()) {
        val b = this[i]
        newBytes[j] = b
    }
    return newBytes
}

fun ByteArray.toB64String(): String? {
    try {
        return Base64.encodeToString(this, Base64.DEFAULT)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

object ByteUtils {

    fun merger(vararg values: ByteArray): ByteArray {
        var lengthByte = 0
        for (value in values) {
            lengthByte += value.size
        }
        val allByte = ByteArray(lengthByte)
        var countLength = 0
        for (b in values) {
            System.arraycopy(b, 0, allByte, countLength, b.size)
            countLength += b.size
        }
        return allByte
    }

    // 高位在前，低位在后
    fun int2bytes(int: Int): ByteArray {
        val b = ByteBuffer.allocate(4)
        b.order(ByteOrder.LITTLE_ENDIAN)
        b.putInt(int)
        return b.array()
    }

}

