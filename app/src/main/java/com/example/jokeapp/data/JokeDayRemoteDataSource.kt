package com.example.jokeapp.data

import com.example.jokeapp.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeDayRemoteDataSource {
    fun findRandom(callback: JokeCallback){
        HTTPClient.retroffit()
            .create(ChuckNorrisAPI::class.java)
            .findRandom()
            .enqueue(object : Callback<Joke>{

                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if (response.isSuccessful) {
                        val joke = response.body()
                        callback.onSuccess(joke ?: throw java.lang.RuntimeException("Not Found"))
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Unknown Error")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Internal Error")
                    callback.onComplete()
                }

            })
    }
}