package com.example.githubuserlaila.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.githubuserlaila.R
import com.example.githubuserlaila.databinding.FragmentFollowBinding

class FollowingFragment : Fragment(R.layout.fragment_follow) {

    private var _binding: FragmentFollowBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFollowBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
