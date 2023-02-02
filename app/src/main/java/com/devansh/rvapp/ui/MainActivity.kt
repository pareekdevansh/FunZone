package com.devansh.rvapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.devansh.rvapp.R
import com.devansh.rvapp.api.RetrofitBuilder
import com.devansh.rvapp.repository.JokesRepository
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val jokesRepository = JokesRepository(RetrofitBuilder())
        var job: Job? = CoroutineScope(Dispatchers.IO).launch {
            val response = jokesRepository.getJoke()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    Log.d("##", response.body().toString())
                    Log.d("##", response.body()?.setup.toString())
                    Log.d("##", response.body()?.delivery.toString())
                } else {
                    Log.d("##", "Error: ${response.message()}")
                }
            }
        }
    }

}

