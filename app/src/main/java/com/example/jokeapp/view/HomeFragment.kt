package com.example.jokeapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokeapp.R
import com.example.jokeapp.model.Category
import com.example.jokeapp.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    private lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        presenter.findAllCategories()

        val adapter = GroupieAdapter()
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()
    }

}