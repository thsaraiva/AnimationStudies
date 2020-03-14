package com.example.animationstudies

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val textview1 by lazy { findViewById<TextView>(R.id.animatedTextView1) }
    private val textview2 by lazy { findViewById<TextView>(R.id.animatedTextView2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objAnimator = animateUsingObjectAnimator()
        animateUsingValueAnimator(objAnimator)

    }

    private fun animateUsingObjectAnimator(): ObjectAnimator {
        return ObjectAnimator.ofFloat(textview2, "translationX", 500f).apply {
            duration = 3000
//            AnimatorSet().play(this).with(ObjectAnimator.ofInt(textview2, "TextColor", 0x000000, 0xFF0000).apply {
//                duration = 3000
//                addUpdateListener { textview2.invalidate() }
//            })
//            start()
        }
    }

    private fun animateUsingValueAnimator(objAnimator: ObjectAnimator) {
        val animator = ValueAnimator.ofFloat(500F).apply {
            duration = 3000
//            repeatCount = 2
//            interpolator = LinearInterpolator()
//            startDelay = 500
            start()
        }

        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                objAnimator.start()
            }
        })

        animator.addUpdateListener {
            //Notifies the occurrence of another frame of the animation.
            println("Update")
            println("animatedFraction = ${it.animatedFraction}")
            println("animatedValue = ${it.animatedValue}")
            println("currentPlayTime = ${it.currentPlayTime}")

            with(it.animatedValue as Float) {
                textview1.translationX = this
//                textview1.setTextColor(this.toInt())
//                textview1.invalidate()

            }
        }
    }
}
