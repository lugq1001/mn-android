package com.lugq.android.util

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat


object DrawableUtils {


    /***
     * 生成icon
     */
    fun createDrawable(context: Context, @DrawableRes image: Int, @ColorRes color: Int, @DimenRes size: Int): Drawable {
        val iconSize = context.resources.getDimension(size).toInt()
        val drawable = resizeDrawable(context, image, iconSize, iconSize)
        val wrappedDrawable = DrawableCompat.wrap(drawable)
        val colors = ColorStateList.valueOf(ContextCompat.getColor(context, color))
        DrawableCompat.setTintList(wrappedDrawable, colors)
        return wrappedDrawable
    }

    fun tintDrawable(context: Context, drawableId: Int, colorValue: Int): Drawable {
        val res = context.resources
        val drawable = res.getDrawable(drawableId, null).mutate()
        val wrappedDrawable = DrawableCompat.wrap(drawable)
        val colors = ColorStateList.valueOf(colorValue)
        DrawableCompat.setTintList(wrappedDrawable, colors)
        return wrappedDrawable
    }

    fun getDrawable(context: Context, drawableId: Int): Drawable {
        val res = context.resources
        return res.getDrawable(drawableId, null).mutate()
    }


    fun resizeDrawable(context: Context, resId: Int, widthDp: Int, heightDp: Int): Drawable {
        val original = BitmapFactory.decodeResource(context.resources, resId)
        //        int width = AppHelper.dip2px(c, widthDp);
        //        int height = AppHelper.dip2px(c, heightDp);
        val b = Bitmap.createScaledBitmap(original, widthDp, heightDp, false)
        return BitmapDrawable(context.resources, b)
    }

    fun resizeDrawable(context: Context, @DrawableRes image: Int, @DimenRes size: Int): Drawable {
        val icon_size = context.resources.getDimension(size).toInt()
        val original = BitmapFactory.decodeResource(context.resources, image)
        //        int width = AppHelper.dip2px(c, widthDp);
        //        int height = AppHelper.dip2px(c, heightDp);
        val b = Bitmap.createScaledBitmap(original, icon_size, icon_size, false)
        return BitmapDrawable(context.resources, b)
    }


    fun tintBitmap(context: Context, resId: Int, tintColor: Int): Bitmap {
        val inBitmap = BitmapFactory.decodeResource(context.resources, resId)
        val outBitmap = Bitmap.createBitmap(inBitmap.width, inBitmap.height, inBitmap.config)
        val canvas = Canvas(outBitmap)
        val paint = Paint()
        paint.colorFilter = PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(inBitmap, 0f, 0f, paint)
        return outBitmap

    }
}
