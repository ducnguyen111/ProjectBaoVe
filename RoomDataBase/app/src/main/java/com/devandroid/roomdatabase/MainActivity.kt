package com.devandroid.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devandroid.roomdatabase.databinding.ActivityMainBinding
import com.devandroid.roomdatabase.model.MC
import com.devandroid.roomdatabase.viewmodel.SViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val noteViewModel: SViewModel by lazy {
        ViewModelProvider(
            this,
            SViewModel.sViewModelFactory(this.application)
        )[SViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            binding
                .root
        )
        initEvents()
        initControls()
    }

    private fun initEvents() {
        binding.btnOpenAddActivity.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initControls() {
        val adapter: Adapter = Adapter(this@MainActivity, onItemClick, onItemDelete)
        binding.rvNote.setHasFixedSize(true)
        binding.rvNote.layoutManager = LinearLayoutManager(this)
        binding.rvNote.adapter = adapter

        noteViewModel.getAllUser().observe(this, Observer {
            it?.let {
                adapter.setUser(it)
                if (it.isEmpty()) {
                    noteViewModel.initdata()
                }
            }
        })

    }

    private val onItemClick: (MC) -> Unit = {
        val intent = Intent(this, UpdateActivity::class.java)
        intent.putExtra("UPDATE_USER", it)
        startActivity(intent)
    }
    private val onItemDelete: (MC) -> Unit = {
        noteViewModel.deleleUser(it)
    }

}


