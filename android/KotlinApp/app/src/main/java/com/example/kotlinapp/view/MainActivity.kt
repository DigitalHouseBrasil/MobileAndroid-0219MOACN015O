package com.example.kotlinapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.R
import com.example.kotlinapp.model.Filme
import com.example.kotlinapp.view.adapter.FilmeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val adapter = FilmeAdapter(getFilmes())
//        recyclerViewFilmes.adapter = adapter
//        recyclerViewFilmes.layoutManager = LinearLayoutManager(this)
//
       entendendoChamadaSegura()
    }


    private fun getFilmes(): MutableList<Filme> {
        val lista = mutableListOf<Filme>()

        lista.add(Filme("JOKER", 0, "TESTE JOKER"))
        lista.add(Filme("LA CASA DE PAPEL", null, null))

        return lista
    }

    private fun entendendoChamadaSegura(){
        val nome =  "joao"
        val outroNome: String? = nome

        Toast.makeText(this, "${outroNome?.length} teste", Toast.LENGTH_LONG).show()

    }
}
