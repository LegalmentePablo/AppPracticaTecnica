package com.example.apppracticatecnica.Servicio

import com.example.apppracticatecnica.Servicio.User
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    //Obtiene toda la lista de usuarios registrados en el json
    @GET("/todos")

    //Realiza el llamado de todos los usuarios y carga a los usuarios en la lista obteniendo la estructura desde la clase User
    fun obtenerUsuarios(): Call<List<User>>
}