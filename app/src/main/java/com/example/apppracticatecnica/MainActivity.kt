package com.example.apppracticatecnica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apppracticatecnica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnIngresar.setOnClickListener {control()}
    }

    //Controla el inicio de sesion de que los campos esten bien digilenciados
    fun control(){
        //Accede el usuario
        if(binding.etCuenta.text.isNotEmpty() && binding.etCuenta.text.contains("@") && binding.etCuenta.text.contains(".com") && binding.etContra.text.isNotEmpty()){
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "El correo es erróneo o la contraseña es incorrecta", Toast.LENGTH_SHORT).show()
        }
    }
}