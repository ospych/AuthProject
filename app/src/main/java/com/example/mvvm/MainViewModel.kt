package com.example.mvvm

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.RequestRegister
import com.example.mvvm.models.ResponseRegister
import com.example.mvvm.repository.Repository
import com.example.mvvm.utils.SharedPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = Repository()

    val shared_pref = SharedPreference(App.instance.applicationContext)
    val user: MutableLiveData<ResponseRegister> = MutableLiveData()

    fun getUser(string: RequestRegister){
        CoroutineScope(Dispatchers.IO).launch {
            repository.getUser(string).let {
                if (it.isSuccessful) {
                    user.postValue(it.body())
                    shared_pref.userToken = it.body()?.token
                }
            }
        }
    }
}