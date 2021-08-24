package com.example.apppracticatecnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppracticatecnica.Servicio.APIService
import com.example.apppracticatecnica.Servicio.User
import com.example.apppracticatecnica.Servicio.UserAdapter
import com.example.apppracticatecnica.databinding.ActivityListaUsuariosBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaUsuarios : AppCompatActivity() {

    private lateinit var binding: ActivityListaUsuariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios)
        cargarLista()
    }


    //Accede al url, obteniendo el json y parseandolo. Ademas ejecuta el metodo mostrarLista
    fun cargarLista(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIService::class.java)
        api.obtenerUsuarios().enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                mostrarLista(response.body()!!)
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("String", "Error")
            }

        })
    }

    //En proceso
    private fun mostrarLista(users: List<User>) {
        val recy = findViewById<RecyclerView>(R.id.recy)
        recy.apply{
            layoutManager = LinearLayoutManager(this@ListaUsuarios)
            adapter = UserAdapter(users)
        }
    }
}