package com.example.android.gymondoautomationtest.screens

import com.example.android.gymondoautomationtest.MainActivity
import com.example.android.gymondoautomationtest.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object LoginScreen : KScreen<LoginScreen>() {

    override val layoutId = R.layout.activity_main

    override val viewClass = MainActivity::class.java

    val editEmail = KEditText { withId(R.id.editText) }

    val editPassword = KEditText { withId(R.id.editText2) }

    val loginButton = KButton { withId(R.id.button) }

}