package com.example.livedata

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModels()

    private lateinit var userAdapter: UserAdapter
    private lateinit var rvUser: RecyclerView
    private lateinit var btnAddUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setView()
        setEvent()

        setupUserRecyclerView()

        observeLiveData()
    }

    private fun observeLiveData() {
        mainViewModel.userListAddPosition.observe(this) {newUserListAddPosition ->
            System.out.println("data changed!!!")
            userAdapter.notifyItemInserted(newUserListAddPosition)
        }

        mainViewModel.userListRemovePosition.observe(this) {newUserListRemovePosition ->
            userAdapter.notifyItemRemoved(newUserListRemovePosition)
            userAdapter.notifyItemRangeChanged(newUserListRemovePosition, mainViewModel.userList.size)
        }
    }

    private fun setupUserRecyclerView() {
        userAdapter = UserAdapter(this, mainViewModel.userList)

        rvUser.adapter = userAdapter
        rvUser.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
    }

    private fun setEvent() {
        btnAddUser.setOnClickListener {
            mainViewModel.addUser()
        }
    }

    private fun setView() {
        rvUser = findViewById(R.id.rvUser)
        btnAddUser = findViewById(R.id.btnAdd)
    }
}