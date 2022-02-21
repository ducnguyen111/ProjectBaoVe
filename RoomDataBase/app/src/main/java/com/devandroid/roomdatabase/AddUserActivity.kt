package com.devandroid.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.devandroid.roomdatabase.databinding.ActivityAddUserBinding
import com.devandroid.roomdatabase.model.MC
import com.devandroid.roomdatabase.model.User
import com.devandroid.roomdatabase.viewmodel.SViewModel


class AddUserActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddUserBinding.inflate(layoutInflater) }
    private val noteViewModel: SViewModel by lazy {
        ViewModelProvider(
            this,
            SViewModel.sViewModelFactory(this.application)
        )[SViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            val user= MC(binding.edtNoteTitle.text.toString(),binding.edtNoteDes.text.toString(),binding
                .bt.isChecked)
            noteViewModel.insertUser(user)
            Log.d("Add",binding.edtNoteTitle.text.toString()+"   "+ binding.edtNoteDes.text.toString())
            finish()
        }
    }
}