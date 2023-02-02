package com.devansh.rvapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devansh.rvapp.repository.ActivityRepository
import kotlinx.coroutines.*

class ActivityViewModel constructor(private val activityRepository : ActivityRepository ) : ViewModel() {
    val activity = MutableLiveData<String>()
    val participants = MutableLiveData<Int>()
    val link = MutableLiveData<String>()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    val exceptionHandler = CoroutineExceptionHandler{_ , throwable ->
        onError("Exception Handled : ${throwable.localizedMessage}")
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    var job : Job? = null
    fun getJoke(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler ).launch {
            val response = activityRepository.getActivity()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    activity.value = response.body()?.activity
                    participants.value = response.body()?.participants
                    link.value = response.body()?.link
                    Log.d("##" , response.body().toString())
                    Log.d("##" , response.body()?.activity.toString())
                    loading.value = false
                }
                else{
                    onError("Error: ${response.message()}")
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}