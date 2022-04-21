package org.sopt.android_hyorim_30th.ui.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.ActivitySignUpBinding
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.android_hyorim_30th.ui.signin.SignInActivity
import org.sopt.android_hyorim_30th.util.shortToast

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            }.also { setResult(RESULT_OK, it) }
            finish()
        } else shortToast(getString(R.string.malformed_data))
    }

    companion object {
        const val KEY_ID = "id"
        const val KEY_PW = "password"
    }
}
