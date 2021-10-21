package org.sopt.androidassignment1

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidassignment1.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    private lateinit var followerViewAdapter: FollowerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)

        initAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        val decoration = CustomDecoration(1.0f, 0.5f, rgb(246,88,166))
        binding.rvFollower.addItemDecoration(decoration)

        followerViewAdapter = FollowerViewAdapter()

        binding.rvFollower.adapter = followerViewAdapter

        followerViewAdapter.datalist.addAll(
            listOf(
                PairData("김형기", "YB 29기 김형기"),
                PairData("고틀린", "코틀린의 달인"),
                PairData("김자바", "자바는 내 인생"),
                PairData("이안드", "안드로이드 최고"),
                PairData("박알고", "알고리즘 마스터")
            )
        )
        followerViewAdapter.notifyDataSetChanged()

        ItemTouchHelper(ItemTouchHelperCallback(followerViewAdapter)).attachToRecyclerView(binding.rvFollower)

    }

}