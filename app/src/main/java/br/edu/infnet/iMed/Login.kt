package br.edu.infnet.iMed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registroPaciente: TextView = findViewById(R.id.paciente)
        registroPaciente.setOnClickListener{

            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
            finish()
        }
    }
}