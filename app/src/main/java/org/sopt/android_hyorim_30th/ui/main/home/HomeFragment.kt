package org.sopt.android_hyorim_30th.ui.main.home

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.FragmentHomeBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var gitTabHostVPAdapter: GitTabViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this
        initAdapter()
        setViewPagerFragment()
        initTabLayout()
    }

    private fun initAdapter() {
        binding.vpHome.adapter =
            GitTabViewPagerAdapter(this).also { gitTabHostVPAdapter = it }
    }

    private fun setViewPagerFragment() {
        gitTabHostVPAdapter.fragmentList = listOf(TempFragment1(), TempFragment2())
    }

    private fun initTabLayout() {
        val tabLabel = listOf(getString(R.string.following), getString(R.string.follower))

        TabLayoutMediator(binding.tlHome, binding.vpHome) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }
}
