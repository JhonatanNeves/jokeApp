package com.example.jokeapp.presentation

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import com.example.jokeapp.data.CategoryRemoteDataSource
import com.example.jokeapp.data.ListCategoryCallback
import com.example.jokeapp.model.Category
import com.example.jokeapp.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val start = 257
        val end = 267
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
               0.75f,
                0.55f,
            )

            Category(s, Color.HSVToColor(hsv).toLong()) }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}