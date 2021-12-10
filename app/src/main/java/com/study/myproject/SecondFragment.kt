package com.study.myproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.DrawableRes

private var button_left = ""
private var button_right = ""
private var button_left_bottom = ""
private var button_right_bottom = ""


class SecondFragment : Fragment() {

    lateinit var ImageButton_left: ImageButton
    lateinit var ImageButton_right: ImageButton
    lateinit var ImageButton_left_bottom: ImageButton
    lateinit var ImageButton_right_bottom: ImageButton
    private val CartImageList: List<Int> = listOf(
        R.drawable.cherry,
        R.drawable.lemon
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        ImageButton_left = view.findViewById(R.id.ImageButton_left)
        ImageButton_right = view.findViewById(R.id.ImageButton_right)
        ImageButton_left_bottom = view.findViewById(R.id.ImageButton_left_bottom)
        ImageButton_right_bottom = view.findViewById(R.id.ImageButton_right_bottom)



        ImageButton_left.setOnClickListener {
            setEventListener(ImageButton_left, "cherry", R.drawable.cherry)
        }

        ImageButton_right.setOnClickListener {
            setEventListener(ImageButton_right, "lemon", R.drawable.lemon)
        }

        ImageButton_left_bottom.setOnClickListener {
            setEventListener(ImageButton_left_bottom, "lemon", R.drawable.lemon)
        }

        ImageButton_right_bottom.setOnClickListener {
            setEventListener(ImageButton_right_bottom, "cherry", R.drawable.cherry)
        }

        return view


    }

    fun isSecondElementOpened(element: String): Boolean {
        if (ImageButton_right.getTag() == element) return true
        if (ImageButton_left.getTag() == element) return true
        if (ImageButton_left_bottom.getTag() == element) return true
        if (ImageButton_right_bottom.getTag() == element) return true
        return false
    }

    fun closeCards() {
        ImageButton_left.setImageResource(R.drawable.bubble)
        ImageButton_left.setTag("bubble")

        ImageButton_right.setImageResource(R.drawable.bubble)
        ImageButton_right.setTag("bubble")

        ImageButton_left_bottom.setImageResource(R.drawable.bubble)
        ImageButton_left_bottom.setTag("bubble")

        ImageButton_right_bottom.setImageResource(R.drawable.bubble)
        ImageButton_right_bottom.setTag("bubble")
    }

    fun openedCardsCount(): Int {
        var count: Int = 0
        if (ImageButton_left.getTag() == "cherry") count++;
        if (ImageButton_right.getTag() == "lemon") count++;
        if (ImageButton_left_bottom.getTag() == "lemon") count++;
        if (ImageButton_right_bottom.getTag() == "cherry") count++;
        return count;
    }

    fun setEventListener(button: ImageButton, cardName: String, @DrawableRes resID: Int) {
        var openedCards = openedCardsCount()

        if (openedCards == 0) {
            setCardImageAndTag(button, cardName, resID)
        } else if (openedCards == 1) {
            if (button.getTag() == cardName) {
                setCardImageAndTag(button, "bubble", R.drawable.bubble)
            } else {
                setCardImageAndTag(button, cardName, resID)
            }
        } else if (openedCards == 2) {
            if (isSecondElementOpened("cherry") && isSecondElementOpened("lemon")) {
                closeCards()
            } else {
                setCardImageAndTag(button, cardName, resID)
            }
        } else if (openedCards == 3) {
            if (button.getTag() == null || button.getTag() == "bubble") {
                setCardImageAndTag(button, cardName, resID)
            } else if (button.getTag() == cardName) {
                setCardImageAndTag(button, "bubble", R.drawable.bubble)
            }
        } else if (openedCards == 4) {
            closeCards()
        }
    }

    fun setCardImageAndTag(button: ImageButton, cardName: String, @DrawableRes resID: Int) {
        button.setImageResource(resID)
        button.setTag(cardName)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("button_left", button_left)
        outState.putString("button_right", button_right)
        outState.putString("button_left_bottom", button_left_bottom)
        outState.putString("button_right_bottom", button_right_bottom)


    }

}