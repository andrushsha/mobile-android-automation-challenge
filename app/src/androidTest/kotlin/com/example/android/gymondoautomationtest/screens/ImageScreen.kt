package com.example.android.gymondoautomationtest.screens

import com.example.android.gymondoautomationtest.ImageActivity
import com.example.android.gymondoautomationtest.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView

object ImageScreen : KScreen<ImageScreen>() {

    override val layoutId = R.layout.activity_image
    override val viewClass = ImageActivity::class.java

    val backgroundImage = KImageView { withId(R.id.appCompatImageView) }
    val itemText = KTextView { withId(R.id.item_text) }
}