package org.sopt.android_hyorim_30th.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.SecondActivity
import org.sopt.android_hyorim_30th.databinding.ActivitySignUpBinding
import org.sopt.android_hyorim_30th.util.shortToast

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val signUpViewModel : SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
    }

    private fun initViewModel() {
        binding.viewModel = signUpViewModel
        binding.lifecycleOwner = this
    }

    private fun backToLogin(view : View){
        if (signUpViewModel.isInputComplete) {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            shortToast(getString(R.string.login_success))
        } else shortToast(getString(R.string.check_id_pw))
    }
}