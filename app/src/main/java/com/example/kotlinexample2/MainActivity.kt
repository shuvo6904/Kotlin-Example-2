package com.example.kotlinexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinexample2.adapter.CountryListAdapter
import com.example.kotlinexample2.databinding.ActivityMainBinding
import com.example.kotlinexample2.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerAdapter : CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()

    }


    private fun initRecyclerView() {

        binding.countryListRecycler.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = CountryListAdapter()
        binding.countryListRecycler.adapter = recyclerAdapter

    }

    private fun initViewModel() {
        val viewModel : MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){
                recyclerAdapter.setCountryList(it)
                recyclerAdapter.notifyDataSetChanged()
            } else{
                Toast.makeText(this, "Error in getting list", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()

    }

}