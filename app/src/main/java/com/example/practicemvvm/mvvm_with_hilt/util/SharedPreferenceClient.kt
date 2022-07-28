package com.example.practicemvvm.mvvm_with_hilt.util

import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferenceClient(private val sharedPreferences: SharedPreferences) {
    private val EMAIL = "email"
    private val IS_PAID_USER = "is_paid_user"
    private val AGE = "age"

    fun setEmail(email: String) {
        sharedPreferences.edit(commit = true) {
            putString(EMAIL, email)
        }
    }

    fun getEmail(): String? {
        return sharedPreferences.getString(EMAIL, "")
    }

    fun setIsPaidUser(isPaidUser: Boolean) {
        sharedPreferences.edit(commit = true) {
            putBoolean(IS_PAID_USER, isPaidUser)
        }
    }

    fun getIsPaidUser(): Boolean {
        return sharedPreferences.getBoolean(IS_PAID_USER, false)
    }

    fun setAge(age: Int) {
        sharedPreferences.edit(commit = true) {
            putInt(AGE, age)
        }
    }

    fun getAge(): Int {
        return sharedPreferences.getInt(AGE, -1)
    }
}