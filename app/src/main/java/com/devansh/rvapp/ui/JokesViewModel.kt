package com.devansh.rvapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devansh.rvapp.repository.JokesRepository
import kotlinx.coroutines.*

class JokesViewModel constructor(private val jokesRepository: JokesRepository) : ViewModel() {
    val setup = MutableLiveData<String>()
    val delivery = MutableLiveData<String>()
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
            val response = jokesRepository.getJoke()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    setup.value = response.body()?.setup
                    delivery.value = response.body()?.delivery
                    Log.d("##" , response.body().toString())
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