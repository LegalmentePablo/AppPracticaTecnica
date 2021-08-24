package com.example.apppracticatecnica.Servicio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apppracticatecnica.R


class UserAdapter(private val users: List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    //Crea el Viewholder en el layout user_row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)
        return ViewHolder(view)
    }

    //Implementa el ViewHolder y carga la información de los usuarios
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user= users[position]
        holder.userId.text = "  UserId: " + user.userId.toString()
        holder.id.text = "  Id: " +user.id.toString()
        holder.title.text = "  Title: " + user.title
        holder.completed.text = "  Completed: " + user.completed.toString()
    }

    //Retorna el tamaño de la lista users
    override fun getItemCount(): Int {
        return users.size
    }


    //Se conecta las val mediante la id del xml user_row
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userId: TextView = itemView.findViewById(R.id.userId)
        val id: TextView = itemView.findViewById(R.id.id)
        val title: TextView = itemView.findViewById(R.id.title)
        val completed: TextView = itemView.findViewById(R.id.completed)
    }
}