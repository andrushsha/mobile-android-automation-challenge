package com.example.android.gymondoautomationtest.util

import android.view.WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
import android.view.WindowManager.LayoutParams.TYPE_TOAST
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ToastMatcher : TypeSafeMatcher<Root>() {
    public override fun matchesSafely(root: Root): Boolean {
        val type = root.windowLayoutParams.get().type
        if (type == TYPE_TOAST ||type == TYPE_APPLICATION_OVERLAY) {
            val windowToken = root.decorView.windowToken
            val appToken = root.decorView.applicationWindowToken
            if (windowToken === appToken) {
                return true
            }
        }
        return false
    }

    override fun describeTo(description: Description) {
        description.appendText("is toast")
    }
}

internal fun toastMessageDisplayed(text: String) {
    onView(withText(text)).inRoot(ToastMatcher())
        .check(matches(isDisplayed()))
}