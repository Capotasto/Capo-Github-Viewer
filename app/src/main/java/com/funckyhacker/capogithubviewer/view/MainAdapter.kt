package com.funckyhacker.capogithubviewer.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.funckyhacker.capogithubviewer.databinding.ItemMainBinding
import com.funckyhacker.capogithubviewer.event.ClickItemEvent
import com.funckyhacker.capogithubviewer.model.User
import org.greenrobot.eventbus.EventBus

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var users: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val linearBinding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(linearBinding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun setData(users: List<User>){
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    fun getLastItem() : User? {
        return users.last()
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
            //Use call back
            EventBus.getDefault().post(ClickItemEvent(user))
        }
    }

}
