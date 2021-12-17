package org.sopt.androidassignment1.ui.onboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidassignment1.databinding.FragmentOnBoard3Binding
import org.sopt.androidassignment1.ui.account.LogInActivity

class OnBoardFragment3 : Fragment() {
    private var _binding: FragmentOnBoard3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoard3Binding.inflate(layoutInflater, container, false)

        binding.btnNext.setOnClickListener {
            val intent = Intent(context, LogInActivity::class.java)

            // back stack 돌아가지 않도록
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(intent)
        }

        return binding.root
    }
}