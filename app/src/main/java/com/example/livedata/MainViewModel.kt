package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var userList: ArrayList<User>

    val userListSize = MutableLiveData<Int>().apply {
        value = 0
        userList = arrayListOf()
    }

    fun addUser() {
        System.out.println("add new user")
        userList.add(
            User(
                "Nguyễn Tân",
                "Đây là giới thiệu của Nguyễn Tân",
                R.drawable.ic_launcher_foreground
            )
        )
        userListSize.value = userList.size
    }

}