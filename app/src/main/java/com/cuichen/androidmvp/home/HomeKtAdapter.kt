package com.cuichen.androidmvp.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuichen.androidmvp.R

/**
 * Author: "ChenboCui"
 * Date: 2021/3/30
 */
class HomeKtAdapter(private val context: Context, private var items : MutableList<String>) : RecyclerView.Adapter<HomeKtAdapter.VH>() {

    fun setDatas(datas : MutableList<String>?){
        if (datas == null)
            items = mutableListOf()
        items = datas!!
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.item , parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tv.text = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv = itemView.findViewById<TextView>(R.id.tv)
    }
}