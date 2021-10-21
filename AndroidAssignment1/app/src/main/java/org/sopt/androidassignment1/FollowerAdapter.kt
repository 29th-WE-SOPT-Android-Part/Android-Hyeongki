package org.sopt.androidassignment1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidassignment1.databinding.FragmentFollowerBinding
import org.sopt.androidassignment1.databinding.ItemListFollowerBinding

class FollowerAdapter: RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val followerlist = mutableListOf<FollowerData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerAdapter.FollowerViewHolder {
        var binding = ItemListFollowerBinding.inflate(
            LayoutInflater.from(parent.context), parent,false
        )
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerAdapter.FollowerViewHolder, position: Int) {
        holder.onBind(followerlist[position])
    }

    override fun getItemCount(): Int = followerlist.size

    class FollowerViewHolder(private val binding: ItemListFollowerBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(data: FollowerData){
            binding.tvFollowerName.text = data.name
            binding.tvFollowerIntroduction.text = data.introduction
        }
    }

}