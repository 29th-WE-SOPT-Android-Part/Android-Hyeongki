package org.sopt.androidassignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        followerViewAdapter = FollowerViewAdapter()

        binding.rvFollower.adapter = followerViewAdapter

        followerViewAdapter.datalist.addAll(
            listOf(
                PairData("김형기", "YB 29기 김형기"),
                PairData("홍길동", "ㅇㄹ"),
                PairData("이정재", "쌍문동"),
                PairData("멋쟁이", "ㅇㄴㄹ")
            )
        )
        followerViewAdapter.notifyDataSetChanged()
    }

}