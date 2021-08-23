package com.example.apppracticatecnica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apppracticatecnica.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnList.setOnClickListener { controlList() }
        binding.btnAgg.setOnClickListener { controlAgg() }
        binding.btnDesc.setOnClickListener { desconectarse() }
    }

    fun controlList(){
        val intent = Intent(this, ListaUsuarios::class.java)
        startActivity(intent)
    }

    fun controlAgg(){
        val intent = Intent(this, AgregarActivity::class.java)
        startActivity(intent)
    }

    fun desconectarse(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}