package com.example.apppracticatecnica.Servicio

import com.example.apppracticatecnica.Servicio.User
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/todos")
    fun obtenerUsuarios(): Call<List<User>>
}