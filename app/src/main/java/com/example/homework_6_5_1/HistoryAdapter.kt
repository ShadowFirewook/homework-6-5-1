package com.example.homework_6_5_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.homework_6_5_1.databinding.ItemHistoryBinding

class HistoryAdapter(
    private var list: ArrayList<String> = arrayListOf()
): Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding): ViewHolder(binding.root){
        fun bind(text:String){
            binding.tvOperation.text = text
        }
    }

}