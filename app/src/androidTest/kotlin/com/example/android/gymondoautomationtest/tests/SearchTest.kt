package com.example.android.gymondoautomationtest.tests

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.android.gymondoautomationtest.ListActivity
import com.example.android.gymondoautomationtest.R
import com.example.android.gymondoautomationtest.screens.SearchScreen
import io.github.kakaocup.kakao.intent.KIntent
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SearchTest {

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(ListActivity::class.java)

    @Test
    fun ui() {
        val expectedListSize = 30
        SearchScreen {
            editSearch.hasHint(R.string.search_for_exercise)
            closeSoftKeyboard()
            recycler {
                Assert.assertEquals(expectedListSize, getSize())
            }
        }
    }

    @Test
    fun searchMultiple() {
        SearchScreen {
            editSearch.typeText("q")
            btnSearch.click()
            Assert.assertNotEquals(30, recycler.getSize())
            recycler.children<SearchScreen.Item> { title { containsText("q") } }
        }
    }

    @Test
    fun searchSingle() {
        val searchString = "Swin"
        SearchScreen {
            editSearch.typeText(searchString)
            btnSearch.click()
            Assert.assertEquals(1, recycler.getSize())
            recycler {
                firstChild<SearchScreen.Item> {
                    isVisible()
                    title { containsText(searchString) }
                }
            }
        }
    }

    @Test
    fun clearSearch() {
        val searchString = "Swin"
        SearchScreen {
            editSearch.typeText(searchString)
            btnSearch.click()
            Assert.assertEquals(1, recycler.getSize())
            btnClear.click()
            Assert.assertEquals(30, recycler.getSize())
            editSearch.hasEmptyText()
        }
    }

    @Test
    fun clickOnItem() {
        Intents.init()
        val searchString = "Swin"
        SearchScreen {
            editSearch.typeText(searchString)
            btnSearch.click()
            recycler {
                swipeDown()
                lastChild<SearchScreen.Item> { click() }
            }
            KIntent {
                hasExtra("Item name", "345 - 2 Handed Kettlebell Swing")
            }.intended()
        }
    }

}