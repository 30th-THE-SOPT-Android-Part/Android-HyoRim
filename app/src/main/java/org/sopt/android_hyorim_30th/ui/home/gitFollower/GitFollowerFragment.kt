package org.sopt.android_hyorim_30th.ui.home.gitFollower

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.GitFollowerData
import org.sopt.android_hyorim_30th.databinding.FragmentGitFollowerBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment
import org.sopt.android_hyorim_30th.ui.detail.DetailActivity
import org.sopt.android_hyorim_30th.ui.detail.DetailActivity.Companion.GIT_DATA

class GitFollowerFragment :
    BaseFragment<FragmentGitFollowerBinding>(R.layout.fragment_git_follower) {
    private lateinit var gitFollowerAdapter: GitFollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        binding.rvFollower.adapter =
            GitFollowerAdapter(::onItemClick).also { gitFollowerAdapter = it }
        gitFollowerAdapter.submitList(
            listOf(
                GitFollowerData(MINION1, "김효림", "내이름"),
                GitFollowerData(MINION2, "김효람", "이렇게 불릴 때도 있음"),
                GitFollowerData(MINION3, "비버", "닮은 동물"),
                GitFollowerData(MINION1, "루피", "닮은 캐릭터(?)"),
                GitFollowerData(MINION2, "리사이클러뷰 테스트", "스크롤 확인용 데이터")
            )
        )
    }

    private fun onItemClick(follower: GitFollowerData) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(GIT_DATA, follower)
        startActivity(intent)
    }

    companion object {
        const val MINION1 =
            "https://mblogthumb-phinf.pstatic.net/20151026_131/ddazero_1445793805984ouRO8_JPEG/dave1.jpg?type=w800"
        const val MINION2 =
            "https://mblogthumb-phinf.pstatic.net/20151026_41/ddazero_1445794370582RDrBz_JPEG/Stuart.jpg?type=w800"
        const val MINION3 =
            "https://mblogthumb-phinf.pstatic.net/20151026_132/ddazero_14457954455582SYuc_JPEG/Kevin_the_minions_2015.jpg?type=w2"
    }
}
