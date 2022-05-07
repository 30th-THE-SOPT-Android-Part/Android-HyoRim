package org.sopt.android_hyorim_30th.ui.main.camera

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.FragmentCameraBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment
import org.sopt.android_hyorim_30th.ui.main.MainViewModel

class CameraFragment : BaseFragment<FragmentCameraBinding>(R.layout.fragment_camera) {
    private val mainViewModel: MainViewModel by activityViewModels()
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                mainViewModel.setImageFromGallery(uri)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        initBtnClickListener()
    }

    private fun initBtnClickListener() {
        binding.btnAppend.setOnClickListener {
            resultLauncher.launch("image/*")
        }
    }
}
