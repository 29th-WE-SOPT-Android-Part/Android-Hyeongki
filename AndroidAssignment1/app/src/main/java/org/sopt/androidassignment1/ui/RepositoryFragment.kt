package org.sopt.androidassignment1.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidassignment1.config.CustomDecoration
import org.sopt.androidassignment1.adpater.RepositoryViewAdapter
import org.sopt.androidassignment1.databinding.FragmentRepositoryBinding
import org.sopt.androidassignment1.model.TripleData

class RepositoryFragment : Fragment() {
    private var _binding: FragmentRepositoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var repositoryViewAdapter: RepositoryViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)

        initAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        val decoration = CustomDecoration(1.0f, 0.0f, Color.rgb(221, 226, 229))
        binding.rvRepository.addItemDecoration(decoration)

        repositoryViewAdapter = RepositoryViewAdapter()

        binding.rvRepository.adapter = repositoryViewAdapter

        repositoryViewAdapter.dataList.addAll(
            listOf(
                TripleData("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                TripleData("알고리즘 레포지토리", "백준 알고리즘 공부"),
                TripleData("코틀린 과제 레포지토리", "코틀린 스터디 과제"),
                TripleData("서버 레포지토리", "스프링 공부"),
                TripleData("DB 레포지토리", "SQL 공부"),
                TripleData("프로젝트 레포지토리", "안드로이드 개발 팀 프로젝트")
            )
        )
    }
}