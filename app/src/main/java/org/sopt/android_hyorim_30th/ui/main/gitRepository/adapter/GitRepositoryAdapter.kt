package org.sopt.android_hyorim_30th.ui.main.gitRepository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.android_hyorim_30th.data.GitRepositoryData
import org.sopt.android_hyorim_30th.databinding.ItemGitRepositoryBinding

class GitRepositoryAdapter(
    private val onItemClick: ((GitRepositoryData) -> Unit)
) : ListAdapter<GitRepositoryData, GitRepositoryAdapter.ViewHolder>(GitRepositoryComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGitRepositoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = getItem(position)
        holder.bind(repository, onItemClick)
    }

    class ViewHolder(
        private val binding: ItemGitRepositoryBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: GitRepositoryData, onItemClick: ((GitRepositoryData) -> Unit)) {
            binding.data = repository
            binding.root.setOnClickListener { onItemClick(repository) }
        }
    }

    private class GitRepositoryComparator : DiffUtil.ItemCallback<GitRepositoryData>() {
        override fun areItemsTheSame(oldItem: GitRepositoryData, newItem: GitRepositoryData) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: GitRepositoryData, newItem: GitRepositoryData) =
            oldItem == newItem
    }
}
