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
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = GroupieAdapter()
        recyclerView.adapter = adapter

        adapter.add(CategoryItem(Category("Categoria 1", 0xff565656)))
        adapter.add(CategoryItem(Category("Categoria 2", 0xff505050)))
        adapter.add(CategoryItem(Category("Categoria 3", 0xff494949)))
        adapter.add(CategoryItem(Category("Categoria 4", 0xff434343)))

        adapter.notifyDataSetChanged()
    }

}