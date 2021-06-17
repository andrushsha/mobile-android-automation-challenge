package com.example.android.gymondoautomationtest.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.android.gymondoautomationtest.MainActivity
import com.example.android.gymondoautomationtest.R
import com.example.android.gymondoautomationtest.screens.LoginScreen
import com.example.android.gymondoautomationtest.screens.SearchScreen
import com.example.android.gymondoautomationtest.util.toastMessageDisplayed
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginTest {

    companion object {
        private const val CORRECT_LOGIN = "automation@gymondo.de"
        private const val CORRECT_PWD = "automation"
        private const val BAD_CRED_TEXT = "Username and/or password incorrect"
    }

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun validHint() {
        LoginScreen {
            editEmail.hasHint(R.string.enter_e_mail_here)
            editPassword.hasHint(R.string.enter_password_here)
            loginButton.hasHint(R.string.login)
        }
    }

    @Test
    fun correctCredentials() {
        LoginScreen {
            editEmail.typeText(CORRECT_LOGIN)
            editPassword.typeText(CORRECT_PWD)
            closeSoftKeyboard()
            loginButton.click()
        }
        SearchScreen { }
    }

    @Test
    fun incorrectLogin() {
        LoginScreen {
            editEmail.typeText(CORRECT_LOGIN)
            editPassword.typeText("CORRECT_PWD")
            closeSoftKeyboard()
            loginButton.click()
            toastMessageDisplayed(BAD_CRED_TEXT)
        }
    }

    @Test
    fun incorrectPassword() {
        LoginScreen {
            editEmail.typeText("CORRECT_LOGIN")
            editPassword.typeText(CORRECT_PWD)
            closeSoftKeyboard()
            loginButton.click()
            toastMessageDisplayed(BAD_CRED_TEXT)
        }
    }

    @Test
    fun emptyValues() {
        LoginScreen {
            loginButton.click()
            toastMessageDisplayed(BAD_CRED_TEXT)
        }
    }
}