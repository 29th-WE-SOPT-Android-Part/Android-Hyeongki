package org.sopt.androidassignment1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidassignment1.databinding.ItemListFollowerBinding

class FollowerViewAdapter: RecyclerView.Adapter<FollowerViewAdapter.FollowerViewHolder>() {
    val datalist = mutableListOf<PairData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerViewAdapter.FollowerViewHolder {
        var binding = ItemListFollowerBinding.inflate(
            LayoutInflater.from(parent.context), parent,false
        )
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewAdapter.FollowerViewHolder, position: Int) {
        holder.onBind(datalist[position])
    }

    override fun getItemCount(): Int = datalist.size

    class FollowerViewHolder(private val binding: ItemListFollowerBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(data: PairData){
            binding.tvFollowerName.text = data.name
            binding.tvFollowerIntroduction.text = data.introduction
        }
    }


}