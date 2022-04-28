package org.sopt.android_hyorim_30th.ui.home.gitFollower

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.android_hyorim_30th.data.GitFollowerData

class GitFollowerViewModel : ViewModel() {
    private var _follower = MutableLiveData<List<GitFollowerData>?>()
    val follower: LiveData<List<GitFollowerData>?> = _follower

    init {
        _follower.value = listOf(
            GitFollowerData(
                "https://mblogthumb-phinf.pstatic.net/20151026_131/ddazero_1445793805984ouRO8_JPEG/dave1.jpg?type=w800",
                "김효림",
                "나야나~ ".repeat(30)
            ),
            GitFollowerData(
                "https://mblogthumb-phinf.pstatic.net/20151026_41/ddazero_1445794370582RDrBz_JPEG/Stuart.jpg?type=w800",
                "이창환",
                "맷돼지"
            ),
            GitFollowerData(
                "https://mblogthumb-phinf.pstatic.net/20151026_132/ddazero_14457954455582SYuc_JPEG/Kevin_the_minions_2015.jpg?type=w2",
                "문다빈",
                "문콩"
            ),
            GitFollowerData(
                "https://mblogthumb-phinf.pstatic.net/20151026_131/ddazero_1445793805984ouRO8_JPEG/dave1.jpg?type=w800",
                "문명주",
                "알미남 ".repeat(10)
            ),
            GitFollowerData(
                "https://mblogthumb-phinf.pstatic.net/20151026_41/ddazero_1445794370582RDrBz_JPEG/Stuart.jpg?type=w800",
                "조재훈",
                "밥은 먹고 다니냐? 요즘 뭐하고 사냐? ".repeat(2)
            ),
            GitFollowerData(
                "https://mblogthumb-phinf.pstatic.net/20151026_132/ddazero_14457954455582SYuc_JPEG/Kevin_the_minions_2015.jpg?type=w2",
                "이호재",
                "휘파람으로 화음넣기 장인 ".repeat(2)
            )
        )
    }
}
