package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val userList = MutableLiveData<ArrayList<User>>().apply {
        value = arrayListOf()
    }

    fun addUser() {
        userList.value?.add(
            User(
                "Nguyễn Tân",
                "Đây là giới thiệu của Nguyễn Tân",
                R.drawable.ic_launcher_foreground
            )
        )
    }

}