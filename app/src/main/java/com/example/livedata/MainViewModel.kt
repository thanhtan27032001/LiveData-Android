package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var userList: ArrayList<User> = arrayListOf()

    val userListAddPosition = MutableLiveData<Int>().apply {
        value = 0
    }

    val userListRemovePosition = MutableLiveData<Int>().apply {
        value = 0
    }

    fun addUser() {
        System.out.println("add new user")
        userListAddPosition.value = userList.size
        userList.add(
            User(
                "Nguyễn Tân ${userListAddPosition.value}",
                "Đây là giới thiệu của Nguyễn Tân",
                R.drawable.ic_launcher_foreground
            )
        )
    }

    fun removeUser(position: Int) {
        System.out.println("remove postion $position")
        userListRemovePosition.value = position
        userList.removeAt(position)
    }

}