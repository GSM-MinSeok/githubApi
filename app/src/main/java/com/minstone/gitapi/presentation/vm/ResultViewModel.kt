package com.minstone.gitapi.presentation.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minstone.gitapi.data.api.RetorfitBuilder
import com.minstone.gitapi.data.dto.GithubData
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel(){

    private val _userInfo = MutableLiveData<GithubData>()

    val userInfo: LiveData<GithubData>
        get() = _userInfo

    fun searchUser(username: String){
        viewModelScope.launch {
            val response = RetorfitBuilder.getUsers(username)
            if (response.code() == 200) {
                Log.d("testt_vm",response.body().toString())
                _userInfo.value = response.body()
            }
        }
    }

}
