package com.example.animationstudies

import android.animation.LayoutTransition.CHANGING
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Example of usage of the attribute android:animateLayoutChanges in a layout xml file to enable default animations when adding and removing views
 * to a layout. Tested on LinearLayout and ConstraintLayout and it works just fine.
 *
 * Use ViewGroup.setLayoutTransition( LayoutTransition ) so that changes in layout which occur because of children being added to or removed from
 * the ViewGroup are animated according to the animations defined in that LayoutTransition parameter.
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
    private val changeTextButton by lazy { findViewById<Button>(R.id.change_text_button) }
    private val rightContainer by lazy { findViewById<ViewGroup>(R.id.right_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animate_layout_changes_example)

        /**
         * This is the important bit to make animations that are not related to adding or removing views from a layout work.
         * Things like size changes get animated when this is set and "android:animateLayoutChanges="true"" is present in the xml layout file in the
         * view group.
         */
        rightContainer.layoutTransition.enableTransitionType(CHANGING)

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

        changeTextButton.setOnClickListener {
            if ((Math.random() * 10).toInt() % 2 == 0)
                button4.text = "Very Long text"
            else
                button4.text = "text"

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
