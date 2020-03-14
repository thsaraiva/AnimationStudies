package com.example.animationstudies

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Example of usage of the attribute android:animateLayoutChanges in a layout xml file to enable default animations when adding and removing views
 * to a layout. Tested on LinearLayout and ConstraintLayout and it works just fine.
 */
class AnimateLayoutChangesExampleActivity : AppCompatActivity() {

    private val button1 by lazy { findViewById<Button>(R.id.button1) }
    private val button2 by lazy { findViewById<Button>(R.id.button2) }
    private val button3 by lazy { findViewById<Button>(R.id.button3) }
    private val button4 by lazy { findViewById<Button>(R.id.button4) }
    private val button5 by lazy { findViewById<Button>(R.id.button5) }
    private val button6 by lazy { findViewById<Button>(R.id.button6) }
    private val resetButton by lazy { findViewById<Button>(R.id.reset_button) }
    private val resetButton2 by lazy { findViewById<Button>(R.id.reset_button2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animate_layout_changes_example)

        val leftButtonList = listOf(button1, button2, button3).apply {
            forEach {
                it.setOnClickListener { button ->
                    button.toggleVisibility()
                }
            }
        }
        val rightButtonList = listOf(button4, button5, button6).apply {
            forEach {
                it.setOnClickListener { button ->
                    button.toggleVisibility()
                }
            }
        }

        resetButton.setOnClickListener {
            leftButtonList.forEach { it.visibility = VISIBLE }
        }

        resetButton2.setOnClickListener {
            rightButtonList.forEach { it.visibility = VISIBLE }
        }
    }
}

private fun View.toggleVisibility() {
    if (visibility == VISIBLE) {
        visibility = GONE
    } else if (visibility == GONE) {
        visibility = VISIBLE
    }
}
