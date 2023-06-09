package com.example.jokeapp.presentation

import com.example.jokeapp.data.JokeCallback
import com.example.jokeapp.data.JokeRemoteDataSource
import com.example.jokeapp.model.Joke
import com.example.jokeapp.view.JokeFragment

class JokePresenter (
    private val view: JokeFragment,
            private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun findBy(categoryName: String){
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}