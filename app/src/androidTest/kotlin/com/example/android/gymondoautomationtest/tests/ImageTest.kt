package com.example.android.gymondoautomationtest.tests

import android.content.Intent
import android.os.Bundle
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.android.gymondoautomationtest.ImageActivity
import com.example.android.gymondoautomationtest.R
import com.example.android.gymondoautomationtest.screens.ImageScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ImageTest {

    companion object {

        private const val itemName = "ahaha"

        @JvmStatic
        fun getIntent(): Intent {
            val intent = Intent(
                ApplicationProvider.getApplicationContext(),
                ImageActivity::class.java
            )
            val bundle = Bundle()
            bundle.putString("Item name", itemName)
            intent.putExtras(bundle)
            return intent
        }

    }

    @Rule
    @JvmField
    val activityScenarioRule = ActivityScenarioRule<ImageActivity>(getIntent())

    @Test
    fun ui() {
        ImageScreen {
            itemText.hasText(itemName)
            backgroundImage.hasDrawable(R.drawable.iphone_x_en_01)
        }

    }
}