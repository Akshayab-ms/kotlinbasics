package com.example.loadingcountrykotlin.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loadingcountrykotlin.R
import com.example.loadingcountrykotlin.data.CountryList

class LAdapter(val activity: Activity) : RecyclerView.Adapter<LAdapter.MyViewHolder>(){


    private var countryList:List<CountryList>?=null
    fun setCountryList(countryLists: List<CountryList>) {
        this.countryList=countryList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

val view =LayoutInflater.from(parent.context).inflate(R.layout.list_row,parent,false)
    return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
holder.bind(countryList?.get(position)!!,activity)    }

    override fun getItemCount(): Int {
        if(countryList==null)return 0
        else return countryList?.size!!

    }
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){

        val textViewid: TextView = view.findViewById(R.id.tv_id)
        val textViewbody: TextView = view.findViewById(R.id.tv_body)
        val textViewuserid: TextView = view.findViewById(R.id.tv_userid)
        val textViewttl: TextView = view.findViewById(R.id.tv_title)
        fun bind(data:CountryList,activity: Activity){
            textViewid.text="id"+data.id
            textViewuserid.text="userid"+data.userId
            textViewbody.text="body"+data.body
            textViewttl.text="title"+data.title

        }
    }




}