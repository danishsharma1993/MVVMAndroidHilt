package com.example.practicemvvm.mvvm_without_dagger.ui.view

import android.os.Bundle
import android.view.View
import com.example.practicemvvm.databinding.FragmentLoginBinding
import com.example.practicemvvm.mvvm_without_dagger.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = ""
    }
}