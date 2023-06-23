package com.example.jokeapp.presentation

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

        val categories = response.map { Category(it, 0xFF422A89) }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}