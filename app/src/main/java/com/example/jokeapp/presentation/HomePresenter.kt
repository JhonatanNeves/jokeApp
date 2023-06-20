package com.example.jokeapp.presentation

import android.os.Handler
import android.os.Looper
import com.example.jokeapp.model.Category
import com.example.jokeapp.view.CategoryItem
import com.example.jokeapp.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {

    fun findAllCategories() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response: List<String>) {

        val categories = response.map { Category(it, 0xf000000) }

        view.showCategories(categories)
    }

    fun onComplete() {
        view.hideProgress()
    }

    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(

                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4"
            )

            onSuccess(response)
            onComplete()

        }, 2000)
    }

}