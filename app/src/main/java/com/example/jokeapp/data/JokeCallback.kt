package com.example.jokeapp.data

import com.example.jokeapp.model.Joke

interface JokeCallback {

    fun onSuccess(response: Joke)

    fun onError(response: String)

    fun onComplete()

}