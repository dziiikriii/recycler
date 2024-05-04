package com.example.recyclercrd

import android.view.View
import android.view.animation.AnimationUtils
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

class VIewExt {
    fun View.slideDown(animTime: Long, startOffset: Long) {
        val slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down).apply {
            duration = animTime
            interpolator = FastOutSlowInInterpolator()
            this.startOffset = startOffset
        }
        startAnimation(slideDown)
    }
}