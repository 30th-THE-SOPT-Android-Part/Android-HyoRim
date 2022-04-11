package org.sopt.android_hyorim_30th.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.android_hyorim_30th.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater).also{setContentView(it.root)}
        initViewModel()
    }

    private fun initViewModel() {
        binding.viewModel = homeViewModel
        binding.lifecycleOwner = this
    }
}