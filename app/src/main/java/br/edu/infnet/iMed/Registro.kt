package br.edu.infnet.iMed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*

class Registro : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val botaoRegistro: Button = findViewById(R.id.prosseguir)
        botaoRegistro.setOnClickListener{validarPaciente()}
    }

    private fun validarPaciente() {

        val campoNome = findViewById<EditText>(R.id.nome_registro).text.toString()
        val campoCpf = findViewById<EditText>(R.id.cpf_registro).text.toString()
        val campoEmail = findViewById<EditText>(R.id.email_registro).text.toString()
        val campoSenha = findViewById<EditText>(R.id.senha_registro).text.toString()
        val campoConvenio = findViewById<EditText>(R.id.convenio_registro).text.toString()
        val campoTelefone = findViewById<EditText>(R.id.telefone_registro).text.toString()

        val camposVazios = campoNome.isEmpty() || campoCpf.isEmpty() ||
                campoEmail.isEmpty() || campoSenha.isEmpty() ||
                campoConvenio.isEmpty() || campoTelefone.isEmpty()

        if (camposVazios) {
            Toast.makeText(applicationContext, "Você não preencheu todos os campos", Toast.LENGTH_SHORT).show()
        }
        else {
            lerDados(campoCpf)
        }
    }
    private fun lerDados(cpf: String) {
        database = FirebaseDatabase.getInstance().getReference("Usuários")
        database.child(cpf).get().addOnSuccessListener {

            if (!it.exists()) {
                salvarDados()

            }
            else {
                Toast.makeText(applicationContext, "O CPF digitado já existe", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(applicationContext, "Falha nos sistemas", Toast.LENGTH_SHORT).show()
        }
    }

    private fun salvarDados() {

        val campoNome = findViewById<EditText>(R.id.nome_registro).text.toString()
        val campoCpf = findViewById<EditText>(R.id.cpf_registro).text.toString()
        val campoEmail = findViewById<EditText>(R.id.email_registro).text.toString()
        val campoSenha = findViewById<EditText>(R.id.senha_registro).text.toString()
        val campoConvenio = findViewById<EditText>(R.id.convenio_registro).text.toString()
        val campoTelefone = findViewById<EditText>(R.id.telefone_registro).text.toString()

        database = FirebaseDatabase.getInstance().getReference("Usuários")
        val usuario = DataUsuario(campoNome, campoEmail, campoSenha, campoCpf, campoConvenio, campoTelefone)
        database.child(campoCpf).setValue(usuario)

        Toast.makeText(applicationContext, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show()
    }
}
