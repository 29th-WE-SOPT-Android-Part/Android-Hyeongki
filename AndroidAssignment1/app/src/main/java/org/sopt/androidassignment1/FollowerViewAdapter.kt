package org.sopt.androidassignment1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidassignment1.databinding.ItemListFollowerBinding

class FollowerViewAdapter: RecyclerView.Adapter<FollowerViewAdapter.FollowerViewHolder>(), ItemTouchHelperListener {
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
            binding.itemFollower.setOnClickListener { v:View ->
                val intent = Intent(v.context, DetailActivity::class.java)
                intent.putExtra("name", data.name)
                v.context.startActivity(intent)
            }

        }
    }

    override fun onItemMove(from_position: Int, to_position: Int): Boolean {
        val item = datalist[from_position]
        datalist.removeAt(from_position)
        datalist.add(to_position, item)

        notifyDataSetChanged()
        return true
    }

    override fun onItemSwipe(position: Int) {
        datalist.removeAt(position)
        notifyItemRemoved(position)
    }


}