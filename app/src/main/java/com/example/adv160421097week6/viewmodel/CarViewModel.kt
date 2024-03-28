package com.example.adv160421097week6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160421097week6.model.Car
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CarViewModel(application: Application) : AndroidViewModel(application) {
    val carsLD = MutableLiveData<ArrayList<Car>>()
    val carLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    init {
        queue = Volley.newRequestQueue(application)
    }

    fun refresh() {
        loadingLD.value = true
        carLoadErrorLD.value = false

        queue?.let { queue ->
            val url = "http://localhost/cars/cars.json"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    val carType = object : TypeToken<List<Car>>() {}.type
                    val result = Gson().fromJson<List<Car>>(response, carType)
                    carsLD.value = result as ArrayList<Car>?
                    loadingLD.value = false
                    Log.d("showvoley", "Response: $response") // Log the response from the server
                    Log.d("showvoley", "Parsed Result: $result") // Log the parsed result
                },
                { error ->
                    Log.d("showvoley", "Error: $error") // Log any error that occurred
                    carLoadErrorLD.value = true
                    loadingLD.value = false
                })

            stringRequest.tag = TAG
            queue.add(stringRequest)
        }
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}
