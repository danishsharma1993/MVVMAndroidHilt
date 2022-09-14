package com.example.practicemvvm.mvvm_without_dagger.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicemvvm.databinding.LoginListItemBinding
import com.example.practicemvvm.mvvm_without_dagger.data.model.response.LoginItem
import com.example.practicemvvm.mvvm_without_dagger.ui.base.BaseViewHolder

class MyLoginAdapter(
    val loginList: List<LoginItem>
) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        val loginListItemBinding =
            LoginListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoginListItemViewHolder(loginListItemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        return holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return loginList.size
    }

    inner class LoginListItemViewHolder(private val loginListItemBinding: LoginListItemBinding) :
        BaseViewHolder(itemView = loginListItemBinding.root) {

        override fun onBind(position: Int) {
            val loginItem = loginList[position]
            loginListItemBinding.name = loginItem.name
            loginListItemBinding.age = loginItem.age
            loginListItemBinding.executePendingBindings()
            itemView.setOnClickListener {
                Log.d("--observer--", "item clicked")
            }
        }
    }
}