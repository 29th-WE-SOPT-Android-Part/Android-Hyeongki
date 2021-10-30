package org.sopt.androidassignment1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidassignment1.databinding.ItemListRepositoryBinding

class RepositoryViewAdapter: RecyclerView.Adapter<RepositoryViewAdapter.RepositoryViewHolder>() {
    var dataList = mutableListOf<TripleData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryViewAdapter.RepositoryViewHolder {
        var binding = ItemListRepositoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RepositoryViewAdapter.RepositoryViewHolder,
        position: Int
    ) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    class RepositoryViewHolder(private val binding: ItemListRepositoryBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(data: TripleData){
            binding.tvRepositoryName.text = data.name
            binding.tvRepositoryIntroduction.text = data.introduction
        }
    }
}



