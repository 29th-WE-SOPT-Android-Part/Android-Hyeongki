package org.sopt.androidassignment1.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidassignment1.R
import org.sopt.androidassignment1.databinding.FragmentOnBoard1Binding

class OnBoardFragment1 : Fragment() {
    private var _binding: FragmentOnBoard1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoard1Binding.inflate(layoutInflater, container, false)

        return binding.root
    }

}