package com.example.apppracticatecnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apppracticatecnica.Servicio.APIService
import com.example.apppracticatecnica.Servicio.User
import com.example.apppracticatecnica.Servicio.UserAdapter
import com.example.apppracticatecnica.databinding.ActivityAgregarBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AgregarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgregarBinding
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnR = findViewById<Button>(R.id.btnR)

        btnR.setOnClickListener { verificarLlamado(); validarVF()}
        //borrar
    }

    fun verificarLlamado(){
        val api = retrofit.create(APIService::class.java)
        api.obtenerUsuarios().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                obtenerUsuarios(response.body()!!)
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("String", "Error")
            }

        })
    }
    fun obtenerUsuarios(datos:List<User>){
        var bandera:Boolean = false
        var idObtenida = binding.etId.text.toString()
        for (element in datos){
            if(idObtenida == element.id.toString()) {
                Toast.makeText(this, "Ya esta registrado", Toast.LENGTH_SHORT).show()
                bandera = true
                break
            }
        }
        if (!bandera && binding.etId.text.isNotEmpty() && !binding.cbVerdadero.isChecked || !binding.cbFalso.isChecked){
            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show()
        }
    }

    fun validarVF(){
        if (binding.cbVerdadero.isChecked && binding.cbFalso.isChecked){
            Toast.makeText(this, "No puedes tener V y F seleccionados, selecciona solo 1", Toast.LENGTH_SHORT).show()
        }
    }
}