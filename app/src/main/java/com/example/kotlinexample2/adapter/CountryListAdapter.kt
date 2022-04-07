package com.example.kotlinexample2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexample2.R
import com.example.kotlinexample2.model.CountryListModel
import com.squareup.picasso.Picasso

class CountryListAdapter : RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private var countryList : List<CountryListModel>? = null

    fun setCountryList(countryList : List<CountryListModel>?){

        this.countryList = countryList

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(countryList?.get(position)!!)

    }

    override fun getItemCount(): Int {
        if (countryList == null) return 0
        else return countryList?.size!!
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val flagImage = view.findViewById<ImageView>(R.id.flagId)
        val commonName = view.findViewById<TextView>(R.id.commonNameId)
        val officialName = view.findViewById<TextView>(R.id.officialNameId)

        fun bind(data : CountryListModel){

            commonName.text = "Common Name : ${data.name?.common}"
            officialName.text = "Official Name : ${data.name?.official}"

            Picasso.get()
                .load(data.flags?.png)
                .into(flagImage)



        }

    }
}