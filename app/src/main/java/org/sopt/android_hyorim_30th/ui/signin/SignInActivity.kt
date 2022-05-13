package org.sopt.android_hyorim_30th.ui.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.ActivitySignInBinding
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.android_hyorim_30th.ui.main.MainActivity
import org.sopt.android_hyorim_30th.ui.signup.SignUpActivity
import org.sopt.android_hyorim_30th.ui.signup.SignUpActivity.Companion.KEY_ID
import org.sopt.android_hyorim_30th.ui.signup.SignUpActivity.Companion.KEY_PW
import org.sopt.android_hyorim_30th.util.shortToast

@AndroidEntryPoint
class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private val signInViewModel: SignInViewModel by viewModels()
    private lateinit var signInActivityLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingViewModel()
        initActivityLauncher()
    }

    private fun bindingViewModel() {
        binding.viewModel = signInViewModel
        binding.lifecycleOwner = this
    }

    private fun initActivityLauncher() {
        signInActivityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                when (it.resultCode) {
                    Activity.RESULT_OK -> setDataFromSignUp(it.data)
                    Activity.RESULT_CANCELED -> shortToast(getString(R.string.cancel_sign_up))
                    else -> shortToast("문제가 발생했습니다 : $it")
                }
            }
    }

    private fun setDataFromSignUp(data: Intent?) {
        signInViewModel.userId.postValue(data?.getStringExtra(KEY_ID) ?: "")
        signInViewModel.userPw.postValue(data?.getStringExtra(KEY_PW) ?: "")
    }

    fun initSignInBtnClick(view: View) {
        if (signInViewModel.isInputComplete) {
            signInViewModel.setPreference()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            shortToast(getString(R.string.login_success))
        } else shortToast(getString(R.string.check_id_pw))
    }

    fun initSignUpBtnClick(view: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        signInActivityLauncher.launch(intent)
    }

    fun onClickSaveId(view: View) {
        signInViewModel.toggleSaveId()
        signInViewModel.isIdLoadedAuto.observe(this) {
            if (it) shortToast(getString(R.string.auto_save_id))
        }
    }
}
