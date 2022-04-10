package org.sopt.android_hyorim_30th.ui.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.SecondActivity
import org.sopt.android_hyorim_30th.databinding.ActivitySignInBinding
import org.sopt.android_hyorim_30th.util.shortToast

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val signInViewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
    }

    private fun initViewModel() {
        binding.viewModel = signInViewModel
        binding.lifecycleOwner = this
    }

    fun moveToHome(view: View) {
        if (signInViewModel.isInputComplete) {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            shortToast(getString(R.string.login_success))
        } else {
            shortToast(getString(R.string.check_id_pw))
        }
    }

}