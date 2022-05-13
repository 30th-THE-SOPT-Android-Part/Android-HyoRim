package org.sopt.android_hyorim_30th.ui.main.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class GitTabViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    private val _fragmentList = mutableListOf<Fragment>()
    var fragmentList: List<Fragment> = _fragmentList
        set(value) {
            _fragmentList.addAll(value)
        }

    override fun getItemCount(): Int = _fragmentList.size
    override fun createFragment(position: Int): Fragment = _fragmentList[position]
}
