package org.sopt.android_hyorim_30th.ui.main.camera

import android.os.Bundle
import android.view.View
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.FragmentCameraBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment

class CameraFragment : BaseFragment<FragmentCameraBinding>(R.layout.fragment_camera) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this
    }
}
