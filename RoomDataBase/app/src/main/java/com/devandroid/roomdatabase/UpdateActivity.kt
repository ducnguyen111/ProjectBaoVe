package com.devandroid.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.devandroid.roomdatabase.databinding.ActivityUpdateBinding
import com.devandroid.roomdatabase.model.MC
import com.devandroid.roomdatabase.model.User
import com.devandroid.roomdatabase.viewmodel.SViewModel

class UpdateActivity : AppCompatActivity() {
    private val binding by lazy { ActivityUpdateBinding.inflate(layoutInflater) }
    private val noteViewModel: SViewModel by lazy {
        ViewModelProvider(
            this,
            SViewModel.sViewModelFactory(this.application)
        )[SViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val user = intent.getSerializableExtra("UPDATE_USER") as MC
        binding.edtNoteTitle.setText(user.title)
        binding.edtNoteDes.setText(user.value)
        binding.textView2.isChecked = user.check
        binding.btnUpdate.setOnClickListener {
            user.title = binding.edtNoteTitle.text.toString()
            user.value = binding.edtNoteDes.text.toString()
            user.check = binding.textView2.isChecked
            noteViewModel.updateUser(user)
            finish()
        }
    }
}