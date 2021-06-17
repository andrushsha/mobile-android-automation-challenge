package com.example.android.gymondoautomationtest.screens

import android.view.View
import com.example.android.gymondoautomationtest.ListActivity
import com.example.android.gymondoautomationtest.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object SearchScreen : KScreen<SearchScreen>() {

    override val layoutId = R.layout.activity_list
    override val viewClass = ListActivity::class.java

    val editSearch = KEditText { withId(R.id.editTxtSearch) }
    val btnSearch = KButton {
        withId(R.id.btnSearch)
        withDrawable(R.drawable.ic_search_black_24dp)
    }
    val btnClear = KButton {
        withId(R.id.btnClear)
        withDrawable(R.drawable.ic_clear_black_24dp)
    }

    val recycler: KRecyclerView = KRecyclerView({
        withId(R.id.recycler_view)
    }, itemTypeBuilder = {
        itemType(::Item)
    })

    class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val title: KTextView = KTextView { withMatcher(parent) }
    }

}