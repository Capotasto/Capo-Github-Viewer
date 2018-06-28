package com.funckyhacker.capogithubviewer.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.funckyhacker.capogithubviewer.databinding.ItemMainBinding
import com.funckyhacker.capogithubviewer.model.User

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var users: List<User>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val linearBinding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(linearBinding)
    }

    override fun getItemCount(): Int {
        return if (users == null) 0 else users!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users!![position])
    }

    fun setData(users: List<User>){
        this.users = users
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var user: User

        fun bind(user: User) {
            this.user = user
            binding.user = user
            binding.viewHolder = this
            binding.executePendingBindings()
        }

        fun onClickItem() {
            //EventBus.getDefault().post(ClickItemEvent(file))
        }
    }

}
