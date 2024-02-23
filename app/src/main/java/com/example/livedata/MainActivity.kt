package com.example.livedata

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setView()
    }

    private fun setView() {
        userAdapter = UserAdapter(mainViewModel.userList.value!!)

        rvUser = findViewById(R.id.rvUser)
        rvUser.adapter = userAdapter
        rvUser.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
    }
}