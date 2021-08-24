package com.example.apppracticatecnica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.apppracticatecnica.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnList.setOnClickListener { accederList() }
        binding.btnAgg.setOnClickListener { accederAgg() }
        binding.btnDesc.setOnClickListener { desconectarse() }
    }

    //Accede a la vista ListaUsuarios
    fun accederList(){
        val intent = Intent(this, ListaUsuarios::class.java)
        startActivity(intent)
    }
    //Accede a la vista AgregarActivity
    fun accederAgg(){
        val intent = Intent(this, AgregarActivity::class.java)
        startActivity(intent)
    }
    //Desconecta al usuario enviandolo a la vista MainActivity
    fun desconectarse(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}