package com.devansh.rvapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.devansh.rvapp.R
import com.devansh.rvapp.api.RetrofitBuilder
import com.devansh.rvapp.repository.ActivityRepository
import com.devansh.rvapp.repository.JokesRepository
import com.devansh.rvapp.repository.MemeRepository
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val jokesRepository = JokesRepository(RetrofitBuilder())
        val activityRepository = ActivityRepository(RetrofitBuilder())
        var job1: Job? = CoroutineScope(Dispatchers.IO).launch {
            val response = jokesRepository.getJoke()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    Log.d("#1", response.body().toString())
                    Log.d("#1", response.body()?.setup.toString())
                    Log.d("#1", response.body()?.delivery.toString())
                } else {
                    Log.d("#1", "Error: ${response.message()}")
                }
            }
        }
        var job2: Job? = CoroutineScope(Dispatchers.IO).launch {
            val response = activityRepository.getActivity()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("#2", response.body().toString())
                    Log.d("#2", response.body()?.activity.toString())
                } else {
                    Log.d("#2", "Error: ${response.message()}")
                }
            }
        }

        val job3 : Job? = CoroutineScope(Dispatchers.IO).launch {
            val response = MemeRepository(RetrofitBuilder()).getMemes()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    Log.d("#3" , response.body()?.data.toString())
                }
                else{
                    Log.d("#3" , "Error : ${response.message()}")

                }
            }
        }
    }

}



