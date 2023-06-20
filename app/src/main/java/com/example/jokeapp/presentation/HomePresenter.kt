package com.example.jokeapp.presentation

import android.os.Handler
import android.os.Looper
import com.example.jokeapp.model.Category
import com.example.jokeapp.view.CategoryItem

class HomePresenter {

    fun findAllCategories(){
        fakeRequest()
    }

    private fun fakeRequest(){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(

                    Category("Categoria 1", 0xff422a89),
                    Category("Categoria 2", 0xff594096),
                    Category("Categoria 3", 0xff6f56a3),
                    Category("Categoria 4", 0xff846cb0)
                )

        }, 2000)
    }

}