package com.smartherd.nikechallenge.view.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.nikechallenge.R
import com.smartherd.nikechallenge.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing variables
        val user_text: EditText = findViewById(R.id.ed_Text)
        val search: Button = findViewById(R.id.btn_Search)
        val recycleview: RecyclerView = findViewById(R.id.recycle)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        search.setOnClickListener {
            viewModel.definTerm(user_text.text.toString())
        }
        setOobservables()


    }

    private fun setOobservables() {
        viewModel.responseList.observe(this, Observer {
            Toast.makeText(this,
                "Got a response for  ${it.list.first().word}",
                Toast.LENGTH_SHORT).show()
        })
    }


}
