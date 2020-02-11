package com.smartherd.nikechallenge.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartherd.nikechallenge.R
import com.smartherd.nikechallenge.adapters.UrbanAdapter
import com.smartherd.nikechallenge.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var definitionsAdapter: UrbanAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing variables
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setObservables()
        definitionsAdapter = UrbanAdapter()
        with(rvDefinitions) {
            layoutManager = LinearLayoutManager(context)
            adapter = definitionsAdapter
        }

        btnSearch.setOnClickListener {
            viewModel.defineTerm(etSearchQuery.text.toString())
        }
    }

    private fun setObservables() {
        viewModel.responseList.observe(this, Observer {
            Toast.makeText(
                this,
                "Got a response for  ${it.first().word}",
                Toast.LENGTH_SHORT
            ).show()
            definitionsAdapter.loadDefinitions(it)
        })
    }
}