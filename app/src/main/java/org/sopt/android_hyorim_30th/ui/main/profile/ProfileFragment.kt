package org.sopt.android_hyorim_30th.ui.main.profile

import android.os.Bundle
import android.view.View
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.FragmentProfileBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this
    }
}
