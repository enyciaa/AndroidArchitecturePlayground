package com.example.myapplication.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.services.GithubRepoEntity
import kotlinx.android.synthetic.main.recycler_row.view.*

class MainAdapter(
        private val listener: (GithubRepoEntity) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var items: List<GithubRepoEntity> = listOf()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent?.context)
        val view: View = layoutInflater.inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
            holder: ViewHolder,
            position: Int
    ) {
        holder.bind(items[position], listener)
    }

    fun addAll(items: List<GithubRepoEntity>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(
                repository: GithubRepoEntity,
                listener: (GithubRepoEntity) -> Unit
        ) {
            with(itemView) {
                r_main_txt.text = repository.name
                setOnClickListener { listener(repository) }
            }
        }
    }
}