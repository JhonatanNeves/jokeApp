package com.example.jokeapp.presentation

import com.example.jokeapp.data.JokeCallback
import com.example.jokeapp.data.JokeDayRemoteDataSource
import com.example.jokeapp.data.JokeRemoteDataSource
import com.example.jokeapp.model.Joke
import com.example.jokeapp.view.JokeDayFragment
import com.example.jokeapp.view.JokeFragment

class JokeDayPresenter (
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : JokeCallback {

    fun findRandom(){
        view.showProgress()
        dataSource.findRandom(this)
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