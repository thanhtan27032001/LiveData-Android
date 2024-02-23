package com.example.livedata

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

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
        mainViewModel.userListSize.observe(this, Observer {
            System.out.println("data changed!!!")
            userAdapter.notifyDataSetChanged()
        })
    }

    private fun setupUserRecyclerView() {
        userAdapter = UserAdapter(mainViewModel.userList)

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