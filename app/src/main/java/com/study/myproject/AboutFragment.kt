package com.study.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AboutFragment : Fragment() {

    lateinit var developersRecyclerView: RecyclerView
    lateinit var website_button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        val developersNames: List<String> = listOf("Natalia", "Maxim")

        website_button = view.findViewById(R.id.website_button)
        developersRecyclerView = view.findViewById(R.id.developers_recycler_view)
        developersRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        developersRecyclerView.adapter = DeveloperAdapter(developersNames)



        website_button.setOnClickListener {
            val link = Uri.parse("https://google.com/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }
        return view
    }


}