package org.sopt.android_hyorim_30th.ui.home.gitFollower.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.android_hyorim_30th.data.GitFollowerData
import org.sopt.android_hyorim_30th.databinding.ItemGitFollowerBinding

class GitFollowerAdapter(
    private val onItemClick: ((GitFollowerData) -> Unit)
) : ListAdapter<GitFollowerData, GitFollowerAdapter.ViewHolder>(GitFollowerComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGitFollowerBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val follower = getItem(position)
        holder.bind(follower, onItemClick)
    }

    class ViewHolder(
        private val binding: ItemGitFollowerBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(follower: GitFollowerData, onItemClick: ((GitFollowerData) -> Unit)) {
            binding.gitFollowerData = follower
            binding.root.setOnClickListener { onItemClick(follower) }
        }
    }

    private class GitFollowerComparator : DiffUtil.ItemCallback<GitFollowerData>() {
        override fun areItemsTheSame(oldItem: GitFollowerData, newItem: GitFollowerData) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: GitFollowerData, newItem: GitFollowerData) =
            oldItem == newItem
    }
}
