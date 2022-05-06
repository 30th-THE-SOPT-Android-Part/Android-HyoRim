package org.sopt.android_hyorim_30th.ui.main

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
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
        syncVpWithBottomNav()
    }

    private fun initAdapter() {
        binding.vpMain.adapter = MainViewPagerAdapter(this).also { mainViewPagerAdapter = it }
    }

    private fun setViewPagerFragment() {
        mainViewPagerAdapter.fragmentList =
            listOf(ProfileFragment(), HomeFragment(), CameraFragment())
    }

    private fun syncVpWithBottomNav() {
        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })

        binding.bottomNav.setOnItemSelectedListener {
            val position = when (it.itemId) {
                R.id.menu_profile -> 0
                R.id.menu_home -> 1
                R.id.menu_camera -> 2
                else -> return@setOnItemSelectedListener false
            }
            Log.d(TAG, "syncVpWithBottomNav: $position")
            binding.vpMain.setCurrentItem(position, false)
            return@setOnItemSelectedListener true
        }
    }
}
