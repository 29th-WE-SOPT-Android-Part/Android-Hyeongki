package org.sopt.androidassignment1

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
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
        val decoration = CustomDecoration(1.0f, 0.0f, rgb(221,226,229))
        binding.rvFollower.addItemDecoration(decoration)

        followerViewAdapter = FollowerViewAdapter()

        binding.rvFollower.adapter = followerViewAdapter

        followerViewAdapter.datalist.addAll(
            listOf(
                TripleData("김형기", "YB 29기 김형기", getString(R.string.img_url_test)),
                TripleData("고틀린", "코틀린의 달인", getString(R.string.img_url_test)),
                TripleData("김자바", "자바는 내 인생", getString(R.string.img_url_test)),
                TripleData("이안드", "안드로이드 최고", getString(R.string.img_url_test)),
                TripleData("박알고", "알고리즘 마스터", getString(R.string.img_url_test))
            )
        )
        followerViewAdapter.notifyDataSetChanged()

        ItemTouchHelper(ItemTouchHelperCallback(followerViewAdapter)).attachToRecyclerView(binding.rvFollower)

    }


}