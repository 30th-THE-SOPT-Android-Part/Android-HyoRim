package org.sopt.android_hyorim_30th.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.ActivityMainBinding
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.android_hyorim_30th.ui.main.camera.CameraFragment
import org.sopt.android_hyorim_30th.ui.main.home.HomeFragment
import org.sopt.android_hyorim_30th.ui.main.profile.ProfileFragment

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var mainViewPagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        setViewPagerFragment()
    }

    private fun initAdapter() {
        binding.vpMain.adapter = MainViewPagerAdapter(this).also { mainViewPagerAdapter = it }
    }

    private fun setViewPagerFragment() {
        mainViewPagerAdapter.fragmentList =
            listOf(ProfileFragment(), HomeFragment(), CameraFragment())
    }
}
