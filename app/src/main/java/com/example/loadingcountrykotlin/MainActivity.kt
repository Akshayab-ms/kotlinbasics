package com.example.loadingcountrykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loadingcountrykotlin.Adapter.LAdapter
import com.example.loadingcountrykotlin.ViewModel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: LAdapter
    var rc_list=findViewById<RecyclerView>(R.id.listRecyclerview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()


        initRecyclerView()
    }
    private fun initRecyclerView(){
        rc_list.layoutManager=LinearLayoutManager(this)
        adapter= LAdapter(this)
       rc_list.adapter=adapter
    }
    private fun initViewModel(){
        val viewModel:MainActivityViewModel =ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLivedataObserver().observe(this, Observer{
            if(it!=null){
                adapter.setCountryList(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }
}