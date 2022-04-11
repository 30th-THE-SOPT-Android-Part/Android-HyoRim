package org.sopt.android_hyorim_30th.ui.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.ActivitySignUpBinding
import org.sopt.android_hyorim_30th.ui.signin.SignInActivity
import org.sopt.android_hyorim_30th.util.shortToast

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater).also{setContentView(it.root)}
        initViewModel()
    }

    private fun initViewModel() {
        binding.viewModel = signUpViewModel
        binding.lifecycleOwner = this
    }

    fun initSignUpCompleteBtnClick(view: View) {
        if (signUpViewModel.isInputComplete) {
            Intent(this, SignInActivity::class.java).apply {
                putExtra(KEY_ID, signUpViewModel.userId.value)
                putExtra(KEY_PW, signUpViewModel.userPw.value)
                setResult(RESULT_OK, this)
            }
            if (!isFinishing) finish()
        } else shortToast(getString(R.string.malformed_data))
    }

    companion object {
        const val KEY_ID = "id"
        const val KEY_PW = "password"
    }
}