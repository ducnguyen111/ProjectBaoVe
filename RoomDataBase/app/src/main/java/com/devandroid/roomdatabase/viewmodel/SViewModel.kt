package com.devandroid.roomdatabase.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.devandroid.roomdatabase.model.MC
import com.devandroid.roomdatabase.model.User
import com.devandroid.roomdatabase.repository.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SViewModel(application: Application) : ViewModel() {
    private val userRepository = Repository(application)

    init {
    //initdata()
    }

    fun insertUser(user: MC) = viewModelScope.launch {
        userRepository.insert(user)
    }

    fun updateUser(user: MC) = viewModelScope.launch {
        userRepository.update(user)
    }

    fun deleleUser(user: MC) = viewModelScope.launch {
        userRepository.delete(user)
    }

    fun getAllUser(): LiveData<MutableList<MC>> {
        var a = userRepository.getAllUser()
        return a
    }

    class sViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SViewModel(application) as T
            }
            throw IllegalArgumentException("Unable construct viewModel")
        }
    }

    fun initdata() {
        insertUser(MC("4", "4",true))
    }


}