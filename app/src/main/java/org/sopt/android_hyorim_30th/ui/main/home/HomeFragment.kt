package org.sopt.android_hyorim_30th.ui.main.home

import android.os.Bundle
import android.view.View
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.FragmentHomeBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this
    }
}
